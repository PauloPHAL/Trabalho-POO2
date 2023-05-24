package Dominio.Observer;

public class TabelaObserver extends AeronavesObservers{

    public TabelaObserver(DadosSubject dados) {
        super(dados);
    }

    @Override
    public void update() {
        System.out.println(dados.dadosAeronave.getNome());
        System.out.println(dados.dadosAeronave.getNumeroSerie());
    }
    
}
