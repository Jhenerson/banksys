/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Cliente;
import entidades.Conta;
import entidades.Movimentacao;
import interfaces.IMovimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rodolpho.repezza
 */
public class PMovimentacao implements IMovimentacao{

    @Override
    public void incluir(Movimentacao movimentacao) throws Exception {
        String sql = "INSERT INTO movimentacao (data_hora, valor, tipo_movimentacao, id_conta, id_cliente) VALUES (?,?,?,?,?,?);";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setTimestamp(1, movimentacao.getData_hora());
        prd.setFloat(2, movimentacao.getValor());
        prd.setInt(3, movimentacao.getTipoMovimentacao());
        prd.setInt(4, movimentacao.getConta().getId());
        prd.setInt(5, movimentacao.getCliente().getId());
        prd.execute();
        cnn.close();
    }

    @Override
    public Iterator getMovimentacoes(int idConta) throws Exception {
        String sql = "SELECT * FROM movimentacao where id_conta = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, idConta);

        ResultSet rs = prd.executeQuery(sql);
        ArrayList<Movimentacao> retorno = new ArrayList();

        while (rs.next()) {
            Movimentacao mov = new Movimentacao();
            mov.setId(rs.getInt("id"));
            mov.setData_hora(rs.getTimestamp("data_hora"));
            mov.setTipoMovimentacao(rs.getInt("tipo_movimentacao"));
            
            PConta pc = new PConta();
            Conta conta = pc.consultar(rs.getInt("id_conta"));
            mov.setConta(conta);
            
            PCliente pcli = new PCliente();
            Cliente cliente = pcli.consultarID(rs.getInt("id_cliente"));
            mov.setCliente(cliente);
            
            retorno.add(mov);
        }
        return retorno.iterator();
    }

}
