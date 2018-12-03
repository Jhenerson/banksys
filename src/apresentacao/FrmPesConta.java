package apresentacao;

import entidades.Agencia;
import entidades.Conta;
import entidades.Endereco;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.NAgencia;
import negocio.NConta;

/**
 *
 * @author jhene
 */
public class FrmPesConta extends javax.swing.JInternalFrame {

    JDesktopPane painelPrincipal;

    /**
     * Creates new form FrmPesAgencia
     */
    public FrmPesConta() {
        initComponents();
        imprimirDadosNaGrid();
    }

    public FrmPesConta(JDesktopPane painelPrincipal) {
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

        setTitle("Agências Cadastradas");

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Número", "Data de Abertura", "Tipo de Conta", "Usa Cheque", "Conta Conjunta", "Agência"
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
            tblResultado.getColumnModel().getColumn(0).setMinWidth(30);
            tblResultado.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblResultado.getColumnModel().getColumn(0).setMaxWidth(30);
            tblResultado.getColumnModel().getColumn(1).setMinWidth(100);
            tblResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblResultado.getColumnModel().getColumn(1).setMaxWidth(100);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFechar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechar)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblResultadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadoMousePressed
        try {
            int linhaSelecionada = tblResultado.getSelectedRow();
            String id = tblResultado.getValueAt(linhaSelecionada, 0).toString();
            FrmCadConta frmCadConta = new FrmCadConta(painelPrincipal, id);
            painelPrincipal.add(frmCadConta);
            frmCadConta.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblResultadoMousePressed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void imprimirDadosNaGrid() {
        try {

            NConta nc = new NConta();
            Iterator dados = nc.listar();

            DefaultTableModel model = (DefaultTableModel) tblResultado.getModel();
            model.setNumRows(0);
            while (dados.hasNext()) {
                String[] linha = new String[7];
                Conta conta = (Conta) dados.next();

                linha[0] = String.valueOf(conta.getId());
                linha[1] = conta.getNumConta();

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String data = dateFormat.format(conta.getDataAberturaConta());

                linha[2] = String.valueOf(data);
                linha[3] = Integer.toString(conta.getTipoConta());
                if (conta.isUsaCheque()) {
                    linha[4] = "sim";
                } else {
                    linha[4] = "não";
                }
                if (conta.iseConjunta()) {
                    linha[5] = "sim";
                } else {
                    linha[5] = "não";
                }

                linha[6] = Integer.toString(conta.getNumAgencia().getId());

                model.addRow(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultado;
    // End of variables declaration//GEN-END:variables
}
