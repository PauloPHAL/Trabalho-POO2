package Persistencia;

import Dominio.Aeronave;
import java.util.List;
import javax.persistence.criteria.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class AeronaveDAO extends GenericDAO{
    // padrao Singleton
    private static AeronaveDAO gerenciador; 
    private AeronaveDAO(){
    }
    public static AeronaveDAO getConexão(){
        if(gerenciador == null){
            gerenciador = new AeronaveDAO();
        }
        return gerenciador;
    }
    private List<Aeronave> pesquisarAeronave(String pesq, int tipo){
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( Aeronave.class );
            
            // FROM
            Root tabela = consulta.from(Aeronave.class);
            
            // RESTRIÇÕES
            Predicate restricoes = null;
            
            switch (tipo) {
                case 0: restricoes = builder.like(tabela.get("modelo").get("nome"), pesq + "%" ); 
                        break;
                case 1: Expression exp = builder.function("month", Integer.class, tabela.get("dataCompra"));
                        restricoes = builder.equal(exp, pesq);
                        break;                       
                case 2: restricoes = builder.like(tabela.get("modelo").get("fabricante").get("nome"), pesq + "%" ); 
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
    public List<Aeronave> pesquisarModelo(String pesq){
        return pesquisarAeronave(pesq,0);
    }   
    public List<Aeronave> pesquisarMes(String pesq){
        return pesquisarAeronave(pesq,1);
    }   
    public List<Aeronave> pesquisarFabr(String pesq){
        return pesquisarAeronave(pesq,2);
    }
}
