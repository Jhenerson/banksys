/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Cliente;
import entidades.Funcionario;
import interfaces.IFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jhene
 */
public class PFuncionario implements IFuncionario{

    @Override
    public void incluir(Funcionario funcionario) throws Exception {
        String sql = "INSERT INTO funcionario "
                + "(nome,login,senha,endereco,telefone,email,data_contratacao,e_gerente,id_agencia,id_cidade)"
                + " VALUES (?,?,?,?,?,?,?,?,?);";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, funcionario.getNome());
        prd.setString(2, funcionario.getLogin());
        prd.setString(3, funcionario.getSenha());
        prd.setString(4, funcionario.getTelefone());
        prd.setString(5, funcionario.getEndereco());

        prd.execute();
        cnn.close();
    }

    @Override
    public ArrayList<Funcionario> listar() throws Exception {
         String sql = "SELECT * FROM funcionario";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        ArrayList<Funcionario> retorno = new ArrayList();

        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setCpf(rs.getInt("cpf"));
            cliente.setNome(rs.getString("nome"));
            cliente.setDataNascimento(rs.getDate("data_de_nascimento"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setTelefone(rs.getString("telefone"));
            retorno.add(cliente);
        }
        return retorno;
    }

    @Override
    public void alterar(Funcionario funcionario) throws Exception {
        String sql = "UPDATE funcionario SET cpf = ?, nome = ?, data_de_nascimento = ?, endereco = ?, telefone = ? WHERE cpf = ?";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setLong(1, cliente.getCpf());
        prd.setString(2, cliente.getNome());
        prd.setDate(3, cliente.getDataNascimento());
        prd.setString(4, cliente.getEndereco());
        prd.setString(5, cliente.getTelefone());
        prd.setLong(6, cliente.getCpf());

        //executa todo o comando e grava no banco de dados
        prd.execute();
        cnn.close();
    }

    @Override
    public void excluir(long cpf) throws Exception {
        String sql = "DELETE FROM cliente WHERE cpf = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setLong(1, cpf);
        prd.execute();
        cnn.close();
    }

    @Override
    public Funcionario consultar(long cpf) throws Exception {
         String sql = " SELECT * FROM cliente WHERE cpf = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setLong(1, cpf);

        ResultSet rs = prd.executeQuery();
        Funcionario retorno = new Funcionario();

        if (rs.next()) {
            retorno.setCpf(rs.getLong("cpf"));
            retorno.setNome(rs.getString("nome"));
            retorno.setDataNascimento(rs.getDate("data_de_nascimento"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
        }
        prd.execute();
        cnn.close();
        return retorno;
    }
    
}
