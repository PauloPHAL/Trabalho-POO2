package Persistencia;

import Dominio.Aeronave;
import java.util.List;

public class AeronaveDAO extends GenericDAO{
    // padrao Singleton
    private static AeronaveDAO gerenciador; 
    private AeronaveDAO(){
    }
    public static AeronaveDAO getConexão(){
        if(gerenciador == null){
            gerenciador = new AeronaveDAO();
        }
        return gerenciador;
    }
    private List<Aeronave> pesquisarAeronave(String pesq, int tipo){
        return null;
    } 
    //----------------------------------------------------------------
    public List<Aeronave> listar(){
        return pesquisarAeronave("",-1);
    }       
    public List<Aeronave> pesquisarModelo(String pesq){
        return pesquisarAeronave(pesq,0);
    }   
    public List<Aeronave> pesquisarMes(String pesq){
        return pesquisarAeronave(pesq,1);
    }   
    public List<Aeronave> pesquisarFabr(String pesq){
        return pesquisarAeronave(pesq,2);
    }
}
