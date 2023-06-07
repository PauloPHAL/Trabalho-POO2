package Interface;

import Dominio.Aeronave;
import Dominio.Cliente;
import Dominio.Locacao;
import Gerencia.FuncoesUteis;
import Gerencia.GerTarefasGraficas;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

public class CadastrarLocacao extends javax.swing.JDialog {
    //acesso
    private GerTarefasGraficas gerTarefas;
    
    //construtor 
    public CadastrarLocacao(java.awt.Frame parent, boolean modal, GerTarefasGraficas gerTarefas) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.gerTarefas = gerTarefas;
        this.gerTarefas.habilitarBotoes(this.gerTarefas.getGerEdicao().getLocacaoSelecionada(), btlAdd, btlAlterar);
    }

    private void preencherCampos(Locacao locacao) throws ParseException{
        if (locacao != null ) {
            this.txtDataLocacao.setText(locacao.getDataLocacaoFormatada());
            this.txtDataLimite.setText(locacao.getDataLimiteFormatada());
            this.txtValor.setText(FuncoesUteis.doubleToString(locacao.getValor()));
            this.jComboBoxA.setSelectedItem(locacao.getChaveComposta().getAeronave());
            this.jComboBoxC.setSelectedItem(locacao.getChaveComposta().getCliente());
            this.gerTarefas.habilitarBotoes(this.gerTarefas.getGerEdicao().getLocacaoSelecionada(), btlAdd, btlAlterar);
        }else{
            this.limparCampos();
            this.gerTarefas.habilitarBotoes(this.gerTarefas.getGerEdicao().getLocacaoSelecionada(), btlAdd, btlAlterar);
        }
    }
    
    private void limparCampos(){
        this.txtDataLocacao.setText("");
        this.txtDataLimite.setText("");
        this.txtValor.setText("");
        this.jComboBoxA.setSelectedIndex(0);
        this.jComboBoxC.setSelectedIndex(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxA = new javax.swing.JComboBox<>();
        jComboBoxC = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btlAlterar = new javax.swing.JButton();
        btlAdd = new javax.swing.JButton();
        btlSair = new javax.swing.JButton();
        txtDataLimite = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btlPesquisar = new javax.swing.JButton();
        txtDataLocacao = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRAR LOCACAO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        jLabel1.setText("AERONAVE:");

        jLabel2.setText("CLIENTE:");

        btlAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/accept.png"))); // NOI18N
        btlAlterar.setText("Alterar");
        btlAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlAddActionPerformed(evt);
            }
        });

        btlAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/add.png"))); // NOI18N
        btlAdd.setText("Locar");
        btlAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlAddActionPerformed(evt);
            }
        });

        btlSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/remove.png"))); // NOI18N
        btlSair.setText("Cancelar");
        btlSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlSairActionPerformed(evt);
            }
        });

        try {
            txtDataLimite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Data Limite:");

        jLabel4.setText("Data Locacao:");

        btlPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/search.png"))); // NOI18N
        btlPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlPesquisarActionPerformed(evt);
            }
        });

        try {
            txtDataLocacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Valor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btlPesquisar))))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxC, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxA, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btlAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btlAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btlSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btlPesquisar)
                        .addGap(86, 86, 86))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDataLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(15, 15, 15)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btlAlterar)
                    .addComponent(btlAdd)
                    .addComponent(btlSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btlPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlPesquisarActionPerformed
        gerTarefas.abrirPesqLocacao();
        try {
            preencherCampos(this.gerTarefas.getGerEdicao().getLocacaoSelecionada());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro: "+ex);
        }
    }//GEN-LAST:event_btlPesquisarActionPerformed

    private void btlSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlSairActionPerformed
        this.gerTarefas.getGerEdicao().setLocacaoSelecionada(null);
        this.dispose();
    }//GEN-LAST:event_btlSairActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        gerTarefas.cursorFora(this);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        gerTarefas.cursorDentro(this);
    }//GEN-LAST:event_formMouseExited

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        this.gerTarefas.carregarComboBox(jComboBoxA, this, Aeronave.class);
        this.gerTarefas.carregarComboBox(jComboBoxC, this, Cliente.class);
    }//GEN-LAST:event_formComponentShown

    private void btlAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlAddActionPerformed
        try {
            //pegando os dados
            String d1 = this.txtDataLocacao.getText();
            String d2 = this.txtDataLimite.getText();
            String v = this.txtValor.getText();
            Cliente cliente = (Cliente) this.jComboBoxC.getSelectedItem();
            Aeronave aeronave = (Aeronave)this.jComboBoxA.getSelectedItem();
            
            //tratando os dados que precisa
            Date dataLocacao = FuncoesUteis.strToDate(d1);
            Date dataLimite = FuncoesUteis.strToDate(d2);
            double valor = FuncoesUteis.stringToDouble(v);
            
            // INSERIR NO BANCO                      
            //------------------------------------------------------------------------------
            if ( this.gerTarefas.getGerEdicao().getLocacaoSelecionada() == null) {
                // INSERIR
                int id[] = this.gerTarefas.getGerenciaDaoDominio().inserirLocacao(cliente,aeronave,dataLocacao,dataLimite,valor);
                JOptionPane.showMessageDialog(this, "Locacao do cliente: " +id[0]+" com a aeronave: "+id[1]+ " inserida com sucesso.");
            } else {
                // ALTERAR
                int id[] = this.gerTarefas.getGerenciaDaoDominio().alterarLocacao(this.gerTarefas.getGerEdicao().getLocacaoSelecionada(),cliente,aeronave,dataLocacao,dataLimite,valor);
                JOptionPane.showMessageDialog(this, "Locacao do cliente: " +id[0]+" com a aeronave: "+id[1]+ " alterada com sucesso.");
            }
        } catch (ParseException | HibernateException ex) {
            JOptionPane.showMessageDialog(this, "Erro: "+ex);
        }finally{
            this.gerTarefas.getGerEdicao().setLocacaoSelecionada(null);
            this.gerTarefas.habilitarBotoes(this.gerTarefas.getGerEdicao().getLocacaoSelecionada(), btlAdd, btlAlterar);
            this.limparCampos();
        }                
    }//GEN-LAST:event_btlAddActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            preencherCampos(this.gerTarefas.getGerEdicao().getLocacaoSelecionada());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro: "+ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlAdd;
    private javax.swing.JButton btlAlterar;
    private javax.swing.JButton btlPesquisar;
    private javax.swing.JButton btlSair;
    private javax.swing.JComboBox<String> jComboBoxA;
    private javax.swing.JComboBox<String> jComboBoxC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtDataLimite;
    private javax.swing.JFormattedTextField txtDataLocacao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
