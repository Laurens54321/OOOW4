package domain.observers;

import domain.model.Rekening;

public class RekeningLogger implements CustomObserver {

    private int count = 0;

    public RekeningLogger(){ }

    @Override
    public void update(Rekening r) {
        count++;
        System.out.println("Aantal rekeningen: " + count);
    }

    public int getCount(){
        return count;
    }
}
