package Gerencia;

import Persistencia.ConexaoHibernate;

public class GerTarefasDaoDominio {

    public GerTarefasDaoDominio(){
        ConexaoHibernate.getSessionFactory();
    }
    
    
    
}
