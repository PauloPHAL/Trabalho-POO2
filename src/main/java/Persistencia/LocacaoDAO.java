package Persistencia;

import Dominio.Locacao;
import java.util.List;

public class LocacaoDAO {
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
    //CRUD:
    //----------------------------------------------------------------
    public void inserirLocacao(Locacao local){      
        
    }
    public void excluirLocacao(Locacao local){
        
    }
    private List<Locacao> pesquisarLocacao(String pesq, int tipo){
        return null;
    }
    public void alterarLocacao(Locacao local){
        
    }   
    //----------------------------------------------------------------
    public List<Locacao> listar(){
        return pesquisarLocacao("",-1);
    }
    public List<Locacao> pesquisarCliente(String pesq){
        return pesquisarLocacao(pesq,0);
    }
    public List<Locacao> pesquisarAeronave(String pesq){
        return pesquisarLocacao(pesq,1);
    }
}
