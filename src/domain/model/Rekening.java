package domain.model;

import java.time.LocalDate;

public class Rekening {

    LocalDate aanmaakDatum;
    int nr;
    int saldo;

    public Rekening(int nr, int saldo){
        setAanmaakDatum();
        setNr(nr);
        setSaldo(saldo);
    }

    public LocalDate getAanmaakDatum() {
        return aanmaakDatum;
    }
    public void setAanmaakDatum(){
        aanmaakDatum = LocalDate.now();
    }

    public int getNr() {
        return nr;
    }
    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        if (saldo < 0) throw new IllegalArgumentException("Saldo mag niet negatief zijn");
        else this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Rekening {" +
                "aanmaakDatum=" + aanmaakDatum +
                ", nr=" + nr +
                ", saldo=" + saldo +
                '}';
    }
}
