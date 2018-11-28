/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Conta;
import interfaces.IConta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jhene
 */
public class PConta implements IConta{

    @Override
    public void incluir(Conta conta) throws Exception {
          String sql = "INSERT INTO conta (cpf,nome,data_de_nascimento,telefone,endereco,email) VALUES (?,?,?,?,?,?);";
        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, cliente.getCpf());
        prd.setString(2, cliente.getNome());
        prd.setDate(3, cliente.getDataNascimento());
        prd.setString(4, cliente.getTelefone());
        prd.setString(5, cliente.getEndereco());
        prd.setString(6, cliente.getEmail());

        prd.execute();
        cnn.close();
    }

    @Override
    public Iterator listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Conta conta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int numeroConta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conta consultar(int numeroConta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
