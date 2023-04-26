package Persistencia;

import Dominio.Cliente;
import java.util.List;

public class ClienteDAO {
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
    //CRUD:
    //----------------------------------------------------------------
    public void inserirCliente(Cliente cliente){      
        
    }
    public void excluirCliente(Cliente cliente){
        
    }
    private List<Cliente> pesquisarCliente(String pesq, int tipo){
        return null;
    }
    public void alterarCliente(Cliente cliente){
        
    }   
    //----------------------------------------------------------------
    public List<Cliente> listar(){
        return pesquisarCliente("",-1);
    }       
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
