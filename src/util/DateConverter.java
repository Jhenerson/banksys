/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author repez
 */
public class DateConverter {
    public static String dataPt(String dataSql){
        
        String anoSql = dataSql.substring(0, 4);
        String mesSql = dataSql.substring(5, 7);
        String diaSql = dataSql.substring(8, 10);
        
        return diaSql+"/"+mesSql+"/"+anoSql;
    }
    
    public static String dataSql(String dataPt){
        
        String anoPt = dataPt.substring(6, 10);
        String mesPt = dataPt.substring(3, 5);
        String diaPt = dataPt.substring(0, 2);
        
        return anoPt+"/"+mesPt+"/"+diaPt;
    }
    
    public static String dataDoSistema(){
        Date dt = new Date();
        DateFormat df = DateFormat.getDateInstance();
        
        String data = df.format(dt);
        return data;
    }
}
