package Interface;

import Dominio.Fabricante;
import Dominio.Modelo;
import Gerencia.FuncoesUteis;
import Gerencia.GerTarefasGraficas;
import java.text.ParseException;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class CadastrarAeronave extends javax.swing.JDialog {
    //acesso
    private GerTarefasGraficas gerTarefas;
    
    //construtor   
    public CadastrarAeronave(java.awt.Frame parent, boolean modal, GerTarefasGraficas gerTarefas) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.gerTarefas = gerTarefas;
        this.gerTarefas.habilitarBotoes(this.gerTarefas.getGerEdicao().getAeronaveSelecionada(), btnNovo, btnAlterar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxF = new javax.swing.JComboBox<>();
        jComboBoxM = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btlSair = new javax.swing.JButton();
        txtData = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNumSerie = new javax.swing.JTextField();
        btlPesquisar = new javax.swing.JButton();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRAR AERONAVE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        jLabel1.setText("FABRICANTES:");

        jLabel2.setText("MODELOS:");

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/accept.png"))); // NOI18N
        btnAlterar.setText("Alterar");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/add.png"))); // NOI18N
        btnNovo.setText("Adicionar");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
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
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("DATA DE AQUISIÇÃO:");

        jLabel4.setText("NUMERO DE SERIE:");

        btlPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/search.png"))); // NOI18N
        btlPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 66, Short.MAX_VALUE)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btlSair))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxF, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxM, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btlPesquisar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btlPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btlSair)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btlPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlPesquisarActionPerformed
        gerTarefas.abrirPesqAeronave();
    }//GEN-LAST:event_btlPesquisarActionPerformed

    private void btlSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btlSairActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        gerTarefas.cursorFora(this);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        gerTarefas.cursorDentro(this);
    }//GEN-LAST:event_formMouseExited

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        this.gerTarefas.carregarComboBox(jComboBoxF, this, Fabricante.class);
        this.gerTarefas.carregarComboBox(jComboBoxM, this, Modelo.class);
    }//GEN-LAST:event_formComponentShown

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        try {
            //pegando os dados
            String numeroSerie = this.txtNumSerie.getText();
            String d = this.txtData.getText();           
            Modelo modelo = (Modelo) this.jComboBoxM.getSelectedItem();            
            
            //tratando os dados que precisa
            Date data = FuncoesUteis.strToDate(d);
            
            // INSERIR NO BANCO                      
            //------------------------------------------------------------------------------
            if ( this.gerTarefas.getGerEdicao().getAeronaveSelecionada() == null) {
                // INSERIR
                int id = this.gerTarefas.getGerenciaDaoDominio().inserirAeronave(numeroSerie, data, modelo);
                JOptionPane.showMessageDialog(this, "Aeronave " + id + " inserida com sucesso.");
            } else {
                // ALTERAR
                this.gerTarefas.getGerenciaDaoDominio().alterarAeronave();
                int id = this.gerTarefas.getGerEdicao().getAeronaveSelecionada().getIdAeronave();
                JOptionPane.showMessageDialog(this, "Aeronave " + id + " alterada com sucesso.");
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro: "+ex);
        }                 
    }//GEN-LAST:event_btnNovoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlPesquisar;
    private javax.swing.JButton btlSair;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> jComboBoxF;
    private javax.swing.JComboBox<String> jComboBoxM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtNumSerie;
    // End of variables declaration//GEN-END:variables
}
