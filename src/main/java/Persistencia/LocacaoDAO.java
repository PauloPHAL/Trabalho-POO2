package Persistencia;

import Dominio.Locacao;
import java.util.List;

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
        return null;
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
