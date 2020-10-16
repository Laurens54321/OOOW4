package domain.observers;

import domain.model.Rekening;

import java.time.LocalDate;

public interface CustomObserver {
    public void update(Rekening rekening);

    /*
    TODO
    ik weet niet hoe ik dit defitg moet implementeren
    is er een manier om RekeningLogger zijn counter te returnen
    zonder die ook in de interface te zetten?
     */

    public int getCount();
}
