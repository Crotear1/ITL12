class Girokonto extends Konto {
    private Konto konto;

    private float überziehungsrahmen = 400;
    public Girokonto(String kontoinhaber, double kontofuehrungsgebuehren, double kontostand,String kontoart,  Konto konto) {
        super(kontoinhaber, kontofuehrungsgebuehren, kontostand, "Girokonto");
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
