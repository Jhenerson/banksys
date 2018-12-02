package entidades;

import java.sql.Timestamp;

/**
 *
 * @author jhene
 */
public class Conta {

    private int id;
    private String numConta;
    private Agencia numAgencia;
    private float saldo = 0;
    private Timestamp dataAberturaConta;
    private int tipoConta;
    private boolean usaCheque;
    private boolean eConjunta;

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public Agencia getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(Agencia numAgencia) {
        this.numAgencia = numAgencia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Timestamp getDataAberturaConta() {
        return dataAberturaConta;
    }

    public void setDataAberturaConta(Timestamp dataAberturaConta) {
        this.dataAberturaConta = dataAberturaConta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public boolean isUsaCheque() {
        return usaCheque;
    }

    public void setUsaCheque(boolean usaCheque) {
        this.usaCheque = usaCheque;
    }

    public boolean iseConjunta() {
        return eConjunta;
    }

    public void seteConjunta(boolean eConjunta) {
        this.eConjunta = eConjunta;
    }
    
    public void sacar(float valor) throws Exception {
        if(valor > saldo) {
            throw new Exception("Saldo disponível menor que o valor a ser sacado.");
        }
        this.setSaldo(saldo - valor);
    }
    
    public void depositar(float valor) throws Exception {
        if(valor <= 0) {
            throw new Exception("Valor a ser depositado inválido.");
        }
        this.setSaldo(saldo + valor);
    }
    
    
}
