/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.ClienteConta;
import entidades.Conta;
import interfaces.IClienteConta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author repez
 */
public class PClienteConta implements IClienteConta {

    @Override
    public void incluir(ClienteConta clienteConta) throws Exception {
        String sql = "INSERT INTO cliente_conta (id_cliente, id_conta, senha) VALUES (?,?,?);";
        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, clienteConta.getCliente().getId());
        prd.setInt(2, clienteConta.getConta().getId());
        prd.setString(3, clienteConta.getSenha());

        prd.execute();
        cnn.close();
    }

    @Override
    public Iterator listar() throws Exception {
        String sql = "SELECT * FROM cliente_conta";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        ArrayList<ClienteConta> retorno = new ArrayList();

        while (rs.next()) {
            ClienteConta cc = new ClienteConta();
            
            PConta pconta = new PConta();
            Conta conta = pconta.consultar(rs.getInt("id_conta"));
            cc.setConta(conta);
            
            PCliente pcliente = new PCliente();
            //Cliente cliente = pcliente.
            
            
            retorno.add(cc);
        }
        return retorno.iterator();
    }

    @Override
    public void alterar(ClienteConta clienteConta) throws Exception {
    }

    @Override
    public void excluir(int id) throws Exception {
    }

    @Override
    public ClienteConta consultar(int id) throws Exception {
        return null;
    }
    
}
