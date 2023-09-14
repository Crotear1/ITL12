class Girokonto extends Konto {
    public Girokonto(String kontoinhaber, String bankleitzahl, String kontonummer, double ueberziehungsrahmen,
                     double kontofuehrungsgebuehren, double kontostand) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuehrungsgebuehren, kontostand,
                "Girokonto");
    }
}
