/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidades.Endereco;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author repez
 */
public class TesteCEP {
    public static void main(String[] args) {
        try {
            BuscaCEP busca = new BuscaCEP();
            String cep = "76720000";
            Endereco retorno = BuscaCEP.buscarCep(cep);
            
             
            System.out.println(retorno.getLogradouro());            
            System.out.println(retorno.getBairro());
            System.out.println("Cidade: "+retorno.getLocalidade());
            System.out.println("UF: "+retorno.getUf());
            
            
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
}
