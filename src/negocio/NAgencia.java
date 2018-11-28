/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Agencia;
import java.sql.SQLException;
import java.util.Iterator;
import persistencia.PAgencia;

/**
 *
 * @author repez
 */
public class NAgencia {
    
    PAgencia persistencia;
    
    public NAgencia() {
        persistencia = new PAgencia();
    }
    
    public void salvar(Agencia parametro) throws SQLException, Exception {

        if (parametro.getCodigo().isEmpty()) {
            throw new Exception("É necessário informar o código da agência.");
        }

        if (parametro.getEndereco().isEmpty()) {
            throw new Exception("É necessário informar o endereço da agência.");
        }
                
        if (parametro.getId() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }

    }

    public void excluir(int parametro) throws SQLException, Exception {
        persistencia.excluir(parametro);
    }

    public Agencia consultar(int parametro) throws SQLException, Exception {
        return persistencia.consultar(parametro);        
    }
   
    public Iterator listar() throws SQLException, Exception {
        return persistencia.listar();
    }
}
