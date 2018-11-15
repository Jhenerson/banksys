/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Agencia;
import entidades.Cliente;
import entidades.Conta;
import java.util.ArrayList;

/**
 *
 * @author jhene
 */
public interface IConta {

    public void incluir(Conta conta) throws Exception;

    public ArrayList<Conta> listar() throws Exception;

    public void alterar(Conta conta) throws Exception;

    public void excluir(int parametro) throws Exception;
}
