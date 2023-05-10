package Persistencia;

import Dominio.Pais;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PaisDAO extends GenericDAO{
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
    private List<Pais> pesquisarPais(String pesq, int tipo){
        return null;
    }
    //----------------------------------------------------------------      
    public List<Pais> listar(){
        return null;
    } 
    
}
