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
    
    public void inserirPais(Pais pais){      
        
    }/*
    public void excluirPais(Pais pais){
        
    }
    public void alterarPais(Pais pais){
        
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
