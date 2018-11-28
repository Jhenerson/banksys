package negocio;

import entidades.Conta;
import java.sql.SQLException;
import java.util.Iterator;
import persistencia.PCliente;
import persistencia.PConta;

/**
 *
 * @author jhene
 */
public class NConta {

    PConta persistencia;

    public NConta() {
        persistencia = new PConta();
    }

    public void salvar(Conta parametro) throws SQLException, Exception {

        if (parametro.getNumAgencia().getId() == 0) {
            throw new Exception("É necessário informar a agência");
        }

        if (parametro.getId() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }

    }

    public void excluir(int parametro) throws SQLException, Exception {
        persistencia.excluir(parametro);
    }

    public Conta consultarID(int parametro) throws SQLException, Exception {
        return persistencia.consultar(parametro);
    }

    public Iterator listar() throws SQLException, Exception {
        return persistencia.listar();
    }

}
