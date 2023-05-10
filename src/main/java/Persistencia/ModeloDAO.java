package Persistencia;

import Dominio.Modelo;
import java.util.List;

public class ModeloDAO extends GenericDAO{
    // padrao Singleton
    private static ModeloDAO gerenciador; 
    private ModeloDAO(){
    }
    public static ModeloDAO getConexão(){
        if(gerenciador == null){
            gerenciador = new ModeloDAO();
        }
        return gerenciador;
    }  
    private List<Modelo> pesquisarModelo(String pesq, int tipo){
        return null;
    }
    //----------------------------------------------------------------
    public List<Modelo> listar(){
        return pesquisarModelo("",-1);
    }       
    public List<Modelo> pesquisarNome(String pesq){
        return pesquisarModelo(pesq,0);
    }
    public List<Modelo> pesquisarMes(String pesq){
        return pesquisarModelo(pesq,1);
    }   
    public List<Modelo> pesquisarFabr(String pesq){
        return pesquisarModelo(pesq,3);
    }
    public List<Modelo> pesquisarCapacidade(String pesq){
        return pesquisarModelo(pesq,4);
    }
}
