/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Movimentacao;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import persistencia.PMovimentacao;

/**
 *
 * @author rodolpho.repezza
 */
public class NMovimentacao {
    
    PMovimentacao persistencia;

    public NMovimentacao() {
        persistencia = new PMovimentacao();
    }

    public void salvar(Movimentacao parametro) throws SQLException, Exception {
        
        if(parametro.getCliente() == null)  {
            throw new Exception("É necessário informar o cliente.");
        }
        
        if(parametro.getConta() == null)  {
            throw new Exception("É necessário informar a conta.");
        }
        
        if(parametro.getData_hora() == null)  {
            throw new Exception("É necessário informar a data e hora da movimentação.");
        }
        
        if(parametro.getTipoMovimentacao() == 0)  {
            throw new Exception("É necessário informar o tipo da movimentação.");
        }
        
        if(parametro.getValor() == 0)  {
            throw new Exception("É necessário informar o valor da movimentação.");
        }
        
        persistencia.incluir(parametro);
       
    }
    
    public Iterator listar(int id_conta) throws SQLException, Exception {
        return persistencia.getMovimentacoes(id_conta);
    }
    
    public Iterator listar(Date inicio, Date fim) throws SQLException, Exception {
        return persistencia.getMovimentacoes(inicio, fim);
    }
             
}
