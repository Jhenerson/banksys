/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;


import entidades.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author jhene
 */
public interface IFuncionario {

    public void incluir(Funcionario funcionario) throws Exception;

    public ArrayList<Funcionario> listar() throws Exception;

    public void alterar(Funcionario funcionario) throws Exception;

    public void excluir(long cpf) throws Exception;
    
    public Funcionario consultar(long cpf) throws Exception;
}
