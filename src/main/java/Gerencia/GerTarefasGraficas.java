
package Gerencia;

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
    
    private GerTarefasDao gerenciaDAO;
    
    //construtor
    public GerTarefasGraficas(){
        this.frmPrincipal = null;
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
                    
                }
            } catch (NoSuchMethodException | SecurityException ex) {
                
            }       
        }
        dlg.setVisible(true);
        return dlg;
    }
    private void abrirPrincipal(){
        if(this.frmPrincipal == null){
            frmPrincipal = new Principal(this);
        }
        frmPrincipal.setVisible(true);
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
            GerTarefasGraficas gerencia = new GerTarefasGraficas();
            gerencia.abrirPrincipal();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }  
}
