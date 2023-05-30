package Gerencia;

import Dominio.*;
import Dominio.Observer.*;
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
    //------------------------------------------
    private DadosSubject dados;
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
        this.dados = new DadosSubject();
    }
    public static GerTarefasDaoDominio getConexão(){
        if(gerenciador == null){
            gerenciador = new GerTarefasDaoDominio();
        }
        return gerenciador;
    }
    //------------------------------------------------------
    public int inserirAeronave(String nome, String numeroSerie, Date dataCompra, Modelo modelo)throws HibernateException{
        Aeronave aeronave = new Aeronave(nome, numeroSerie, dataCompra, modelo);
        modelo.getAeronave().add(aeronave);
        aeronaveDao.inserir(aeronave);
        return aeronave.getIdAeronave();
    }
    public int alterarAeronave(Aeronave aeronave,String nome, String numeroSerie, Date dataCompra, Modelo modelo)throws HibernateException{
        aeronave.setNome(nome);
        aeronave.setNumeroSerie(numeroSerie);
        aeronave.setDataCompra(dataCompra);
        aeronave.setModelo(modelo);
        aeronaveDao.alterar(aeronave);
        return aeronave.getIdAeronave();
    }
    
    //------------------------------------------------------
    public int inserirModelo(String nome, String tipo, int capacidade, Date dataModelo, byte[] fotoModelo, Fabricante fabricante)throws HibernateException{
        Modelo modelo = new Modelo(nome,tipo,capacidade,dataModelo,fotoModelo,fabricante);
        fabricante.getModelo().add(modelo);
        modeloDao.inserir(modelo);
        return modelo.getIdModelo();
    }
    public int alterarModelo(Modelo modelo,String nome, String tipo, int capacidade, Date dataModelo, byte[] fotoModelo, Fabricante fabricante)throws HibernateException{
        modelo.setNome(nome);
        modelo.setTipo(tipo);
        modelo.setCapacidade(capacidade);
        modelo.setDataModelo(dataModelo);
        modelo.setFotoModelo(fotoModelo);
        modelo.setFabricante(fabricante);
        modeloDao.alterar(modelo);
        return modelo.getIdModelo();
    }
    
    //------------------------------------------------------
    public int inserirFabricante(String nome, Date dataFundacao, byte[] logo, Pais pais)throws HibernateException{
        Fabricante fabricante = new Fabricante(nome,dataFundacao,logo,pais);
        fabricanteDao.inserir(fabricante);
        return fabricante.getIdFabricante();
    }
    public int alterarFabricante(Fabricante fabricante,String nome, Date dataFundacao, byte[] logo, Pais pais)throws HibernateException{
        fabricante.setNome(nome);
        fabricante.setDataFundacao(dataFundacao);
        fabricante.setLogo(logo);
        fabricante.setPais(pais);
        fabricanteDao.alterar(fabricante);
        return fabricante.getIdFabricante();
    }
    
    //------------------------------------------------------
    public int inserirCliente(String nome, String cpf, String email, String celular, char sexo, Date dataNascimento, byte[] fotoCliente)throws HibernateException{
        Cliente cliente = new Cliente(nome,cpf,email,celular,sexo,dataNascimento,fotoCliente);
        clienteDao.inserir(cliente);
        return cliente.getIdCliente();
    }
    public int alterarCliente(Cliente cliente, String nome, String cpf, String email, String celular, char sexo, Date dataNascimento, byte[] fotoCliente)throws HibernateException{
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setCelular(celular);
        cliente.setSexo(sexo);
        cliente.setDataNascimento(dataNascimento);
        cliente.setFotoCliente(fotoCliente);
        clienteDao.alterar(cliente);
        return cliente.getIdCliente();
    }
    
    //------------------------------------------------------
    public int[] inserirLocacao(Cliente cliente, Aeronave aeronave, Date dataLocacao, Date dataLimite, double valor)throws HibernateException{
        Locacao locacao = new Locacao(cliente, aeronave, dataLocacao, dataLimite, valor);
        aeronave.getLocacao().add(locacao);
        cliente.getLocacao().add(locacao);
        locacaoDao.inserir(locacao);
        int ids[] = {cliente.getIdCliente(),aeronave.getIdAeronave()};
        return ids;
    }
    public int[] alterarLocacao(Locacao locacao,Cliente cliente, Aeronave aeronave, Date dataLocacao, Date dataLimite, double valor)throws HibernateException{
        locacao.getChaveComposta().setCliente(cliente);
        locacao.getChaveComposta().setAeronave(aeronave);
        locacao.setDataLimite(dataLimite);
        locacao.setDataLocacao(dataLocacao);
        locacao.setValor(valor);
        locacaoDao.alterar(locacao);
        int ids[] = {locacao.getChaveComposta().getCliente().getIdCliente(),locacao.getChaveComposta().getAeronave().getIdAeronave()};
        return ids;
    }
 
    //------------------------------------------------------
    public int inserirPais(String nome)throws HibernateException{
        Pais pais = new Pais(nome);
        paisDao.inserir(pais);
        return pais.getIdPais();
    }
    //------------------------------------------------------
    //Generico Excluir e Listar
    public List listar(Class classe) throws HibernateException{
        return genericDao.listar(classe);
    }
    public void excluir(Object obj)throws HibernateException{
        genericDao.excluir(obj);
    }
    //------------------------------------------------------
    //Listas por Categorias
    public List listar(Class classe,String pesq, int tipo) throws HibernateException{
        List lista = null;
        if(classe.equals(Fabricante.class)){
            switch (tipo) {
                case 0: lista = listar(classe); break;
                case 1: lista = fabricanteDao.pesquisarNome(pesq); break;
                case 2: lista = fabricanteDao.pesquisarPais(pesq); break;           
            }
        }else if(classe.equals(Modelo.class)){
            switch (tipo) {
                case 0: lista = listar(classe); break;
                case 1: lista = modeloDao.pesquisarNome(pesq); break;
                case 2: lista = modeloDao.pesquisarMes(pesq); break;
                case 3: lista = modeloDao.pesquisarFabr(pesq); break;
                case 4: lista = modeloDao.pesquisarCapacidade(pesq); break;
            }
        }else if(classe.equals(Aeronave.class)){
            switch (tipo) {
                case 0: lista = listar(classe); break;
                case 1: lista = aeronaveDao.pesquisarModelo(pesq); break;
                case 2: lista = aeronaveDao.pesquisarMes(pesq); break;
                case 3: lista = aeronaveDao.pesquisarFabr(pesq); break;                          
            }
        }else if(classe.equals(Cliente.class)){
            switch (tipo) {
                case 0: lista = listar(classe); break;
                case 1: lista = clienteDao.pesquisarNome(pesq); break;
                case 2: lista = clienteDao.pesquisarData(pesq); break;
                case 3: lista = clienteDao.pesquisarSexo(pesq); break;           
            }
        }else if(classe.equals(Locacao.class)){
            switch (tipo) {
                case 0: lista = listar(classe); break;
                case 1: lista = locacaoDao.pesquisarCliente(pesq); break;
                case 2: lista = locacaoDao.pesquisarAeronave(pesq); break;          
            }
        }
        return lista;
    }
    //------------------------------------------------------
    //Padrao Observer
    public void setarDados(Aeronave aeronaveSetada){
        dados.setState(aeronaveSetada);
    }
    public void addSubject(){
        dados.attach(new TabelaObserver(this.dados));
        dados.attach(new GraficoObserver(this.dados));
    }
}
