package Dominio.Observer;

import Dominio.Aeronave;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
    Aeronave getState();
}
