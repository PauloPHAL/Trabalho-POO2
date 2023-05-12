package Interface;

import Gerencia.GerTarefasGraficas;

public class Principal extends javax.swing.JFrame {
    //acesso
    private GerTarefasGraficas gerTarefas;
    
    //construtor
    public Principal(GerTarefasGraficas gerTarefas) {
        initComponents();
        setLocationRelativeTo(null);
        this.gerTarefas = gerTarefas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        btnLocar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menufabricante = new javax.swing.JMenuItem();
        menuModelo = new javax.swing.JMenuItem();
        menuAeronave = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        pesqFabricante = new javax.swing.JMenuItem();
        pesqModelo = new javax.swing.JMenuItem();
        pesqAeronave = new javax.swing.JMenuItem();
        pesqCliente = new javax.swing.JMenuItem();
        pesqLocacoes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 60, -1));

        btnLocar.setText("LOCAR");
        btnLocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLocar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intergraf/imagens/Fundo.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setText("Menu");

        menufabricante.setText("Cadastrar Fabricante");
        menufabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menufabricanteActionPerformed(evt);
            }
        });
        jMenu1.add(menufabricante);

        menuModelo.setText("Cadastrar Modelo");
        menuModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModeloActionPerformed(evt);
            }
        });
        jMenu1.add(menuModelo);

        menuAeronave.setText("Cadastrar Aeronave");
        menuAeronave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAeronaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuAeronave);

        menuCliente.setText("Cadastrar Cliente");
        menuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteActionPerformed(evt);
            }
        });
        jMenu1.add(menuCliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pesquisar");

        pesqFabricante.setText("Pesquisar Fabricante");
        pesqFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqFabricanteActionPerformed(evt);
            }
        });
        jMenu2.add(pesqFabricante);

        pesqModelo.setText("Pesquisar Modelos");
        pesqModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqModeloActionPerformed(evt);
            }
        });
        jMenu2.add(pesqModelo);

        pesqAeronave.setText("Pesquisar Aeronave");
        pesqAeronave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqAeronaveActionPerformed(evt);
            }
        });
        jMenu2.add(pesqAeronave);

        pesqCliente.setText("Pesquisar Cliente");
        pesqCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqClienteActionPerformed(evt);
            }
        });
        jMenu2.add(pesqCliente);

        pesqLocacoes.setText("Pesquisar Locacoes");
        pesqLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqLocacoesActionPerformed(evt);
            }
        });
        jMenu2.add(pesqLocacoes);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menufabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menufabricanteActionPerformed
        gerTarefas.abrirCadFabricante();
    }//GEN-LAST:event_menufabricanteActionPerformed

    private void menuModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModeloActionPerformed
        gerTarefas.abrirCadModelo();
    }//GEN-LAST:event_menuModeloActionPerformed

    private void menuAeronaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAeronaveActionPerformed
        gerTarefas.abrirCadAeronave();
    }//GEN-LAST:event_menuAeronaveActionPerformed

    private void pesqFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqFabricanteActionPerformed
        gerTarefas.abrirPesqFabricante();
    }//GEN-LAST:event_pesqFabricanteActionPerformed

    private void pesqModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqModeloActionPerformed
        gerTarefas.abrirPesqModelo();
    }//GEN-LAST:event_pesqModeloActionPerformed

    private void pesqAeronaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqAeronaveActionPerformed
        gerTarefas.abrirPesqAeronave();
    }//GEN-LAST:event_pesqAeronaveActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        gerTarefas.cursorFora(this);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        gerTarefas.cursorDentro(this);
    }//GEN-LAST:event_formMouseExited

    private void pesqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqClienteActionPerformed
        gerTarefas.abrirPesqCliente();
    }//GEN-LAST:event_pesqClienteActionPerformed

    private void pesqLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqLocacoesActionPerformed
        gerTarefas.abrirPesqLocacao();
    }//GEN-LAST:event_pesqLocacoesActionPerformed

    private void menuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteActionPerformed
        gerTarefas.abrirCadCliente();
    }//GEN-LAST:event_menuClienteActionPerformed

    private void btnLocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocarActionPerformed
        gerTarefas.abrirCadLocacao();
    }//GEN-LAST:event_btnLocarActionPerformed

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLocar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuAeronave;
    private javax.swing.JMenuItem menuCliente;
    private javax.swing.JMenuItem menuModelo;
    private javax.swing.JMenuItem menufabricante;
    private javax.swing.JMenuItem pesqAeronave;
    private javax.swing.JMenuItem pesqCliente;
    private javax.swing.JMenuItem pesqFabricante;
    private javax.swing.JMenuItem pesqLocacoes;
    private javax.swing.JMenuItem pesqModelo;
    // End of variables declaration//GEN-END:variables
}
