/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Time;

/**
 *
 * @author jhene
 */
public class Funcionario {
    
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String endereco;
    private String telefone;
    private String email;
    private Time data_contratacao;
    private boolean e_gerente;
    private Agencia agencia;
    private Cidade cidade;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }
    
    /**
     * @return the data_contratacao
     */
    public Time getData_contratacao() {
        return data_contratacao;
    }

    /**
     * @param data_contratacao the data_contratacao to set
     */
    public void setData_contratacao(Time data_contratacao) {
        this.data_contratacao = data_contratacao;
    }

    /**
     * @return the e_gerente
     */
    public boolean isE_gerente() {
        return e_gerente;
    }

    /**
     * @param e_gerente the e_gerente to set
     */
    public void setE_gerente(boolean e_gerente) {
        this.e_gerente = e_gerente;
    }

    /**
     * @return the agencia
     */
    public Agencia getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
        
}