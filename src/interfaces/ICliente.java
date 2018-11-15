/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Agencia;
import entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author jhene
 */
public interface ICliente {

    public void incluir(Cliente cliente) throws Exception;

    public ArrayList<Cliente> listar() throws Exception;

    public void alterar(Cliente cliente) throws Exception;

    public void excluir(int parametro) throws Exception;

}
