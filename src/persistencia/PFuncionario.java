/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Agencia;
import entidades.Funcionario;
import interfaces.IFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jhene
 */
public class PFuncionario implements IFuncionario{

    @Override
    public void incluir(Funcionario funcionario) throws Exception {
        String sql = "INSERT INTO funcionario "
                + "(nome,cpf,senha,endereco,telefone,email,data_contratacao,e_gerente,id_agencia)"
                + " VALUES (?,?,?,?,?,?,?,?,?);";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, funcionario.getNome());
        prd.setString(2, funcionario.getCpf());
        prd.setString(3, funcionario.getSenha());
        prd.setString(4, funcionario.getEndereco());
        prd.setString(5, funcionario.getTelefone());
        prd.setString(6, funcionario.getEmail());
        prd.setTimestamp(7, funcionario.getData_contratacao());
        prd.setBoolean(8, funcionario.isE_gerente());
        prd.setInt(9, funcionario.getAgencia().getId());
        prd.execute();
        cnn.close();
    }

    @Override
    public Iterator listar() throws Exception {
        String sql = "SELECT * FROM funcionario";
        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Funcionario> retorno = new ArrayList();
        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt("id"));
            funcionario.setEmail(rs.getString("email"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setData_contratacao(rs.getTimestamp("data_contratacao"));
            funcionario.setEndereco(rs.getString("endereco"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setSenha(rs.getString("senha"));
            funcionario.setE_gerente(rs.getBoolean("e_gerente"));
            
            PAgencia pa = new PAgencia();
            Agencia agencia = pa.consultar(rs.getInt("id_agencia"));
            
            funcionario.setAgencia(agencia);
            
            retorno.add(funcionario);
        }
        return retorno.iterator();
    }

    @Override
    public void alterar(Funcionario funcionario) throws Exception {
        String sql = "UPDATE funcionario SET "
                + "nome = ?,"
                + "telefone = ?,"
                + "email = ?,"
                + "data_contratacao = ?,"
                + "endereco = ?,"
                + "senha = ?,"
                + "cpf = ?,"
                + "e_gerente = ?,"
                + "id_agencia = ?"
                + "where id = ?";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, funcionario.getNome());
        prd.setString(2, funcionario.getTelefone());
        prd.setString(3, funcionario.getEmail());
        prd.setTimestamp(4, funcionario.getData_contratacao());
        prd.setString(5, funcionario.getEndereco());
        prd.setString(6, funcionario.getSenha());
        prd.setString(7, funcionario.getCpf());
        prd.setBoolean(8, funcionario.isE_gerente());
        prd.setInt(9, funcionario.getAgencia().getId());
        prd.setInt(10, funcionario.getId());

        prd.execute();
        cnn.close();
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM funcionario WHERE id = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, id);
        prd.execute();
        cnn.close();
    }

    @Override
    public Funcionario consultar(int id) throws Exception {
        String sql = "SELECT * FROM funcionario WHERE id = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, id);
        
        ResultSet rs = prd.executeQuery();
        Funcionario retorno = new Funcionario();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setNome(rs.getString("nome"));
            retorno.setData_contratacao(rs.getTimestamp("data_contratacao"));
            retorno.setEmail(rs.getString("email"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setSenha(rs.getString("senha"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setE_gerente(rs.getBoolean("e_gerente"));
            
            PAgencia pa = new PAgencia();
            Agencia agencia = pa.consultar(rs.getInt("id_agencia"));
            
            retorno.setAgencia(agencia);
        }
        cnn.close();
        return retorno;
    }

    @Override
    public Funcionario consultar(String cpf) throws Exception {
        String sql = "SELECT * FROM funcionario WHERE cpf = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, cpf);
        
        ResultSet rs = prd.executeQuery();
        Funcionario retorno = new Funcionario();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setNome(rs.getString("nome"));
            retorno.setData_contratacao(rs.getTimestamp("data_contratacao"));
            retorno.setEmail(rs.getString("email"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setSenha(rs.getString("senha"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setE_gerente(rs.getBoolean("e_gerente"));
            
            PAgencia pa = new PAgencia();
            Agencia agencia = pa.consultar(rs.getInt("id_agencia"));
            
            retorno.setAgencia(agencia);
        }
        cnn.close();
        return retorno;
    }
    
}
