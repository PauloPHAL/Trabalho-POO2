package Dominio.Observer;

public class GraficoObserver extends AeronavesObservers{
    
    public GraficoObserver(DadosSubject dados) {
        super(dados);
    }

    @Override
    public void update() {
        System.out.println("Essa tbm!!!");
    }
}
