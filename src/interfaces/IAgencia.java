/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Agencia;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jhene
 */
public interface IAgencia {

    public void incluir(Agencia agencia) throws Exception;
    public Iterator listar() throws Exception;
    public void alterar(Agencia agencia) throws Exception;
    public void excluir(int id) throws Exception;
    public Agencia consultar(int id) throws Exception;
    public Agencia consultar(String codigo) throws Exception;
    
}
