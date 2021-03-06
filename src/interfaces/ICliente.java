/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import entidades.Cliente;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jhene
 */
public interface ICliente {

    public void incluir(Cliente cliente) throws Exception;

    public Iterator listar() throws Exception;

    public void alterar(Cliente cliente) throws Exception;

    public void excluir(int id) throws Exception;

    public Cliente consultarCPF(String cpf) throws Exception;
    
    public Cliente consultarID(int id) throws Exception;

}
