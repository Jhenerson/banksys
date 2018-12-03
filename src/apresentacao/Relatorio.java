
package apresentacao;

import entidades.Cliente;
import entidades.Movimentacao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;
import negocio.NCliente;
import negocio.NMovimentacao;

/**
 *
 * @author rodolpho.repezza
 */
public class Relatorio extends javax.swing.JInternalFrame {
    
    JDesktopPane painelPrincipal;
    int id_conta;
    int id_cliente;

    /**
     * Creates new form Relatorio
     */
    public Relatorio() {
        initComponents();
    }
    
    public Relatorio(JDesktopPane painelPrincipal) {
        this();
        this.painelPrincipal = painelPrincipal;
    }
    
    public Relatorio(JDesktopPane painelPrincipal, int id_conta, int id_cliente) {
        this();
        this.painelPrincipal = painelPrincipal;
        this.id_cliente = id_cliente;
        this.id_conta = id_conta;
    }

    public void imprimirDadosNaGrid(Iterator dados) {
        try {
            
            DefaultTableModel model = (DefaultTableModel) tblResultado.getModel();
            model.setNumRows(0);
            while (dados.hasNext()) {
                String[] linha = new String[4];
                Movimentacao mov = (Movimentacao) dados.next();
                
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
                String data = dateFormat.format(mov.getData_hora());
                
                linha[0] = String.valueOf(data);            
                linha[1] = String.valueOf(mov.getValor());
                
                String tipo = "Saque";
                if(mov.getTipoMovimentacao() == 1) {
                    tipo = "Depósito";
                }
                
                linha[2] = tipo;
                
                NCliente nc = new NCliente();
                Cliente c = nc.consultarID(id_cliente);
                
                linha[3] = c.getNome();

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

        jLabel1 = new javax.swing.JLabel();
        txtData1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtData2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();

        jLabel1.setText("Período:");

        jLabel2.setText("a");

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Valor", "Movimentação", "Cliente"
            }
        ));
        jScrollPane1.setViewportView(tblResultado);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Date data1 = sdf.parse(txtData1.getText());
            Date data2 = sdf.parse(txtData2.getText());
            
            java.sql.Date inicio = new java.sql.Date(data1.getTime());
            java.sql.Date fim = new java.sql.Date(data2.getTime());
            
            NMovimentacao nmov = new NMovimentacao();
            Iterator dados = nmov.listar(inicio, fim);
            
            imprimirDadosNaGrid(dados);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtData1;
    private javax.swing.JTextField txtData2;
    // End of variables declaration//GEN-END:variables
}


