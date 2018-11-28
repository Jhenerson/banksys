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

        if (parametro.getNome().isEmpty()) {
            throw new Exception("É necessário informar o nome");
        }
        
        if (parametro.getCpf().isEmpty()) {
            throw new Exception("É necessário informar o CPF");
        }
        
        if (parametro.getEmail().isEmpty()) {
            throw new Exception("É necessário informar o e-mail");
        }
        
        if (parametro.getEndereco().isEmpty()) {
            throw new Exception("É necessário informar o endereço");
        }
        
        if (parametro.getTelefone().isEmpty()) {
            throw new Exception("É necessário informar o telefone");
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
        return persistencia.consultarID(parametro);        
    }
    
    public Conta consultarCPF(long cpf) throws SQLException, Exception {
        return persistencia.consultarCPF(cpf);        
    }
    
    public Conta consultar(String nome) throws SQLException, Exception {
        return persistencia.consultar(nome);        
    }

    public Iterator listar() throws SQLException, Exception {
        return persistencia.listar();
    }
    
}
