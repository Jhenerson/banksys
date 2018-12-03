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
public abstract class Login {
    protected String cpf;
    protected String senha;
    
    public abstract boolean logar(String cpf, String senha);
    
}
