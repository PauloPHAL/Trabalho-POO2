package Persistencia;

import Dominio.Fabricante;
import java.util.List;
import javax.persistence.criteria.*;
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
    private List<Fabricante> pesquisarFabricante(String pesq, int tipo)throws HibernateException{
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( Fabricante.class );
            
            // FROM
            Root tabela = consulta.from(Fabricante.class);
            
            // RESTRIÇÕES
            Predicate restricoes = null;
            
            switch (tipo) {
                case 0: restricoes = builder.like(tabela.get("nome"), pesq + "%" ); 
                        break;
                case 1: restricoes = builder.like(tabela.get("pais").get("nome"), pesq + "%" ); 
                        break;                      
            }
                        
            consulta.where(restricoes);
            lista = sessao.createQuery(consulta).getResultList();            

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null ) {
                sessao.getTransaction().rollback();          
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return lista;
    }   
    //----------------------------------------------------------------
    public List<Fabricante> pesquisarNome(String pesq)throws HibernateException{
        return pesquisarFabricante(pesq,0);
    }
    public List<Fabricante> pesquisarPais(String pesq)throws HibernateException{
        return pesquisarFabricante(pesq,1);
    }   
}
