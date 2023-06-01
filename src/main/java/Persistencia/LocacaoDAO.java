package Persistencia;

import Dominio.Locacao;
import java.util.List;
import javax.persistence.criteria.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class LocacaoDAO extends GenericDAO{
    // padrao Singleton
    private static LocacaoDAO gerenciador; 
    private LocacaoDAO(){
    }
    public static LocacaoDAO getConexão(){
        if(gerenciador == null){
            gerenciador = new LocacaoDAO();
        }
        return gerenciador;
    }
    private List<Locacao> pesquisarLocacao(String pesq, int tipo){
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( Locacao.class );
            
            // FROM
            Root tabela = consulta.from(Locacao.class);
            
            // RESTRIÇÕES
            Predicate restricoes = null;
            
            switch (tipo) {
                case 0: restricoes = builder.like(tabela.get("chaveComposta").get("cliente").get("nome"), pesq +"%"); 
                        break;                      
                case 1: restricoes = builder.like(tabela.get("chaveComposta").get("aeronave").get("nome"), pesq +"%"); 
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
    public List<Locacao> pesquisarCliente(String pesq){
        return pesquisarLocacao(pesq,0);
    }
    public List<Locacao> pesquisarAeronave(String pesq){
        return pesquisarLocacao(pesq,1);
    }
}
