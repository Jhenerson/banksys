/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import persistencia.PCliente;

/**
 *
 * @author repez
 */
public class NCliente {
    
    PCliente persistencia;

    public NCliente() {
        persistencia = new PCliente();
    }

    public void salvar(Cliente parametro) throws SQLException, Exception {

        if (parametro.getNome().isEmpty()) {
            throw new Exception("É necessário informar o nome");
        }
        
        if (parametro.getCpf().isEmpty()) {
            throw new Exception("É necessário informar o CPF");
        }
        
        if (parametro.getEmail().isEmpty()) {
            throw new Exception("É necessário informar o e-mail");
        }
        
        if (parametro.getEndereco().toString().isEmpty()) {
            throw new Exception("É necessário informar o endereço");
        }
        
        if (parametro.getTelefone().isEmpty()) {
            throw new Exception("É necessário informar o telefone");
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

    public Cliente consultar(int parametro) throws SQLException, Exception {
        return persistencia.consultar(parametro);        
    }
    
    public Cliente consultar(String nome) throws SQLException, Exception {
        return persistencia.consultar(nome);        
    }

    public Iterator listar() throws SQLException, Exception {
        return persistencia.listar();
    }
    
}
