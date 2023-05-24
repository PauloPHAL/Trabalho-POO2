package Dominio.Observer;

public abstract class DadosObservers {
    protected DadosSubject dados;

    public DadosObservers(DadosSubject dados) {
        this.dados = dados;
    }
    
    public abstract boolean update();
}
