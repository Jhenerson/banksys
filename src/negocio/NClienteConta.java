/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.ClienteConta;
import java.sql.SQLException;
import persistencia.PClienteConta;

/**
 *
 * @author repez
 */
public class NClienteConta {
    
    PClienteConta persistencia;
    
    public NClienteConta() {
        persistencia = new PClienteConta();
    }
    
    public void salvar(ClienteConta parametro) throws SQLException, Exception {

        if (parametro.getCliente().getId() == 0) {
            throw new Exception("É necessário informar o cliente.");
        }
        
        if (parametro.getConta().getId() == 0) {
            throw new Exception("É necessário informar a conta.");
        }
        
        if (parametro.getSenha().isEmpty()){
            throw new Exception("É necessário informar a senha.");
        }

        if (parametro.getId() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }

    }
}
