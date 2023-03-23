package Gerencia;

import Interface.CadastrarFabricante;
import Interface.CadastrarModelo;
import Interface.CadastrarPais;
import Interface.PesquisarFabricante;
import Interface.PesquisarModelo;
import Interface.Principal;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class GerTarefasGraficas {
    //acessos
    private Principal frmPrincipal;
    //------------------ Cadastro
    private CadastrarFabricante dlgCadFabricante;
    private CadastrarModelo dlgCadModelo;
    //private CadastrarAeronave dlgCadAeronave;
    private CadastrarPais dlgCadPais;
    
    //------------------ Pesquisa
    private PesquisarFabricante dlgPesqFabricante;
    private PesquisarModelo dlgPesqModelo;
    
    //------------------ Genrencia de Dominio
    private GerTarefasDao gerenciaDAO;
    
    //construtor
    public GerTarefasGraficas(){
        this.frmPrincipal = null;
        this.dlgCadFabricante = null;
        this.dlgCadModelo = null;
        //this.dlgCadAeronave = null;
        this.dlgCadPais = null;
        this.dlgPesqFabricante = null;
        this.dlgPesqModelo = null;
//        try {
//            this.gerenciaDAO = new GerTarefasDao();
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
        //dlgCadAeronave = (CadastrarAeronave) abrirJanela(frmPrincipal,dlgCadAeronave,CadastrarAeronave.class);
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
    //-----------------------------------------------------------------------------------------
    
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
