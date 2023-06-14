package Interface;

import Dominio.Fabricante;
import Dominio.Modelo;
import Gerencia.FuncoesUteis;
import Gerencia.GerTarefasGraficas;
import java.text.ParseException;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

public class CadastrarModelo extends javax.swing.JDialog {
    //acessos
    private GerTarefasGraficas gerTarefas;
    private boolean controle = false;
    
    //construtor 
    public CadastrarModelo(java.awt.Frame parent, boolean modal, GerTarefasGraficas gerTarefas) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.rdComercial.setSelected(true);
        this.gerTarefas = gerTarefas;
        this.gerTarefas.habilitarBotoes(this.gerTarefas.getGerEdicao().getModeloSelecionado(), btlAdd, btlAlterar);
    }
    
    private void preencherCampos(Modelo modelo) throws ParseException{
        if (modelo != null ) {
            this.txtNome.setText(modelo.getNome());          
            this.txtData.setText(modelo.getDataModeloFormatada());
            this.txtCapacidade.setText(FuncoesUteis.intToString(modelo.getCapacidade()));
            this.jComboBox1.setSelectedItem(modelo.getFabricante());           
            
            if(modelo.getTipo().equals("Comercial")){
                this.rdComercial.setSelected(true);
            }else if(modelo.getTipo().equals("Militar")){
                this.rdMilitar.setSelected(true);
            }else{
                this.rdExecutiva.setSelected(true);
            }
            if (!controle) {
                if (modelo.getFotoModelo() != null) { 
                    ImageIcon imagem = new ImageIcon( modelo.getFotoModelo());
                    this.gerTarefas.mostrarFoto(imagem, lblFotoModelo);
                } else {
                    lblFotoModelo.setText("Foto Modelo");
                    lblFotoModelo.setIcon(null);
                }
            }
            this.gerTarefas.habilitarBotoes(this.gerTarefas.getGerEdicao().getModeloSelecionado(), btlAdd, btlAlterar);
        }else{
            this.limparCampos();
            this.gerTarefas.habilitarBotoes(this.gerTarefas.getGerEdicao().getModeloSelecionado(), btlAdd, btlAlterar);
        }
    }
    
    private void limparCampos(){
        if (!controle) {
            lblFotoModelo.setText("Foto");
            lblFotoModelo.setIcon(null);
            this.txtNome.setText("");          
            this.txtData.setText("");
            this.txtCapacidade.setText("");
            this.jComboBox1.setSelectedIndex(0);
            this.rdComercial.setSelected(true);
            this.controle = false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoTipoAeronave = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rdComercial = new javax.swing.JRadioButton();
        rdMilitar = new javax.swing.JRadioButton();
        rdExecutiva = new javax.swing.JRadioButton();
        btlSair = new javax.swing.JButton();
        btlAdd = new javax.swing.JButton();
        btlAlterar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCapacidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btlPesquisar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblFotoModelo = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRAR MODELO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 0, 204))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Aeronave"));

        grupoTipoAeronave.add(rdComercial);
        rdComercial.setMnemonic('C');
        rdComercial.setText("Comercial");

        grupoTipoAeronave.add(rdMilitar);
        rdMilitar.setMnemonic('M');
        rdMilitar.setText("Militar");

        grupoTipoAeronave.add(rdExecutiva);
        rdExecutiva.setMnemonic('E');
        rdExecutiva.setText("Executiva");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdComercial)
                    .addComponent(rdMilitar)
                    .addComponent(rdExecutiva))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdComercial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdExecutiva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdMilitar))
        );

        btlSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/remove.png"))); // NOI18N
        btlSair.setText("Cancelar");
        btlSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlSairActionPerformed(evt);
            }
        });

        btlAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/add.png"))); // NOI18N
        btlAdd.setText("Adicionar");
        btlAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlAddActionPerformed(evt);
            }
        });

        btlAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/accept.png"))); // NOI18N
        btlAlterar.setText("Alterar");
        btlAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlAddActionPerformed(evt);
            }
        });

        jLabel3.setText("DATA DE CRIACAO:");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("NUMERO DE PASSAGEIROS:");

        jLabel2.setText("NOME DO MODELO:");

        btlPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/search.png"))); // NOI18N
        btlPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlPesquisarActionPerformed(evt);
            }
        });

        lblFotoModelo.setText("FOTO DO MODELO");
        lblFotoModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFotoModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoModeloMouseClicked(evt);
            }
        });

        jLabel5.setText("FABRICANTE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btlAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btlAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btlSair))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNome)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btlPesquisar))
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(lblFotoModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btlPesquisar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFotoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btlSair)
                            .addComponent(btlAdd)
                            .addComponent(btlAlterar)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        this.controle = false;
        gerTarefas.abrirPesqModelo();
        try {
            preencherCampos(this.gerTarefas.getGerEdicao().getModeloSelecionado());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro: "+ex);
        }
    }//GEN-LAST:event_btlPesquisarActionPerformed

    private void lblFotoModeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoModeloMouseClicked
        gerTarefas.abrirFoto(lblFotoModelo,this);
        this.controle = true;
    }//GEN-LAST:event_lblFotoModeloMouseClicked

    private void btlSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlSairActionPerformed
        this.gerTarefas.getGerEdicao().setModeloSelecionado(null);
        this.controle = false;
        this.dispose();
    }//GEN-LAST:event_btlSairActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        gerTarefas.cursorFora(this);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        gerTarefas.cursorDentro(this);
    }//GEN-LAST:event_formMouseExited

    private void btlAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlAddActionPerformed
        try {
            //pegando os dados
            String tipo;
            String nome = this.txtNome.getText();
            String c = this.txtCapacidade.getText();
            String d = this.txtData.getText();
            char t = (char) this.grupoTipoAeronave.getSelection().getMnemonic();
            Fabricante fabricante = (Fabricante) this.jComboBox1.getSelectedItem();
            Icon f = this.lblFotoModelo.getIcon(); 
            
            //tratando os dados que precisa
            Date data = FuncoesUteis.strToDate(d);
            byte[] foto = FuncoesUteis.IconToBytes(f);
            int capacidade = Integer.parseInt(c);
            
            // INSERIR NO BANCO           
            if(t == 'C'){
                tipo = "Comercial";
            }else if(t == 'M'){
                tipo = "Militar";
            }else{
                tipo = "Execultiva";
            }
            //------------------------------------------------------------------------------
            if ( this.gerTarefas.getGerEdicao().getModeloSelecionado() == null) {
                // INSERIR
                int id = this.gerTarefas.getGerenciaDaoDominio().inserirModelo(nome,tipo,capacidade,data,foto,fabricante);
                JOptionPane.showMessageDialog(this, "Modelo " + id + " inserido com sucesso.");
            } else {
                // ALTERAR
                int id = this.gerTarefas.getGerenciaDaoDominio().alterarModelo(this.gerTarefas.getGerEdicao().getModeloSelecionado(),nome,tipo,capacidade,data,foto,fabricante);                
                JOptionPane.showMessageDialog(this, "Modelo " + id + " alterado com sucesso.");
            }
        } catch (ParseException | HibernateException ex) {
            JOptionPane.showMessageDialog(this, "Erro: "+ex);
        }finally{
            this.gerTarefas.getGerEdicao().setModeloSelecionado(null);
            this.gerTarefas.habilitarBotoes(this.gerTarefas.getGerEdicao().getModeloSelecionado(), btlAdd, btlAlterar);
            this.controle = false;
            this.limparCampos();
        }                 
    }//GEN-LAST:event_btlAddActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        this.gerTarefas.carregarComboBox(jComboBox1, this, Fabricante.class);
    }//GEN-LAST:event_formComponentShown

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            preencherCampos(this.gerTarefas.getGerEdicao().getModeloSelecionado());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro: "+ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlAdd;
    private javax.swing.JButton btlAlterar;
    private javax.swing.JButton btlPesquisar;
    private javax.swing.JButton btlSair;
    private javax.swing.ButtonGroup grupoTipoAeronave;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFotoModelo;
    private javax.swing.JRadioButton rdComercial;
    private javax.swing.JRadioButton rdExecutiva;
    private javax.swing.JRadioButton rdMilitar;
    private javax.swing.JTextField txtCapacidade;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
