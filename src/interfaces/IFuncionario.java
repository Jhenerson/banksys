/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import entidades.Funcionario;
import java.util.Iterator;

/**
 *
 * @author jhene
 */
public interface IFuncionario {
    public void incluir(Funcionario funcionario) throws Exception;
    public Iterator listar() throws Exception;
    public void alterar(Funcionario funcionario) throws Exception;
    public void excluir(int id) throws Exception;
    public Funcionario consultar(int id) throws Exception;
    public Funcionario consultar(String login) throws Exception;
}
