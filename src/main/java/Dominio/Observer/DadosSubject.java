package Dominio.Observer;

import Dominio.*;
import java.util.ArrayList;
import java.util.List;

public class DadosSubject {
    protected List<DadosObservers> dadosObservados;
    protected Locacao dadosLocacao;

    public DadosSubject() {
        this.dadosObservados = new ArrayList<>();
    }
    
    public void attach(DadosObservers observer) {
        dadosObservados.add(observer);
    }
    public void detach(int indice) {
        dadosObservados.remove(indice);
    }
    public void setState(Locacao dados) {
        this.dadosLocacao = dados;
        notifyObservers();
    }
    public void notifyObservers() {
        this.dadosObservados.forEach(observer -> {
            observer.update();
        });
    }
    public Locacao getState() {
        return this.dadosLocacao;
    }
    
}
