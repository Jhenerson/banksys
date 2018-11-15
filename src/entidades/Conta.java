package entidades;

import java.util.Date;

/**
 *
 * @author jhene
 */
public class Conta {
    private int numConta;
    private Agencia numAgencia;
    private Cliente titular;
    private float saldo;
    private Date dataAberturaConta;

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public Agencia getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(Agencia numAgencia) {
        this.numAgencia = numAgencia;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getDataAberturaConta() {
        return dataAberturaConta;
    }

    public void setDataAberturaConta(Date dataAberturaConta) {
        this.dataAberturaConta = dataAberturaConta;
    }
}
