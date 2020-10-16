package launcher;

import domain.db.Bank;
import domain.model.Rekening;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.registerRekening(200);
        bank.registerRekening(300);
        bank.registerRekening(-100);
        System.out.println(bank.toString());
    }
}
