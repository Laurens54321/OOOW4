package domain.observers;

import domain.model.Rekening;

public class Auditor implements CustomObserver {

    @Override
    public void update(Rekening rekening) {
        System.out.println("Nieuwe rekening geopend op datum + " + rekening.getAanmaakDatum().toString() + " met nummer " + rekening.getNr() + " en saldo " + rekening.getSaldo());
    }

    /*
    TODO
    ik weet niet hoe ik dit defitg moet implementeren
    is er een manier om RekeningLogger zijn counter te returnen
    zonder die ook in de interface te zetten?
     */

    @Override
    public int getCount() {
        return 0;
    }
}
