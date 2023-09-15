class Kreditkonto extends Konto {
    private Konto konto;

    private float überziehungsrahmen = 600;

    public Kreditkonto(String kontoinhaber, String bankleitzahl, String kontonummer, double kontofuehrungsgebuehren, double kontostand, String kontoart, Konto konto) {
        super(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, "Kreditkonto");
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
