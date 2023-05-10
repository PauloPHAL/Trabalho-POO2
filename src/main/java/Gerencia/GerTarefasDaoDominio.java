package Gerencia;

import Dominio.Fabricante;
import Dominio.Modelo;
import Dominio.Pais;
import Persistencia.*;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;

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
    //------------------------------------------------------
    public int inserirAeronave(){
        
        return 1;
    }
    public int alterarAeronave(){
        return 1;
    }
    
    //------------------------------------------------------
    public int inserirModelo(String nome, String tipo, int capacidade, Date dataModelo, byte[] fotoModelo, Fabricante fabricante){
        Modelo modelo = new Modelo(nome,tipo,capacidade,dataModelo,fotoModelo,fabricante);
        modeloDao.inserir(modelo);
        return modelo.getIdModelo();
    }
    public int alterarModelo(){
        return 1;
    }
    
    //------------------------------------------------------
    public int inserirFabricante(String nome, Date dataFundacao, byte[] logo, Pais pais){
        Fabricante fabricante = new Fabricante(nome,dataFundacao,logo,pais);
        fabricanteDao.inserir(fabricante);
        return fabricante.getIdFabricante();
    }
    public int alterarFabricante(){
        return 1;
    }
    
    //------------------------------------------------------
    public int inserirCliente(){
        
        return 1;
    }
    public int alterarCliente(){
        return 1;
    }
    
    //------------------------------------------------------
    public int inserirPais(String nome){
        Pais pais = new Pais(nome);
        paisDao.inserir(pais);
        return pais.getIdPais();
    }
    //------------------------------------------------------
    public List listar(Class classe) throws HibernateException{
        return genericDao.listar(classe);
    }
    
    
}
