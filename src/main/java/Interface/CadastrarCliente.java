package Interface;

import Gerencia.FuncoesUteis;
import Gerencia.GerTarefasGraficas;
import java.text.ParseException;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class CadastrarCliente extends javax.swing.JDialog {
    //acesso
    private GerTarefasGraficas gerTarefas;
    
    //construtor 
    public CadastrarCliente(java.awt.Frame parent, boolean modal, GerTarefasGraficas gerTarefas) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.gerTarefas = gerTarefas;
        this.gerTarefas.habilitarBotoes(this.gerTarefas.getGerEdicao().getClienteSelecionado(), btnNovo, btnAlterar);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpSexo = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblEnder7 = new javax.swing.JLabel();
        lblEnder5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        lblCpf = new javax.swing.JLabel();
        lblDtNasc = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        txtData = new javax.swing.JFormattedTextField();
        lblFoto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdbFemin = new javax.swing.JRadioButton();
        rdbMasc = new javax.swing.JRadioButton();
        btnAlterar = new javax.swing.JButton();
        txtCelular = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Cadastro de Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        lblNome.setText("Nome:");

        lblEnder7.setText("E-mail:");

        lblEnder5.setText("Tel. Cel:");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/add.png"))); // NOI18N
        btnNovo.setMnemonic('N');
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/remove.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/search.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblCpf.setText("CPF:");

        lblDtNasc.setText("Dt. Nasc:");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        grpSexo.add(rdbFemin);
        rdbFemin.setMnemonic('F');
        rdbFemin.setText("Feminino");
        rdbFemin.setActionCommand("Feminino");
        rdbFemin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/rb.gif"))); // NOI18N
        rdbFemin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/rbr.gif"))); // NOI18N
        rdbFemin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/rbrs.gif"))); // NOI18N
        jPanel2.add(rdbFemin, java.awt.BorderLayout.CENTER);

        grpSexo.add(rdbMasc);
        rdbMasc.setMnemonic('M');
        rdbMasc.setSelected(true);
        rdbMasc.setText("Masculino");
        rdbMasc.setActionCommand("Masculino");
        rdbMasc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/rb.gif"))); // NOI18N
        rdbMasc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/rbp.gif"))); // NOI18N
        rdbMasc.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/rbs.gif"))); // NOI18N
        jPanel2.add(rdbMasc, java.awt.BorderLayout.PAGE_START);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/accept.png"))); // NOI18N
        btnAlterar.setText("Alterar");

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lblNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEnder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEnder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                            .addComponent(txtEmail))
                        .addGap(12, 12, 12))
                    .addComponent(lblDtNasc)
                    .addComponent(lblCpf))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNome)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDtNasc)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEnder7)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEnder5)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnNovo)
                            .addComponent(btnAlterar))
                        .addContainerGap())))
        );

        getContentPane().add(jPanel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        gerTarefas.abrirPesqCliente();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        gerTarefas.abrirFoto(lblFoto, this);
    }//GEN-LAST:event_lblFotoMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        gerTarefas.cursorFora(this);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        gerTarefas.cursorDentro(this);
    }//GEN-LAST:event_formMouseExited

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        try {
            //pegando os dados
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String d = txtData.getText();
            char sexo = (char) grpSexo.getSelection().getMnemonic();
            String celular = txtCelular.getText();
            String email = txtEmail.getText();
            Icon f = lblFoto.getIcon();
            
            //tratando os dados que precisa
            Date data = FuncoesUteis.strToDate(d);
            byte[] foto = FuncoesUteis.IconToBytes(f);
            
            // INSERIR NO BANCO                      
            //------------------------------------------------------------------------------
            if ( this.gerTarefas.getGerEdicao().getClienteSelecionado() == null) {
                // INSERIR
                int id = this.gerTarefas.getGerenciaDaoDominio().inserirCliente(nome,cpf,email,celular,sexo,data,foto);
                JOptionPane.showMessageDialog(this, "Cliente " + id + " inserido com sucesso.");
            } else {
                // ALTERAR
                this.gerTarefas.getGerenciaDaoDominio().alterarCliente();
                int id = this.gerTarefas.getGerEdicao().getClienteSelecionado().getIdCliente();
                JOptionPane.showMessageDialog(this, "Cliente " + id + " alterado com sucesso.");
            }        
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro: "+ex);
        }                          
    }//GEN-LAST:event_btnNovoActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.ButtonGroup grpSexo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDtNasc;
    private javax.swing.JLabel lblEnder5;
    private javax.swing.JLabel lblEnder7;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNome;
    private javax.swing.JRadioButton rdbFemin;
    private javax.swing.JRadioButton rdbMasc;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
