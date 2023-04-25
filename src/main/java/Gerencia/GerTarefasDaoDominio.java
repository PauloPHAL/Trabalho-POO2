package Gerencia;

import Persistencia.*;

public class GerTarefasDaoDominio {
    // classes DAO
    private AeronaveDAO aeronaveDao;
    private ModeloDAO modeloDao;
    private FabricanteDAO fabricanteDao;
    // padrao Singleton
    private static GerTarefasDaoDominio gerenciador; 
    private GerTarefasDaoDominio(){
        ConexaoHibernate.getSessionFactory();
        this.aeronaveDao = AeronaveDAO.getConexão();
        this.modeloDao = ModeloDAO.getConexão();
        this.fabricanteDao = FabricanteDAO.getConexão();
    }
    public static GerTarefasDaoDominio getConexão(){
        if(gerenciador == null){
            gerenciador = new GerTarefasDaoDominio();
        }
        return gerenciador;
    }
    
    public void inserirAeronave(){
        aeronaveDao.inserirAeronave(null);
    }
}
