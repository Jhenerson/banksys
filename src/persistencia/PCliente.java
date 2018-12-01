/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Agencia;
import entidades.Cliente;
import interfaces.ICliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author jhene
 */
public class PCliente implements ICliente {

    @Override
    public void incluir(Cliente cliente) throws Exception {
        String sql = "INSERT INTO cliente (cpf,nome,data_de_nascimento,telefone,endereco,email) VALUES (?,?,?,?,?,?);";
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
        try {
            String sql = "SELECT * FROM cliente";

            Connection cnn = util.Conexao.getConexao();
            Statement st = cnn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            LinkedList<Cliente> retorno = new LinkedList();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDataNascimento(rs.getDate("data_de_nascimento"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));

                retorno.add(cliente);
            }

            retorno.sort(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Cliente c1 = (Cliente) o1;
                    Cliente c2 = (Cliente) o2;
                    return c1.getNome().compareToIgnoreCase(c2.getNome());
                }
            });
            return retorno.iterator();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void alterar(Cliente cliente) throws Exception {
        String sql = "UPDATE cliente SET cpf = ?, nome = ?, data_de_nascimento = ?, endereco = ?, telefone = ?, email = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, cliente.getCpf());
        prd.setString(2, cliente.getNome());
        prd.setDate(3, cliente.getDataNascimento());
        prd.setString(4, cliente.getEndereco());
        prd.setString(5, cliente.getTelefone());
        prd.setString(6, cliente.getEmail());
        prd.setInt(7, cliente.getId());

        //executa todo o comando e grava no banco de dados
        prd.execute();
        cnn.close();
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM cliente WHERE id = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setLong(1, id);
        prd.execute();
        cnn.close();
    }

    @Override
    public Cliente consultarCPF(String cpf) throws Exception {
        String sql = " SELECT * FROM cliente WHERE cpf = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, cpf);

        ResultSet rs = prd.executeQuery();
        Cliente retorno = new Cliente();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setNome(rs.getString("nome"));
            retorno.setDataNascimento(rs.getDate("data_de_nascimento"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setEmail(rs.getString("email"));
        }
        prd.execute();
        cnn.close();
        return retorno;
    }

    @Override
    public Cliente consultarID(int id) throws Exception {
        String sql = " SELECT * FROM cliente WHERE id = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setLong(1, id);

        ResultSet rs = prd.executeQuery();
        Cliente retorno = new Cliente();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setNome(rs.getString("nome"));
            retorno.setDataNascimento(rs.getDate("data_de_nascimento"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setEmail(rs.getString("email"));
        }
        prd.execute();
        cnn.close();
        return retorno;
    }

    public Cliente consultar(String nome) throws Exception {
        String sql = " SELECT * FROM cliente WHERE nome = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, nome);

        ResultSet rs = prd.executeQuery();
        Cliente retorno = new Cliente();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setCpf(rs.getString("cpf"));
            retorno.setNome(rs.getString("nome"));
            retorno.setDataNascimento(rs.getDate("data_de_nascimento"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setEmail(rs.getString("email"));
        }
        prd.execute();
        cnn.close();
        return retorno;
    }

}
