package Persistencia;

import Dominio.Fabricante;
import java.util.List;

public class FabricanteDAO extends GenericDAO{
    // padrao Singleton
    private static FabricanteDAO gerenciador; 
    private FabricanteDAO(){
    }
    public static FabricanteDAO getConexão(){
        if(gerenciador == null){
            gerenciador = new FabricanteDAO();
        }
        return gerenciador;
    }
    private List<Fabricante> pesquisarFabricante(String pesq, int tipo){
        return null;
    }   
    //----------------------------------------------------------------
    public List<Fabricante> listar(){
        return pesquisarFabricante("",-1);
    }       
    public List<Fabricante> pesquisarNome(String pesq){
        return pesquisarFabricante(pesq,0);
    }
    public List<Fabricante> pesquisarPais(String pesq){
        return pesquisarFabricante(pesq,1);
    }   
}
