package domain.observers;

import domain.model.Rekening;

import java.util.Observable;
import java.util.Observer;

public class AuditorObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Rekening rekening = (Rekening) arg;
        System.out.println("Nieuwe rekening geopend op datum + " + rekening.getAanmaakDatum().toString() + " met nummer " + rekening.getNr() + " en saldo " + rekening.getSaldo());
    }
}
