/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import entidades.Cliente;
import entidades.ClienteConta;
import persistencia.PCliente;
import persistencia.PClienteConta;

/**
 *
 * @author rodolpho.repezza
 */
public class LoginCliente extends Login {

    @Override
    public boolean logar(String cpf, String senha) {
        boolean acesso = false;
        try {
            
            PCliente pcliente = new PCliente();
            Cliente cliente = pcliente.consultarCPF(cpf);
            
            if(cliente != null) {
                PClienteConta pcc = new PClienteConta();
                ClienteConta clienteConta = pcc.consultar(cliente.getId(), senha);
                if(senha.equals(clienteConta.getSenha())) {
                    acesso = true;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acesso;
    }
}
