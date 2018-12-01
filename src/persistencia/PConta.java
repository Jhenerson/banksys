package persistencia;

import entidades.Agencia;
import entidades.Conta;
import interfaces.IConta;
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
public class PConta implements IConta {

    @Override
    public void incluir(Conta conta) throws Exception {
        String sql = "INSERT INTO conta (numero,saldo,data_abertura,tipo_conta,usa_cheque,e_conjunta,id_agencia)"
                + "VALUES (?,?,?,?,?,?,?);";
        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, conta.getNumConta());
        prd.setFloat(2, conta.getSaldo());
        prd.setTimestamp(3, conta.getDataAberturaConta());
        prd.setInt(4, conta.getTipoConta());
        prd.setBoolean(5, conta.isUsaCheque());
        prd.setBoolean(6, conta.iseConjunta());
        prd.setObject(7, conta.getNumAgencia().getId());

        prd.execute();
        cnn.close();
    }

    @Override
    public Iterator listar() throws Exception {
        try {
            String sql = "SELECT * FROM conta";

            Connection cnn = util.Conexao.getConexao();
            Statement st = cnn.createStatement();

            ResultSet rs = st.executeQuery(sql);
            ArrayList<Conta> retorno = new ArrayList();

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setDataAberturaConta(rs.getTimestamp("data_abertura"));

                PAgencia PAg = new PAgencia();
                Agencia ag = PAg.consultar(rs.getInt("id_agencia"));
                conta.setNumAgencia(ag);

                conta.setNumConta(rs.getString("numero"));
                conta.setSaldo(rs.getFloat("saldo"));
                conta.setTipoConta(rs.getInt("tipo_conta"));
                conta.setUsaCheque(rs.getBoolean("usa_cheque"));
                conta.seteConjunta(rs.getBoolean("e_conjunta"));

                retorno.add(conta);
            }

//            retorno.sort(new Comparator() {
//                @Override
//                public int compare(Object o1, Object o2) {
//                    Conta c1 = (Conta) o1;
//                    Conta c2 = (Conta) o2;
//                    return c1.getNumConta().compareToIgnoreCase(c2.getNumConta());
//                }
//            });
            return retorno.iterator();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void alterar(Conta conta) throws Exception {
        
        
        
         String sql = "UPDATE conta SET numero = ?, data_abertura = ?, tipo_conta = ?, usa_cheque = ?, e_conjunta = ?,id_agencia = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, conta.getNumConta());        
        prd.setTimestamp(2, conta.getDataAberturaConta());
        prd.setInt(3, conta.getTipoConta());
        prd.setBoolean(4, conta.isUsaCheque());
        prd.setBoolean(5, conta.iseConjunta());
        prd.setObject(6, conta.getNumAgencia().getId());
        prd.setInt(7, conta.getId());

        //executa todo o comando e grava no banco de dados
        prd.execute();
        cnn.close();
    }

    @Override
    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM conta WHERE id = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setLong(1, id);
        prd.execute();
        cnn.close();
    }

    @Override
    public Conta consultar(String numConta) throws Exception {
        String sql = " SELECT * FROM conta WHERE numero = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, numConta);

        ResultSet rs = prd.executeQuery();
        Conta conta = new Conta();

        if (rs.next()) {
            conta.setId(rs.getInt("id"));
            conta.setDataAberturaConta(rs.getTimestamp("data_abertura"));

            PAgencia PAg = new PAgencia();
            Agencia ag = PAg.consultar(rs.getInt("id_agencia"));
            conta.setNumAgencia(ag);

            conta.setNumConta(rs.getString("numero"));
            conta.setSaldo(rs.getFloat("saldo"));
            conta.setTipoConta(rs.getInt("tipo_conta"));
            conta.setUsaCheque(rs.getBoolean("usa_cheque"));
            conta.seteConjunta(rs.getBoolean("e_conjunta"));
        }
        prd.execute();
        cnn.close();
        return conta;
    }

    @Override
    public Conta consultar(int id) throws Exception {
        String sql = " SELECT * FROM conta WHERE id = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, id);

        ResultSet rs = prd.executeQuery();
        Conta conta = new Conta();

        if (rs.next()) {
            conta.setId(rs.getInt("id"));
            conta.setDataAberturaConta(rs.getTimestamp("data_abertura"));

            PAgencia PAg = new PAgencia();
            Agencia ag = PAg.consultar(rs.getInt("id_agencia"));
            conta.setNumAgencia(ag);

            conta.setNumConta(rs.getString("numero"));
            conta.setSaldo(rs.getFloat("saldo"));
            conta.setTipoConta(rs.getInt("tipo_conta"));
            conta.setUsaCheque(rs.getBoolean("usa_cheque"));
            conta.seteConjunta(rs.getBoolean("e_conjunta"));
        }
        prd.execute();
        cnn.close();
        return conta;
    }

}
