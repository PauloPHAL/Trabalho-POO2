package Dominio.Observer;

import Dominio.*;
import java.util.ArrayList;
import java.util.List;

public class DadosSubject {
    protected List<AeronavesObservers> dadosObservados;
    protected Aeronave dadosAeronave;

    public DadosSubject() {
        this.dadosObservados = new ArrayList<>();
    }
    
    public void attach(AeronavesObservers observer) {
        dadosObservados.add(observer);
    }
    public void detach(int indice) {
        dadosObservados.remove(indice);
    }
    public void setState(Aeronave dados) {
        this.dadosAeronave = dados;
        notifyObservers();
    }
    public void notifyObservers() {
        this.dadosObservados.forEach(observer -> {
            observer.update();
        });
    }
    public Aeronave getState() {
        return this.dadosAeronave;
    }
    
}
