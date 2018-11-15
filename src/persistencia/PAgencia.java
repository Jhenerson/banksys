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
import java.util.ArrayList;

/**
 *
 * @author jhene
 */
public class PAgencia implements IAgencia {

    @Override
    public void incluir(Agencia agencia) throws Exception {
        String sql = "INSERT INTO agencia (numagencia,endereco,telefone) VALUES (?,?,?);";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Agencia agencia) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int parametro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
