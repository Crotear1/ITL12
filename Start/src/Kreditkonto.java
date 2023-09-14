class Kreditkonto extends Konto {
    public Kreditkonto(String kontoinhaber, String bankleitzahl, String kontonummer, double ueberziehungsrahmen,
                       double kontofuehrungsgebuehren, double kontostand) {
        super(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen, kontofuehrungsgebuehren, kontostand,
                "Kreditkonto");
    }
}
