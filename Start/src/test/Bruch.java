package test;

import java.util.ArrayList;

public class Bruch {
    private int zaehler;
    private int nenner;

    public Bruch(int zaehler, int nenner) {
        if (nenner == 0) {
            throw new IllegalArgumentException("Der Nenner darf nicht null sein.");
        }
        this.zaehler = zaehler;
        this.nenner = nenner;
        kuerzen();
    }
    public ArrayList addiere(Bruch bruch) {
        ArrayList arrayList = new ArrayList();
        int neuerNenner = this.nenner * bruch.nenner;
        int neuerZaehler = this.zaehler * bruch.nenner + bruch.zaehler * this.nenner;
        this.zaehler = neuerZaehler;
        this.nenner = neuerNenner;
        kuerzen();
        arrayList.add(this.zaehler);
        arrayList.add(this.nenner);
        return arrayList;
    }

    public ArrayList subtrahiere(Bruch bruch) {
        ArrayList arrayList = new ArrayList();
        int neuerNenner = this.nenner * bruch.nenner;
        int neuerZaehler = this.zaehler * bruch.nenner - bruch.zaehler * this.nenner;
        this.zaehler = neuerZaehler;
        this.nenner = neuerNenner;
        kuerzen();
        arrayList.add(this.zaehler);
        arrayList.add(this.nenner);
        return arrayList;
    }

    public ArrayList multipliziere(Bruch bruch) {
        ArrayList arrayList = new ArrayList();
        this.zaehler *= bruch.zaehler;
        this.nenner *= bruch.nenner;
        kuerzen();
        arrayList.add(this.zaehler);
        arrayList.add(this.nenner);
        return arrayList;
    }

    public ArrayList dividiere(Bruch bruch) {
        ArrayList arrayList = new ArrayList();
        if (bruch.zaehler == 0) {
            throw new IllegalArgumentException("Division durch Null ist nicht erlaubt.");
        }
        this.zaehler *= bruch.nenner;
        this.nenner *= bruch.zaehler;
        kuerzen();
        arrayList.add(this.zaehler);
        arrayList.add(this.nenner);
        return arrayList;
    }

    private int ggT(int a, int b) {
        if (b == 0) {
            return a;
        }
        return ggT(b, a % b);
    }

    private void kuerzen() {
        int teiler = ggT(this.zaehler, this.nenner);
        this.zaehler /= teiler;
        this.nenner /= teiler;
    }
}
