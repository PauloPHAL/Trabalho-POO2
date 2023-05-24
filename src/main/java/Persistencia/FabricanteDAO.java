package Persistencia;

import Dominio.Fabricante;
import Dominio.Modelo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
