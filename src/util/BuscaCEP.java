/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author repez
 */
public class BuscaCEP {
    
    public static Endereco buscarCep(String cep) {
        Endereco endereco = null;
        String json;
        
        try {
            
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            if(connection.getResponseCode() == 200) {
                
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuilder jsonSb = new StringBuilder();
                br.lines().forEach(l -> jsonSb.append(l.trim()));
                json = jsonSb.toString();
                
                Map<String,String> map = new HashMap<>();

                Matcher matcher = Pattern.compile("\"\\D.*?\": \".*?\"").matcher(json);
                while (matcher.find()) {
                    String[] group = matcher.group().split(":");
                    map.put(group[0].replaceAll("\"", "").trim(), group[1].replaceAll("\"", "").trim());
                }
                
                endereco = new Endereco(
                        map.get("logradouro"),
                        map.get("complemento"),
                        map.get("bairro"),
                        map.get("localidade"),
                        map.get("uf")
                        );
                          
            } else {
                throw new Exception("CEP não encontrado!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }
    
}
