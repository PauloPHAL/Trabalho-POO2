package Dominio.Observer;

import Dominio.Locacao;

public class LocadaObserver extends DadosObservers{

    public LocadaObserver(DadosSubject dados) {
        super(dados);
    }

    @Override
    public boolean update() {
        
        
        Locacao locacao = super.dados.getState();
        boolean locada = locacao.isLocada();
        
        if(locada){
            return true;
        }else{
            return false;
        }
    }
    
}
