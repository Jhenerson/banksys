/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import entidades.Funcionario;
import persistencia.PFuncionario;

/**
 *
 * @author rodolpho.repezza
 */
public class LoginFuncionario extends Login {

    @Override
    public boolean logar(String cpf, String senha) {
        boolean acesso = false;
        try {
            PFuncionario pf = new PFuncionario();
            Funcionario f = pf.consultar(cpf);
            if(f.getSenha().equals(senha)) {
                acesso = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acesso;
    }
}
