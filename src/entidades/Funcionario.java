package entidades;

import java.sql.Timestamp;

/**
 *
 * @author repez
 */
public class Funcionario {

    private int id;
    private String nome;
    private String cpf;
    private String senha;
    private String endereco;
    private String telefone;
    private String email;
    private Timestamp data_contratacao;
    private boolean e_gerente;
    private Agencia agencia;

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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the login to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the data_contratacao
     */
    public Timestamp getData_contratacao() {
        return data_contratacao;
    }

    /**
     * @param data_contratacao the data_contratacao to set
     */
    public void setData_contratacao(Timestamp data_contratacao) {
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
