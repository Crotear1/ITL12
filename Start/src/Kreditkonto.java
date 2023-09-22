class Kreditkonto extends Konto {
    private Konto konto;

    private float überziehungsrahmen = 600;

    public Kreditkonto(String kontoinhaber, double kontofuehrungsgebuehren, double kontostand, String kontoart, Konto konto) {
        super(kontoinhaber, kontofuehrungsgebuehren, kontostand, "Kreditkonto");
        this.konto = (Konto) konto;
    }

    public float getÜberziehungsrahmen() {
        return überziehungsrahmen;
    }

    public String kontoauszug() {
        this.konto.kontoauszug();
        System.out.println("Überziehungsrahmen: " + this.überziehungsrahmen);
        return null;
    }
}
