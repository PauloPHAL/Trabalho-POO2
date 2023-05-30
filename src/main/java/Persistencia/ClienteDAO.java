package Persistencia;

import Dominio.Cliente;
import java.util.List;
import javax.persistence.criteria.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ClienteDAO extends GenericDAO{
    // padrao Singleton
    private static ClienteDAO gerenciador; 
    private ClienteDAO(){
    }
    public static ClienteDAO getConexão(){
        if(gerenciador == null){
            gerenciador = new ClienteDAO();
        }
        return gerenciador;
    }
    private List<Cliente> pesquisarCliente(String pesq, int tipo){
        List lista = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // Construtor da CONSULTA
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery( Cliente.class );
            
            // FROM
            Root tabela = consulta.from(Cliente.class);
            
            // RESTRIÇÕES
            Predicate restricoes = null;
            
            switch (tipo) {
                case 0: restricoes = builder.like(tabela.get("nome"), pesq + "%" ); 
                        break;
                case 1: Expression exp = builder.function("month", Integer.class, tabela.get("dataNascimento"));
                        restricoes = builder.equal(exp, pesq);
                        break;                       
                case 2: restricoes = builder.like(tabela.get("sexo"), pesq); 
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
    public List<Cliente> pesquisarNome(String pesq){
        return pesquisarCliente(pesq,0);
    }
    public List<Cliente> pesquisarData(String pesq){
        return pesquisarCliente(pesq,1);
    }
    public List<Cliente> pesquisarSexo(String pesq){
        return pesquisarCliente(pesq,2);
    }
}
