/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Agencia;
import entidades.ClienteConta;
import java.util.Iterator;

/**
 *
 * @author repez
 */
public interface IClienteConta {
    
    public void incluir(ClienteConta clienteConta) throws Exception;
    public Iterator listar() throws Exception;
    public void alterar(ClienteConta clienteConta) throws Exception;
    public void excluir(int id) throws Exception;
    public ClienteConta consultar(int id) throws Exception;
    public ClienteConta consultar(int id_cliente, String senha) throws Exception;
       
}
