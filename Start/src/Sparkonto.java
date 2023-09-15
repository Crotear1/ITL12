class Sparkonto extends Konto {
    public Sparkonto(String kontoinhaber, String bankleitzahl, String kontonummer,
                     double kontofuehrungsgebuehren, double kontostand) {
        super(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, "Sparkonto");
    }
}
