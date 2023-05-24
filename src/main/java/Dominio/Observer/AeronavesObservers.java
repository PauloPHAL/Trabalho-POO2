package Dominio.Observer;

public abstract class AeronavesObservers {
    protected DadosSubject dados;

    public AeronavesObservers(DadosSubject dados) {
        this.dados = dados;
    }   
    public abstract void update();
}
