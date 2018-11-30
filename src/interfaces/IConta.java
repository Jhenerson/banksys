/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import entidades.Conta;
import java.util.Iterator;

/**
 *
 * @author jhene
 */
public interface IConta {

    public void incluir(Conta conta) throws Exception;
    public Iterator listar() throws Exception;
    public void alterar(Conta conta) throws Exception;
    public void excluir(int numeroConta) throws Exception;
    public Conta consultar(String numeroConta) throws Exception;
    public Conta consultar(int id) throws Exception;

}
