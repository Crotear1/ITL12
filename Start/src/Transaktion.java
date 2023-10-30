import java.util.Date;

public class Transaktion {
    private int transaktionsID;
    private int kontonummer;
    private Date datum;
    private String art;
    private double betrag;
    private boolean plusMinus;

    // Konstruktoren, Getter, Setter und Methoden für Transaktion verwalten

    public Transaktion(int transaktionsID, int kontonummer, Date datum, String art, double betrag, boolean plusMinus) {
        this.transaktionsID = transaktionsID;
        this.kontonummer = kontonummer;
        this.datum = datum;
        this.art = art;
        this.betrag = betrag;
        this.plusMinus = plusMinus;
    }

    public int getTransaktionsID() {
        return transaktionsID;
    }

    public void setTransaktionsID(int transaktionsID) {
        this.transaktionsID = transaktionsID;
    }

    public int getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public boolean isPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(boolean plusMinus) {
        this.plusMinus = plusMinus;
    }

    public void transaktionVerwalten() {
        // TODO implement here
        
    }
}
