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
import java.util.Iterator;

/**
 *
 * @author jhene
 */
public class PAgencia implements IAgencia {

    @Override
    public void incluir(Agencia agencia) throws Exception {
        String sql = "INSERT INTO agencia (codigo,endereco) VALUES (?,?);";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, agencia.getCodigo());
        prd.setString(2, agencia.getEndereco());
        prd.execute();
        cnn.close();
    }

    @Override
    public Iterator listar() throws Exception {
        String sql = "SELECT * FROM agencia";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        ArrayList<Agencia> retorno = new ArrayList();

        while (rs.next()) {
            Agencia ag = new Agencia();
            ag.setId(rs.getInt("id"));
            ag.setCodigo(rs.getString("codigo"));
            ag.setEndereco(rs.getString("endereco"));
            retorno.add(ag);
        }
        return retorno.iterator();
    }

    @Override
    public void alterar(Agencia agencia) throws Exception {
        String sql = "UPDATE agencia SET codigo = ?, endereco = ? WHERE id = ?";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, agencia.getCodigo());
        prd.setString(2, agencia.getEndereco());
        prd.setInt(3, agencia.getId());
        prd.execute();
        cnn.close();
    }

    @Override
    public void excluir(int parametro) throws Exception {
        String sql = "DELETE FROM agencia WHERE id = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        prd.execute();
        cnn.close();
    }

    @Override
    public Agencia consultar(int parametro) throws Exception {
        String sql = " SELECT * FROM agencia WHERE id = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        ResultSet rs = prd.executeQuery();
        Agencia retorno = new Agencia();
        if (rs.next()) {
            retorno.setCodigo(rs.getString("codigo"));
            retorno.setEndereco(rs.getString("endereco"));
        }       
        prd.execute();
        cnn.close();
        return retorno;
    }

}
