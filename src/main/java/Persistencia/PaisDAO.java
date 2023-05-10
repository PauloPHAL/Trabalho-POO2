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
    public List<Pais> listar(Class classe){
        Session sessao = null;
        List<Pais> lista = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÕES
            CriteriaQuery consulta = sessao.getCriteriaBuilder().createQuery(classe);
            consulta.from(classe);
            lista = sessao.createQuery(consulta).getResultList();
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException erro) {
            if ( sessao != null ){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }               
        return lista;
    } 
    
}
