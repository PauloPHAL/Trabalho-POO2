package Gerencia;

import Interface.CadastrarAeronave;
import Interface.CadastrarFabricante;
import Interface.CadastrarModelo;
import Interface.CadastrarPais;
import Interface.PesquisarAeronave;
import Interface.PesquisarFabricante;
import Interface.PesquisarModelo;
import Interface.Principal;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class GerTarefasGraficas {
    //acessos
    private Principal frmPrincipal;
    //------------------ Cadastro
    private CadastrarFabricante dlgCadFabricante;
    private CadastrarModelo dlgCadModelo;
    private CadastrarAeronave dlgCadAeronave;
    private CadastrarPais dlgCadPais;
    
    //------------------ Pesquisa
    private PesquisarFabricante dlgPesqFabricante;
    private PesquisarModelo dlgPesqModelo;
    private PesquisarAeronave dlgPesqAeronave;
    
    //------------------ Genrencia de Dominio
    private GerTarefasDaoDominio gerenciaDaoDominio;
    
    //construtor
    public GerTarefasGraficas(){
        this.frmPrincipal = null;
        this.dlgCadFabricante = null;
        this.dlgCadModelo = null;
        this.dlgCadAeronave = null;
        this.dlgCadPais = null;
        this.dlgPesqFabricante = null;
        this.dlgPesqModelo = null;
        this.dlgPesqAeronave = null;
//        try {
//            this.gerenciaDaoDominio = new GerTarefasDaoDominio();
//        } catch (ClassNotFoundException | SQLException ex) {
//            JOptionPane.showMessageDialog(this.frmPrincipal, ex);
//            System.exit(-1);
//        }
    }
       
    //Abrir Janelas   
    private JDialog abrirJanela(java.awt.Frame parent, JDialog dlg, Class classe){
        if(dlg == null){
            try {
                try {
                    dlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerTarefasGraficas.class).newInstance(parent,true,this);
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    JOptionPane.showMessageDialog(frmPrincipal, "Erro!: "+ex);
                }
            } catch (NoSuchMethodException | SecurityException ex) {
                JOptionPane.showMessageDialog(frmPrincipal, "Erro!: "+ex);
            }       
        }
        dlg.setVisible(true);
        return dlg;
    }
    public void abrirPrincipal(){
        if(this.frmPrincipal == null){
            frmPrincipal = new Principal(this);
        }
        frmPrincipal.setVisible(true);
    }
    public void abrirCadFabricante(){
        dlgCadFabricante = (CadastrarFabricante) abrirJanela(frmPrincipal,dlgCadFabricante,CadastrarFabricante.class);
    }
    public void abrirCadModelo(){
        dlgCadModelo = (CadastrarModelo) abrirJanela(frmPrincipal,dlgCadModelo,CadastrarModelo.class);
    }
    public void abrirCadAeronave(){
        dlgCadAeronave = (CadastrarAeronave) abrirJanela(frmPrincipal,dlgCadAeronave,CadastrarAeronave.class);
    }
    public void abrirCadPais(){
        dlgCadPais = (CadastrarPais) abrirJanela(frmPrincipal,dlgCadPais,CadastrarPais.class);
    }
    public void abrirPesqFabricante(){
        dlgPesqFabricante = (PesquisarFabricante) abrirJanela(frmPrincipal,dlgPesqFabricante,PesquisarFabricante.class);
    }
    public void abrirPesqModelo(){
        dlgPesqModelo = (PesquisarModelo) abrirJanela(frmPrincipal,dlgPesqModelo,PesquisarModelo.class);
    }
    public void abrirPesqAeronave(){
        dlgPesqAeronave = (PesquisarAeronave) abrirJanela(frmPrincipal,dlgPesqAeronave,PesquisarAeronave.class);
    }
    //-----------------------------------------------------------------------------------------
    //Acesso a classe Gerencia de Dominio e DAO
    public GerTarefasDaoDominio getGerenciaDaoDominio() {
        return gerenciaDaoDominio;
    }
    //-----------------------------------------------------------------------------------------
    //Abrir Foto
    public void abrirFoto(JLabel lblFoto){
        JFileChooser janArq = new JFileChooser();      
        janArq.setAcceptAllFileFilterUsed(false);
        janArq.setFileFilter( new FileNameExtensionFilter("Arquivos de imagem", "jpg", "png", "gif", "bmp") );
        janArq.addChoosableFileFilter( new FileNameExtensionFilter("Arquivos de texto", "txt", "doc", "docx") );     
        if ( janArq.showOpenDialog(frmPrincipal) == JFileChooser.APPROVE_OPTION  ) {
            File arquivo = janArq.getSelectedFile();
            Icon imagem = new ImageIcon( arquivo.getAbsolutePath() );         
            mostrarFoto(imagem,lblFoto);
        }
    }
    private void mostrarFoto(Icon ic, JLabel lblFoto){
        ImageIcon imagem = (ImageIcon) ic;
        imagem.setImage(imagem.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));      
        lblFoto.setText("");                
        lblFoto.setIcon(imagem);    
    }
    //-----------------------------------------------------------------------------------------
    //cursor Dialog e Frame
    public void cursorDentro(JFrame janela){
        janela.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public void cursorFora(JFrame janela){
        janela.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    public void cursorDentro(JDialog janela){
        janela.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public void cursorFora(JDialog janela){
        janela.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    //main
    public static void main(String[] args) {
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        GerTarefasGraficas gerencia = new GerTarefasGraficas();
        gerencia.abrirPrincipal();
    }  
}
