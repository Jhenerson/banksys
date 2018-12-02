/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidades.Cliente;
import entidades.Conta;
import entidades.Movimentacao;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import negocio.NCliente;
import negocio.NConta;
import negocio.NMovimentacao;

/**
 *
 * @author rodolpho.repezza
 */
public class Deposito extends javax.swing.JInternalFrame {
    
    JDesktopPane painelPrincipal;
    int id_conta;
    int id_cliente;

    /**
     * Creates new form Deposito
     */
    public Deposito() {
        initComponents();
    }
    
    public Deposito(JDesktopPane painelPrincipal) {
        this();
        this.painelPrincipal = painelPrincipal;
    }
    
    public Deposito(JDesktopPane painelPrincipal, int id_conta, int id_cliente) {
        this();
        this.painelPrincipal = painelPrincipal;
        this.id_cliente = id_cliente;
        this.id_conta = id_conta;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtValor = new javax.swing.JTextField();
        btnDepositar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Depósito");
        setToolTipText("");

        btnDepositar.setText("Depositar");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Valor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(txtValor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 99, Short.MAX_VALUE)
                        .addComponent(btnDepositar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDepositar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        try {
            float valor = Float.parseFloat(txtValor.getText());
            if(valor > 0) {
                NConta nc = new NConta();
                Conta c = nc.consultarID(id_conta);
                c.depositar(valor);
                nc.salvar(c);
                
                NCliente ncli = new NCliente();
                Cliente cli = ncli.consultarID(id_cliente);
                
                NMovimentacao nm = new NMovimentacao();
                Movimentacao mov = new Movimentacao();
                mov.setCliente(cli);
                mov.setConta(c);
                mov.setTipoMovimentacao(2);
                mov.setValor(valor);
                
                Date dataAtual = new Date();
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Timestamp ts = new Timestamp(dataAtual.getTime());
                
                mov.setData_hora(ts);
                
                nm.salvar(mov);
                
                JOptionPane.showMessageDialog(rootPane, "Depósito no valor de R$" + valor + " efetuado com sucesso!");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDepositarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDepositar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
