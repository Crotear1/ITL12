class Sparkonto extends Konto {
    private Konto konto;
    public Sparkonto(String kontoinhaber,
                     double kontofuehrungsgebuehren, double kontostand, String kontoart, Konto konto) {
        super(kontoinhaber, kontofuehrungsgebuehren, kontostand, "Sparkonto");
        this.konto = (Konto) konto;
    }

    public String kontoauszug() {
        this.konto.kontoauszug();
        return null;
    }
}
