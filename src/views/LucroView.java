/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.sun.glass.events.KeyEvent;
import controllers.Controller;
import controllers.LDIController;
import java.awt.Dimension;
import java.awt.Frame;
import models.LDIModel;

/**
 *
 * @author Beck
 */
public class LucroView extends javax.swing.JInternalFrame {

    private int cod;
    Frame parent;
    private final String tabelaSQL = "fin_lucros";

    /**
     * Creates new form ViewUsuario
     */
    public LucroView() {
        initComponents();
        parent = this.parent;
        jTextFieldData.setText(Controller.getDataDefaultView());
    }

    public LucroView(int cod) {
        initComponents();
        parent = this.parent;
        jTextFieldData.setText(Controller.getDataDefaultView());
        this.cod = cod;
        this.resultLDI();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private void resultLDI() {
        for (LDIController lDIController : LDIModel.resulId(tabelaSQL, cod)) {
            jTextFieldDescricao.setText(lDIController.getC_produto());
            jTextFieldValor.setText(Controller.setMoedaView(lDIController.getN_valor()));
            jTextFieldData.setText(Controller.setDataView(lDIController.getD_cadastro()));
        }
    }

    private void salvar(javax.swing.JFormattedTextField data, javax.swing.JTextField descricao, javax.swing.JFormattedTextField valor) {
        if (!(data.getText()).equals("") && !(descricao.getText()).equals("") && !(valor.getText()).equals("")) {
            LDIController lDIController = new LDIController();
            if (this.cod > 0) {
                lDIController.setN_cod(this.cod);
            }
            lDIController.setN_codusuario(Controller.getN_codUsuario());
            lDIController.setC_produto(descricao.getText());
            lDIController.setD_cadastro(Controller.setDataSQL(data.getText()));
            lDIController.setN_valor(Controller.setMoedaSql(valor.getText()));
            LDIModel lDIModel = new LDIModel();
            if (LDIModel.salvar(lDIController, tabelaSQL)) {
                this.dispose();
            }
        } else {
            PerguntaView msg = new PerguntaView(parent, true, this);
            msg.setVisible(true);
        }
    }

    private void closeView(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.setSearch();
        }
    }

    private void setSearch() {
        if ((this.jTextFieldDescricao.getText()).equals("") && (this.jTextFieldValor.getText()).equals("")) {
            this.dispose();
        } else {
            PerguntaView msg = new PerguntaView(parent, true, this);
            msg.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldValor = new javax.swing.JFormattedTextField();
        jTextFieldData = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lucro");
        setToolTipText("");
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_32x.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(339, 336));
        setName(""); // NOI18N
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(339, 336));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Descrição:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Valor:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Data:");

        jTextFieldDescricao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldDescricao.setForeground(new java.awt.Color(0, 102, 102));
        jTextFieldDescricao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_32x.png"))); // NOI18N
        jLabel6.setText("Lucro");

        jButtonConfirmar.setBackground(new java.awt.Color(0, 102, 102));
        jButtonConfirmar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.setBorder(null);
        jButtonConfirmar.setBorderPainted(false);
        jButtonConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        jButtonConfirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButtonConfirmarKeyReleased(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 0, 51));
        jButtonCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorder(null);
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jButtonCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButtonCancelarKeyReleased(evt);
            }
        });

        jTextFieldValor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        jTextFieldValor.setForeground(new java.awt.Color(0, 102, 102));
        jTextFieldValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("R$ #,##0.##"))));
        jTextFieldValor.setText("R$ ");
        jTextFieldValor.setToolTipText("");
        jTextFieldValor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldValorKeyReleased(evt);
            }
        });

        jTextFieldData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        jTextFieldData.setForeground(new java.awt.Color(0, 102, 102));
        try {
            jTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldData.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDataKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldData)
                    .addComponent(jTextFieldValor)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelar, jButtonConfirmar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldData, jTextFieldDescricao, jTextFieldValor});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        setBounds(0, 0, 339, 336);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setSearch();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        this.salvar(jTextFieldData, jTextFieldDescricao, jTextFieldValor);
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jTextFieldDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyReleased
        this.closeView(evt);
    }//GEN-LAST:event_jTextFieldDescricaoKeyReleased

    private void jTextFieldValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorKeyReleased
        this.closeView(evt);
    }//GEN-LAST:event_jTextFieldValorKeyReleased

    private void jTextFieldDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDataKeyReleased
        this.closeView(evt);
    }//GEN-LAST:event_jTextFieldDataKeyReleased

    private void jButtonConfirmarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonConfirmarKeyReleased
        this.closeView(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.salvar(jTextFieldData, jTextFieldDescricao, jTextFieldValor);
        }
    }//GEN-LAST:event_jButtonConfirmarKeyReleased

    private void jButtonCancelarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelarKeyReleased
        this.closeView(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.setSearch();
        }
    }//GEN-LAST:event_jButtonCancelarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JFormattedTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
