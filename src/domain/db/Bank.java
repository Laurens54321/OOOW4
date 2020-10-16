package domain.db;

import domain.model.Rekening;
import domain.observers.Auditor;
import domain.observers.CustomObserver;
import domain.observers.RekeningLogger;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Rekening> rekeningen;



    CustomObserver auditor;
    CustomObserver rekeningLogger;
    private ArrayList<CustomObserver> registerRekeningCustomObservers;

    public Bank(){
        rekeningen = new ArrayList<>();

        auditor = new Auditor();
        rekeningLogger = new RekeningLogger();
        registerRekeningCustomObservers = new ArrayList<>();
        registerRekeningCustomObservers.add(auditor);
        registerRekeningCustomObservers.add(rekeningLogger);
    }

    public void registerRekening(int saldo){
        Rekening rekening = null;
        try{
            rekening = new Rekening(rekeningLogger.getCount(), saldo);
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
            updateRegisterRekeningObservers(rekening);
            System.out.println("Rekening was added to the bank");
        }
    }




    private Rekening getRekening(int nr){
        for (Rekening r: rekeningen) {
            if (r.getNr() == nr) return r;
        }
        return null;
    }

    private void updateRegisterRekeningObservers(Rekening r){
        for (CustomObserver o: registerRekeningCustomObservers) {
            o.update(r);
        }
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
