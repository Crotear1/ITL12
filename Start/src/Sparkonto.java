class Sparkonto extends Konto {
    private Konto konto;
    public Sparkonto(String kontoinhaber, String bankleitzahl, String kontonummer,
                     double kontofuehrungsgebuehren, double kontostand, String kontoart, Konto konto) {
        super(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, "Sparkonto");
        this.konto = (Konto) konto;
    }

    public void kontoauszug() {
        this.konto.kontoauszug();
    }
}
