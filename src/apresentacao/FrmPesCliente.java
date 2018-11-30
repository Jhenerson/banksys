/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidades.Cliente;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.NCliente;

/**
 *
 * @author repez
 */
public class FrmPesCliente extends javax.swing.JInternalFrame {

    JDesktopPane painelPrincipal;
    Iterator dados = new NCliente().listar();
    
    /**
     * Creates new form FrmPesCliente
     */
    public FrmPesCliente() throws Exception {
        initComponents();        
        imprimirDadosNaGrid(dados);
    }

    public FrmPesCliente(JDesktopPane painelPrincipal) throws Exception {
        this();
        this.painelPrincipal = painelPrincipal;
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

        setTitle("Clientes Cadastrados");

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Data de Nascimento", "E-Mail", "Endereço", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            tblResultado.getColumnModel().getColumn(0).setResizable(false);
            tblResultado.getColumnModel().getColumn(1).setResizable(false);
            tblResultado.getColumnModel().getColumn(2).setResizable(false);
            tblResultado.getColumnModel().getColumn(3).setResizable(false);
            tblResultado.getColumnModel().getColumn(4).setResizable(false);
            tblResultado.getColumnModel().getColumn(5).setResizable(false);
            tblResultado.getColumnModel().getColumn(6).setResizable(false);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMousePressed
        try {
            int linhaSelecionada = tblResultado.getSelectedRow();
            String id = tblResultado.getValueAt(linhaSelecionada, 0).toString();
            FrmCadCliente frmCadCliente = new FrmCadCliente(painelPrincipal, id);
            painelPrincipal.add(frmCadCliente);
            frmCadCliente.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblResultadoMousePressed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultado;
    // End of variables declaration//GEN-END:variables

   private void imprimirDadosNaGrid(Iterator conjunto) {
        DefaultTableModel model = (DefaultTableModel) tblResultado.getModel();
        model.setNumRows(0);
        while (conjunto.hasNext()) {
            String[] linha = new String[7];
            Cliente cliente = (Cliente) conjunto.next();
            
            linha[0] = String.valueOf(cliente.getId());            
            linha[1] = cliente.getNome();
            linha[2] = cliente.getCpf();
            linha[3] = cliente.getDataNascimento().toString();
            linha[4] = cliente.getEmail();
            linha[5] = cliente.getEndereco();
            linha[6] = cliente.getTelefone();

            model.addRow(linha);
        }
    }
   
   private LinkedList<Cliente> ordenar(Iterator conjunto){
       LinkedList<Cliente> lista = new LinkedList<>();
       while(conjunto.hasNext()){
           Cliente cliente = (Cliente) conjunto.next();
           lista.add(cliente);
       }     
           
       return lista;
   }
}
