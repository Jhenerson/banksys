/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author rodolpho.repezza
 */
public class LoginFactory {
    public Login getLogin(String pessoa) {
        if(pessoa.equals("Cliente")) {
            return new LoginCliente();
        } else if(pessoa.equals("Funcionário")) {
            return new LoginFuncionario();
        }
        return null;
    }
}
