package Dominio.Observer;

import Dominio.*;
import java.util.ArrayList;
import java.util.List;

public class DadosSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private Aeronave aeronave;  
    
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    
    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
        notifyObservers();
    }
    
    @Override
    public Aeronave getState() {
        return aeronave;
    }
    
}
