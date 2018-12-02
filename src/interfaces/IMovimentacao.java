/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Movimentacao;
import java.sql.Date;
import java.util.Iterator;

/**
 *
 * @author rodolpho.repezza
 */
public interface IMovimentacao {
    
    public void incluir(Movimentacao movimentacao) throws Exception;
    public Iterator getMovimentacoes(int idConta) throws Exception;
    public Iterator getMovimentacoes(Date inicio, Date fim) throws Exception;
}
