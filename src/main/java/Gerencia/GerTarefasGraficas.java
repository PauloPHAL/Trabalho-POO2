package Gerencia;

import java.util.List;
import Dominio.Pais;
import Interface.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
import org.hibernate.HibernateException;

public class GerTarefasGraficas {
    //acessos
    private Principal frmPrincipal;
    //------------------ Cadastro
    private CadastrarFabricante dlgCadFabricante;
    private CadastrarModelo dlgCadModelo;
    private CadastrarAeronave dlgCadAeronave;
    private CadastrarPais dlgCadPais;
    private CadastrarLocacao dlgCadLocacao;
    private CadastrarCliente dlgCadCliente;
    
    //------------------ Pesquisa
    private PesquisarFabricante dlgPesqFabricante;
    private PesquisarModelo dlgPesqModelo;
    private PesquisarAeronave dlgPesqAeronave;
    private PesquisarLocacao dlgPesqLocacao;
    private PesquisarCliente dlgPesqCliente;
    
    //------------------ Genrencia de Dominio
    private GerTarefasDaoDominio gerenciaDaoDominio;
    private GerenciaDeEdicao gerEdicao;
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
        this.dlgPesqCliente = null;
        this.dlgPesqLocacao = null;
        this.dlgCadCliente = null;
        this.dlgCadLocacao = null;
        
        //Gerencia de edicao
        this.gerEdicao = new GerenciaDeEdicao();
        
        //Conexao
        this.gerenciaDaoDominio = GerTarefasDaoDominio.getConexão();
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
    public void abrirCadCliente(){
        dlgCadCliente = (CadastrarCliente) abrirJanela(frmPrincipal,dlgCadCliente,CadastrarCliente.class);
    }
    public void abrirCadLocacao(){
        dlgCadLocacao = (CadastrarLocacao) abrirJanela(frmPrincipal,dlgCadLocacao,CadastrarLocacao.class);
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
    public void abrirPesqCliente(){
        dlgPesqCliente = (PesquisarCliente) abrirJanela(frmPrincipal,dlgPesqCliente,PesquisarCliente.class);
    }
    public void abrirPesqLocacao(){
        dlgPesqLocacao = (PesquisarLocacao) abrirJanela(frmPrincipal,dlgPesqLocacao,PesquisarLocacao.class);
    }
    //-----------------------------------------------------------------------------------------
    //Acesso a classe Gerencia de Dominio e DAO, Edicao
    public GerTarefasDaoDominio getGerenciaDaoDominio() {
        return gerenciaDaoDominio;
    }
    public GerenciaDeEdicao getGerEdicao() {
        return gerEdicao;
    }   
    //-----------------------------------------------------------------------------------------
    //Abrir Foto
    public void abrirFoto(JLabel lblFoto,JDialog janela){
        JFileChooser janArq = new JFileChooser();      
        janArq.setAcceptAllFileFilterUsed(false);
        janArq.setFileFilter( new FileNameExtensionFilter("Arquivos de imagem", "jpg", "png", "gif", "bmp") );
        janArq.addChoosableFileFilter( new FileNameExtensionFilter("Arquivos de texto", "txt", "doc", "docx") );     
        if ( janArq.showOpenDialog(janela) == JFileChooser.APPROVE_OPTION  ) {
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
    //-----------------------------------------------------------------------------------------
    //Habilitar Botoes
    public void habilitarBotoes(Object obj, JButton btnNovo, JButton btnAlterar){
        if ( obj == null ) {
            btnNovo.setVisible(true);
            btnAlterar.setVisible(false);
        } else {
            btnNovo.setVisible(false);
            btnAlterar.setVisible(true);
        } 
    }
    //-----------------------------------------------------------------------------------------
    //Carregar Combo Box
    public void carregarComboBox(JComboBox combo, JDialog janela){    
        try {
            List<Pais> lista = this.gerenciaDaoDominio.listarPais();
            combo.setModel(new DefaultComboBoxModel(lista.toArray()) );
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(frmPrincipal, "Erro carregar Modelo:"+ ex);
        }        
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
