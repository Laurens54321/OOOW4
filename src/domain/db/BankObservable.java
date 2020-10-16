package domain.db;

import domain.model.Rekening;

import java.util.ArrayList;
import java.util.Observable;

public class BankObservable extends Observable {

    /*
        Implemented with java.util.Observer interface
        I'ts jank af
     */

    private ArrayList<Rekening> rekeningen;
    public int count = 0;

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    public void registerRekening(int saldo){
        Rekening rekening = null;
        try{
            rekening = new Rekening(count, saldo);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        if (rekening == null){
            System.out.println("Rekening could not be made");
            return;
        }

        if (getRekening(rekening.getNr()) == rekening){
            System.out.println("Rekening is already present in the bank");
        }
        else {
            rekeningen.add(rekening);
            notifyObservers(rekening);
            count++;
            System.out.println("Rekening was added to the bank");
        }
    }

    private Rekening getRekening(int nr){
        for (Rekening r: rekeningen) {
            if (r.getNr() == nr) return r;
        }
        return null;
    }

    @Override
    public String toString() {
        String s = "\nBankrekeningen: \n";
        for (Rekening r: rekeningen) {
            s += r.toString() + "\n";
        }
        return s;
    }
}
