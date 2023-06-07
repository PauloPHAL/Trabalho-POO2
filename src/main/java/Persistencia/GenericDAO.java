package Persistencia;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class GenericDAO {
    //CRUD:
    //----------------------------------------------------------------    
    public void inserir(Object obj) throws HibernateException {
        Session sessao = null;        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÕES
            sessao.save(obj);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException erro) {
            if ( sessao != null ){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }
    }
    
    public void alterar(Object obj) throws HibernateException {
        Session sessao = null;        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÕES
            sessao.update(obj);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException erro) {
            if ( sessao != null ){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }       
    }
    
    public void excluir(Object obj) throws HibernateException {
        Session sessao = null;        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            // OPERAÇÕES
            sessao.delete(obj);
            
            sessao.getTransaction().commit();
            sessao.close();
        } catch ( HibernateException erro) {
            if ( sessao != null ){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(erro);
        }    
    }  
    
    public List listar(Class classe) throws HibernateException {
        Session sessao = null;
        List lista = null;
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
    // -----------------------------------------------
    // Se não existir no banco retorna NULL
    // -----------------------------------------------
    public Object get(Class classe, int id) throws HibernateException {
        Session sessao = null;
        Object objReturn = null;
        try{
          sessao = ConexaoHibernate.getSessionFactory().openSession();
          sessao.getTransaction().begin();

          objReturn = sessao.get(classe, id );

          sessao.getTransaction().commit();
          sessao.close();
        }catch(HibernateException ex){
            if( sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return objReturn;
    }    
    // -----------------------------------------------------
    //  Se não existir no banco, retorna uma EXCEÇÃO
    // ----------------------------------------------------
    // Sempre retorna um PROXY e não o objeto em si.
    // PROXY é apenas uma referência ao objeto. 
    // Ele será realmente carregado quando o primeiro acesso
    // for feito ao objeto
    // ENTÃO, por isso que colocamos um primeiro acesso ao objeto 
    // dentro dessa função, como o método toString (somente para teste)
    public Object load(Class classe, int id) throws HibernateException {
        Session sessao = null;
        Object objReturn = null;
        try{
          sessao = ConexaoHibernate.getSessionFactory().openSession();
          sessao.getTransaction().begin();

          objReturn = sessao.load(classe, id );
          objReturn.toString();

          sessao.getTransaction().commit();
          sessao.close();
        } catch(HibernateException ex){
            if(sessao != null){
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return objReturn;
    }
}
