/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.sun.glass.events.KeyEvent;
import controllers.Controller;
import controllers.UsuarioController;
import java.awt.Dimension;
import java.awt.Frame;
import models.UsuarioModel;

/**
 *
 * @author Beck
 */
public class UsuarioView extends javax.swing.JInternalFrame {

    Frame parent;
    private int cod = 0;

    /**
     * Creates new form ViewUsuario
     */
    public UsuarioView() {
        initComponents();
        parent = this.parent;
    }

    public UsuarioView(int codigo) {
        initComponents();
        this.cod = codigo;
        parent = this.parent;
        this.resultUsuario();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private void resultUsuario() {
        UsuarioModel usuarioModel = UsuarioModel.getUsuarioModel();
        for (UsuarioController usuarioController : usuarioModel.resultId(this.cod)) {
            jTextFieldNome.setText(usuarioController.getC_nomeusuario());
            jTextFieldUsuario.setText(usuarioController.getC_usuario());
            jPasswordFieldSenha.setText(usuarioController.getC_senhausuario());
        }
    }

    private void closeView() {
        if ((this.jTextFieldNome.getText()).equals("") && (this.jTextFieldUsuario.getText()).equals("") && (new String(this.jPasswordFieldSenha.getPassword())).equals("") && (new String(this.jPasswordFieldRepitSenha.getPassword())).equals("")) {
            this.dispose();
        } else {
            PerguntaView msg = new PerguntaView(parent, true, this);
            msg.setVisible(true);
        }
    }

    private void closeView(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.closeView();
        }
    }

    public void salvar() {
        if (!(new String(this.jPasswordFieldRepitSenha.getPassword())).equals("") && !(this.jTextFieldNome.getText()).equals("") && !(this.jTextFieldUsuario.getText()).equals("") && !(new String(this.jPasswordFieldSenha.getPassword())).equals("")) {

            String usuario = jTextFieldUsuario.getText();

            boolean erro = false;
            if (usuario.contains(" ")) {
                erro = true;
                String msg;
                msg = "<html>"
                        + "<h2 style='color:rgb([255,0,51]);'>Espere aí, é sério?</h2>"
                        + "<span style='text-align: justify; color:rgb(0,102,102); '>"
                        + "O campo usuário não pode conter espaço.</span>"
                        + "</html>";
                MsgView msgView = new MsgView(parent, true, this, msg);
                msgView.setVisible(true);
            } else if (!(new String(jPasswordFieldSenha.getPassword())).equals(new String(jPasswordFieldRepitSenha.getPassword()))) {
                erro = true;
                String msg;
                msg = "<html>"
                        + "<h2 style='color:rgb([255,0,51]);'>Espere aí, é sério?</h2>"
                        + "<span style='text-align: justify; color:rgb(0,102,102); '>"
                        + "O campo Senha e Repetir Senha estão incorretos.</span>"
                        + "</html>";
                MsgView msgView = new MsgView(parent, true, this, msg);
                msgView.setVisible(true);
            }
            if (erro == false) {
                UsuarioController usuarioController = new UsuarioController();
                if (this.cod > 0) {
                    usuarioController.setN_codusuario(this.cod);
                }
                usuarioController.setC_nomeusuario(jTextFieldNome.getText());
                usuarioController.setC_usuario(jTextFieldUsuario.getText());
                usuarioController.setC_senhausuario(new String(jPasswordFieldSenha.getPassword()));
                usuarioController.setD_cadastrousuario(Controller.getDataDefaultSQL());
                usuarioController.setB_permissaousuario(0);
                UsuarioModel usuarioModel = UsuarioModel.getUsuarioModel();
                if (usuarioModel.salvar(usuarioController)) {
                    this.dispose();
                    String msg;
                    msg = "<html>"
                            + "<h2 style='color:rgb([255,0,51]);'>Alerta de Cadastro!</h2>"
                            + "<span style='text-align: justify; color:rgb(0,102,102); '>"
                            + "Usuário salvo com sucesso.</span>"
                            + "</html>";
                    MsgView msgView = new MsgView(parent, true, this, msg);
                    msgView.setVisible(true);
                } else {
                    String msg;
                    msg = "<html>"
                            + "<h2 style='color:rgb([255,0,51]);'>Espere aí, é sério?</h2>"
                            + "<span style='text-align: justify; color:rgb(0,102,102); '>"
                            + "Este usuário já encontra-se cadastrado no sistema. <b>Deseja finalizar está operação?</b></span>"
                            + "</html>";
                    PerguntaView mensagem = new PerguntaView(parent, true, this, msg);
                    mensagem.setVisible(true);
                }
            }

        } else {
            String msg = "<html>"
                    + "<h2 style='color:rgb([255,0,51]);'>Alerta de Cadastro!</h2>"
                    + "<span style='text-align: justify; color:rgb(0,102,102); '>"
                    + "Para efetivar um cadastro ou alteração é necessário que seja preenchido todos os campos. <b>Deseja finalizar está operação?</b></span>"
                    + "</html>";
            PerguntaView mensagem = new PerguntaView(parent, true, this, msg);
            mensagem.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jPasswordFieldRepitSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuário");
        setToolTipText("");
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/team.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(339, 397));
        setName(""); // NOI18N
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nome Completo:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nome de Usuário:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Senha:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Repetir Senha:");

        jTextFieldNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(0, 102, 102));
        jTextFieldNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyReleased(evt);
            }
        });

        jTextFieldUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldUsuario.setForeground(new java.awt.Color(0, 102, 102));
        jTextFieldUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioKeyReleased(evt);
            }
        });

        jPasswordFieldSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPasswordFieldSenha.setForeground(new java.awt.Color(0, 102, 102));
        jPasswordFieldSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        jPasswordFieldSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldSenhaKeyReleased(evt);
            }
        });

        jPasswordFieldRepitSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPasswordFieldRepitSenha.setForeground(new java.awt.Color(0, 102, 102));
        jPasswordFieldRepitSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        jPasswordFieldRepitSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldRepitSenhaKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/team.png"))); // NOI18N
        jLabel6.setText("Usuário");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 103, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldRepitSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldRepitSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 339, 397);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.closeView();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        this.salvar();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jTextFieldNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyReleased
        this.closeView(evt);
    }//GEN-LAST:event_jTextFieldNomeKeyReleased

    private void jTextFieldUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyReleased
        this.closeView(evt);
    }//GEN-LAST:event_jTextFieldUsuarioKeyReleased

    private void jPasswordFieldSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaKeyReleased
        this.closeView(evt);
    }//GEN-LAST:event_jPasswordFieldSenhaKeyReleased

    private void jPasswordFieldRepitSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldRepitSenhaKeyReleased
        this.closeView(evt);
    }//GEN-LAST:event_jPasswordFieldRepitSenhaKeyReleased

    private void jButtonConfirmarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonConfirmarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.salvar();
        }
    }//GEN-LAST:event_jButtonConfirmarKeyReleased

    private void jButtonCancelarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCancelarKeyReleased
        this.closeView(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.closeView();
        }
    }//GEN-LAST:event_jButtonCancelarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldRepitSenha;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
