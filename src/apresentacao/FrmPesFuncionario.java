/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidades.Agencia;
import entidades.Endereco;
import entidades.Funcionario;
import java.util.Iterator;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.NAgencia;
import negocio.NFuncionario;

/**
 *
 * @author repez
 */
public class FrmPesFuncionario extends javax.swing.JInternalFrame {

    JDesktopPane painelPrincipal;

    /**
     * Creates new form FrmPesFuncionario
     */
    public FrmPesFuncionario() {
        initComponents();
        imprimirDadosNaGrid();
    }

    FrmPesFuncionario(JDesktopPane painelPrincipal) {
        this();
        this.painelPrincipal = painelPrincipal;
    }

    public void imprimirDadosNaGrid() {
        try {
            
            NFuncionario nf = new NFuncionario();
            Iterator dados = nf.listar();
            
            DefaultTableModel model = (DefaultTableModel) tblResultado.getModel();
            model.setNumRows(0);
            while (dados.hasNext()) {
                String[] linha = new String[6];
                Funcionario funcionario = (Funcionario) dados.next();
                
                linha[0] = String.valueOf(funcionario.getId());            
                linha[1] = funcionario.getNome();
                
                Endereco end = new Endereco(funcionario.getEndereco());
                
                linha[2] = end.toString();
                linha[3] = funcionario.getTelefone();
                linha[4] = funcionario.getEmail();
                
                NAgencia na = new NAgencia();
                Agencia ag = na.consultar(funcionario.getAgencia().getId());
                
                linha[5] = ag.getCodigo();

                model.addRow(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();

        setToolTipText("Funcionários Cadastrados");

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Endereço", "Telefone", "E-mail", "Agência"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblResultadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultado);
        if (tblResultado.getColumnModel().getColumnCount() > 0) {
            tblResultado.getColumnModel().getColumn(0).setMinWidth(40);
            tblResultado.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblResultado.getColumnModel().getColumn(0).setMaxWidth(40);
            tblResultado.getColumnModel().getColumn(1).setMinWidth(250);
            tblResultado.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblResultado.getColumnModel().getColumn(1).setMaxWidth(250);
            tblResultado.getColumnModel().getColumn(2).setMinWidth(300);
            tblResultado.getColumnModel().getColumn(2).setPreferredWidth(300);
            tblResultado.getColumnModel().getColumn(2).setMaxWidth(300);
            tblResultado.getColumnModel().getColumn(3).setMinWidth(100);
            tblResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblResultado.getColumnModel().getColumn(3).setMaxWidth(100);
            tblResultado.getColumnModel().getColumn(4).setMinWidth(250);
            tblResultado.getColumnModel().getColumn(4).setPreferredWidth(250);
            tblResultado.getColumnModel().getColumn(4).setMaxWidth(250);
            tblResultado.getColumnModel().getColumn(5).setMinWidth(100);
            tblResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblResultado.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFechar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechar)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void tblResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMousePressed
        try {
            int linhaSelecionada = tblResultado.getSelectedRow();
            String id = tblResultado.getValueAt(linhaSelecionada, 0).toString();
            FrmCadFuncionario frmCadFunc = new FrmCadFuncionario(painelPrincipal, id);
            painelPrincipal.add(frmCadFunc);
            frmCadFunc.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblResultadoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultado;
    // End of variables declaration//GEN-END:variables
}
