package Persistencia;

import Dominio.Pais;
import java.util.List;

public class PaisDAO {
    // padrao Singleton
    private static PaisDAO gerenciador; 
    private PaisDAO(){
    }
    public static PaisDAO getConexão(){
        if(gerenciador == null){
            gerenciador = new PaisDAO();
        }
        return gerenciador;
    }
    //CRUD:
    //----------------------------------------------------------------
    /*
    public void inserirPais(Pais modelo){      
        
    }
    public void excluirPais(Pais modelo){
        
    }
    public void alterarPais(Pais modelo){
        
    }
    */
    private List<Pais> pesquisarPais(String pesq, int tipo){
        return null;
    }
    //----------------------------------------------------------------      
    public List<Pais> listar(){
        return pesquisarPais("",-1);
    } 
    
}
