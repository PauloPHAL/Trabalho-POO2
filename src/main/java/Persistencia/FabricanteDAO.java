package Persistencia;

import Dominio.Fabricante;
import java.util.List;

public class FabricanteDAO {
    //CRUD:
    //----------------------------------------------------------------
    public void inserirFabricante(Fabricante fabricante){      
        
    }
    public void excluirFabricante(Fabricante fabricante){
        
    }
    private List<Fabricante> pesquisarFabricante(String pesq, int tipo){
        return null;
    }
    public void alterarFabricante(Fabricante fabricante){
        
    }   
    //----------------------------------------------------------------
    public List<Fabricante> listar(){
        return pesquisarFabricante("",-1);
    }       
    public List<Fabricante> pesquisarNome(String pesq){
        return pesquisarFabricante(pesq,0);
    }
    public List<Fabricante> pesquisarPais(String pesq){
        return pesquisarFabricante(pesq,1);
    }   
}
