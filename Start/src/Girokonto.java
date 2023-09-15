class Girokonto extends Konto {
    private Konto konto;

    private float überziehungsrahmen = 400;
    public Girokonto(String kontoinhaber, String bankleitzahl, String kontonummer, double kontofuehrungsgebuehren, double kontostand,String kontoart,  Konto konto) {
        super(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, "Girokonto");
        this.konto = (Konto) konto;
    }

    public float getÜberziehungsrahmen() {
        return überziehungsrahmen;
    }

    public void kontoauszug() {
        this.konto.kontoauszug();
        System.out.println("Überziehungsrahmen: " + this.überziehungsrahmen);
    }
}
