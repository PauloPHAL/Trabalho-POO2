package Gerencia;

import Persistencia.*;

public class GerTarefasDaoDominio {
    // classes DAO
    private GenericDAO genericDao;
    private AeronaveDAO aeronaveDao;
    private ModeloDAO modeloDao;
    private FabricanteDAO fabricanteDao;
    private ClienteDAO clienteDao;
    private LocacaoDAO locacaoDao;
    private PaisDAO paisDao;
    // padrao Singleton
    private static GerTarefasDaoDominio gerenciador; 
    private GerTarefasDaoDominio(){
        ConexaoHibernate.getSessionFactory();
        this.genericDao = new GenericDAO();
        this.aeronaveDao = AeronaveDAO.getConexão();
        this.modeloDao = ModeloDAO.getConexão();
        this.fabricanteDao = FabricanteDAO.getConexão();
        this.clienteDao = ClienteDAO.getConexão();
        this.locacaoDao = LocacaoDAO.getConexão();
        this.paisDao = PaisDAO.getConexão();
    }
    public static GerTarefasDaoDominio getConexão(){
        if(gerenciador == null){
            gerenciador = new GerTarefasDaoDominio();
        }
        return gerenciador;
    }
    
}
