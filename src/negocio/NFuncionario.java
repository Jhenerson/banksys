/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Funcionario;
import java.sql.SQLException;
import java.util.Iterator;
import persistencia.PFuncionario;

/**
 *
 * @author rodolpho.repezza
 */
public class NFuncionario {
    
    PFuncionario persistencia;
    
    public NFuncionario() {
        this.persistencia = new PFuncionario();
    }

    public void salvar(Funcionario parametro) throws SQLException, Exception {

        if (parametro.getNome().isEmpty()) {
            throw new Exception("É necessário informar o nome");
        }
        
        if (parametro.getData_contratacao().toString().isEmpty()) {
            throw new Exception("É necessário informar o a data de contratação");
        }
        
        if (parametro.getEmail().isEmpty()) {
            throw new Exception("É necessário informar o e-mail");
        }
        
        if (parametro.getEndereco().isEmpty()) {
            throw new Exception("É necessário informar o endereço");
        }
        
        if (parametro.getTelefone().isEmpty()) {
            throw new Exception("É necessário informar o telefone");
        } 
        
        if (parametro.getLogin().isEmpty()) {
            throw new Exception("É necessário informar o login");
        } 
        
        if (parametro.getSenha().isEmpty()) {
            throw new Exception("É necessário informar a senha");
        } 
        
        if (parametro.getId() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }

    }

    public void excluir(int parametro) throws SQLException, Exception {
        persistencia.excluir(parametro);
    }

    public Funcionario consultar(int parametro) throws SQLException, Exception {
        return persistencia.consultar(parametro);        
    }
    
    public Funcionario consultar(String login) throws SQLException, Exception {
        return persistencia.consultar(login);        
    }
    
    public Iterator listar() throws SQLException, Exception {
        return persistencia.listar();
    }
    
}
