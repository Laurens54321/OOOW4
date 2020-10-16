package domain.observers;

import domain.model.Rekening;

import java.util.Observable;
import java.util.Observer;

public class RekeningLoggerObserver implements Observer {
    private int count = 0;

    @Override
    public void update(Observable o, Object arg) {
        count++;
        System.out.println("Aantal rekeningen: " + count);
    }

    public int getCount(){
        return count;
    }

}
