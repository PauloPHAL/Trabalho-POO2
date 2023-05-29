package Persistencia;

import Dominio.Modelo;
import java.util.List;
import javax.persistence.criteria.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
    private List<Modelo> pesquisarModelo(String pesq, int tipo)throws HibernateException{
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( Modelo.class );
            
            // FROM
            Root tabela = consulta.from(Modelo.class);
            
            // RESTRIÇÕES
            Predicate restricoes = null;
            
            switch (tipo) {
                case 0: restricoes = builder.like(tabela.get("nome"), pesq + "%" ); 
                        break;
                case 2: restricoes = builder.like(tabela.get("fabricante").get("nome"), pesq + "%" ); 
                        break;
                case 1: 
                        Expression<Integer> exp = builder.function("EXTRACT", Integer.class, builder.literal("MONTH"), tabela.get("dataModelo"));
                        restricoes = builder.equal(exp, pesq);
                        break;                   
                case 3: restricoes = builder.like(tabela.get("capacidade"), pesq ); 
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
    public List<Modelo> pesquisarNome(String pesq)throws HibernateException{
        return pesquisarModelo(pesq,0);
    }
    public List<Modelo> pesquisarMes(String pesq)throws HibernateException{
        return pesquisarModelo(pesq,1);
    }   
    public List<Modelo> pesquisarFabr(String pesq)throws HibernateException{
        return pesquisarModelo(pesq,2);
    }
    public List<Modelo> pesquisarCapacidade(String pesq)throws HibernateException{
        return pesquisarModelo(pesq,3);
    }
}
