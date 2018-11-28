package entidades;

import java.sql.Date;

/**
 *
 * @author jhene
 */
public class Conta {

    private int id;
    private int numConta;
    private Agencia numAgencia;
    private float saldo;
    private Date dataAberturaConta;
    private int tipoConta;
    private boolean usaCheque;
    private boolean eConjunta;

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
}
