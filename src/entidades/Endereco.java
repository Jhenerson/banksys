/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author repez
 */
public class Endereco {
    
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    
    public Endereco() {
        
    }
    
    public Endereco(String logradouro, String complemento, String bairro, String localidade, String uf,String cep) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.cep = cep;
    }
    
    public Endereco(String enderecoSeparadoPorVirgulas) {
        String[] pieces = enderecoSeparadoPorVirgulas.split(",");
        this.logradouro = pieces[0];
        this.complemento = pieces[1];
        this.bairro = pieces[2];
        this.localidade = pieces[3];
        this.uf = pieces[4];
        this.cep = pieces[5];
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public Endereco setLocalidade(String localidade) {
        this.localidade = localidade;
        return this;
    }

    public Endereco setUf(String uf) {
        this.uf = uf;
        return this;
    }
    
    @Override
    public String toString() {
        String retorno = this.logradouro;
        if(!this.complemento.isEmpty()) {
            retorno += " " + this.complemento;
        }
        retorno += " " + this.bairro + ", " + this.localidade + "-" + this.uf + " - " + this.cep;
        return retorno;
    }
    
}
