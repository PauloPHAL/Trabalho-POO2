package Dominio.Observer;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TabelaObserver extends AeronavesObservers{

    public TabelaObserver(DadosSubject dados) {
        super(dados);
    }

    @Override
    public void update() {
        try {
            System.out.println("Aeronave: "+dados.dadosAeronave.getIdAeronave());
            System.out.println(dados.dadosAeronave.getNome());
            System.out.println(dados.dadosAeronave.getNumeroSerie());
            System.out.println();
            System.out.println("Modelo: "+dados.dadosAeronave.getModelo().getIdModelo());
            System.out.println(dados.dadosAeronave.getModelo().getNome());
            System.out.println(dados.dadosAeronave.getModelo().getTipo());
            System.out.println();
            System.out.println("Fabricante: "+dados.dadosAeronave.getModelo().getFabricante().getIdFabricante());
            System.out.println(dados.dadosAeronave.getModelo().getFabricante().getNome());
            System.out.println(dados.dadosAeronave.getModelo().getFabricante().getDataFundacaoFormatada());
        } catch (ParseException ex) {
            Logger.getLogger(TabelaObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
