/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Agencia;
import interfaces.IAgencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jhene
 */
public class PAgencia implements IAgencia {

    @Override
    public void incluir(Agencia agencia) throws Exception {
        String sql = "INSERT INTO agencia (numero_agencia,endereco,telefone) VALUES (?,?,?);";
        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, agencia.getNumAgencia());
        prd.setString(2, agencia.getEndereco());
        prd.setString(3, agencia.getTelefone());

        prd.execute();
        cnn.close();
    }

    @Override
    public ArrayList<Agencia> listar() throws Exception {
        String sql = "SELECT * FROM agencia";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        ArrayList<Agencia> retorno = new ArrayList();

        while (rs.next()) {
            Agencia ag = new Agencia();
            ag.setNumAgencia(rs.getInt("numero_agencia"));
            ag.setEndereco(rs.getString("endereco"));
            ag.setTelefone(rs.getString("telefone"));
            retorno.add(ag);
        }
        return retorno;
    }

    @Override
    public void alterar(Agencia agencia) throws Exception {
        String sql = "UPDATE agencia SET numero_agencia = ?, endereco = ?, telefone = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1, agencia.getNumAgencia());
        prd.setString(2, agencia.getEndereco());
        prd.setString(3, agencia.getTelefone());

        //executa todo o comando e grava no banco de dados
        prd.execute();
        cnn.close();
    }

    @Override
    public void excluir(int parametro) throws Exception {
        String sql = "DELETE FROM agencia WHERE numero_agencia = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        prd.execute();
        cnn.close();
    }

    @Override
    public Agencia consultar(int parametro) throws Exception {
       String sql = " SELECT * FROM agencia WHERE numero_agencia = ?;";

        Connection cnn = util.Conexao.getConexao();
        
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();
        Agencia retorno = new Agencia();
        if (rs.next()) {
            retorno.setNumAgencia(rs.getInt("numero_agencia"));
            retorno.setEndereco(rs.getString("endereco"));
            retorno.setTelefone(rs.getString("telefone"));
        }       
        prd.execute();
        cnn.close();
        return retorno;
    }

}
