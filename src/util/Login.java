/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidades.Cliente;
import entidades.ClienteConta;
import entidades.Conta;
import entidades.Funcionario;
import persistencia.PCliente;
import persistencia.PClienteConta;
import persistencia.PConta;
import persistencia.PFuncionario;

/**
 *
 * @author rodolpho.repezza
 */
public class Login {
    
    public static boolean loginFuncionario(String login, String senha) {
        boolean acesso = false;
        try {
            PFuncionario pf = new PFuncionario();
            Funcionario f = pf.consultar(login);
            if(f.getSenha().equals(senha)) {
                acesso = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acesso;
    }
    
    public static boolean loginCliente(String cpf, String senha, int numeroConta) {
        boolean acesso = false;
        try {
            PCliente pcliente = new PCliente();
            Cliente cliente = pcliente.consultarCPF(cpf);
            
            PConta pconta = new PConta();
            Conta conta = pconta.consultar(numeroConta);
            
            if(cliente != null && conta != null) {
                PClienteConta pcc = new PClienteConta();
                //ClienteConta clienteConta = pcc.
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acesso;
    }
}
