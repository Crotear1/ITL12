import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Konto> konten = new ArrayList<Konto>();

        while (true) {
            System.out.println("1. Konto anlegen");
            System.out.println("2. Konto auflösen");
            System.out.println("3. Einzahlen");
            System.out.println("4. Abheben");
            System.out.println("5. Kontoauszug ausgeben");
            System.out.println("6. Überweisen");
            System.out.println("7. Beenden");

            int auswahl = scanner.nextInt();

            switch (auswahl) {
                case 1:
                    System.out.println("Kontoinhaber: ");
                    String kontoinhaber = scanner.next();
                    System.out.println("Bankleitzahl: ");
                    String bankleitzahl = scanner.next();
                    System.out.println("Kontonummer: ");
                    String kontonummer = scanner.next();
                    System.out.println("Überziehungsrahmen: ");
                    double ueberziehungsrahmen = scanner.nextDouble();
                    System.out.println("Kontoführungsgebühren: ");
                    double kontofuehrungsgebuehren = scanner.nextDouble();
                    System.out.println("Kontostand: ");
                    double kontostand = scanner.nextDouble();
                    System.out.println("Kontoart (Girokonto, Sparkonto, Kreditkonto): ");
                    String kontoart = scanner.next();

                    switch (kontoart) {
                        case "Girokonto":
                            konten.add(new Girokonto(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen,
                                    kontofuehrungsgebuehren, kontostand));
                            break;
                        case "Sparkonto":
                            konten.add(new Sparkonto(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen,
                                    kontofuehrungsgebuehren, kontostand));
                            break;
                        case "Kreditkonto":
                            konten.add(new Kreditkonto(kontoinhaber, bankleitzahl, kontonummer, ueberziehungsrahmen,
                                    kontofuehrungsgebuehren, kontostand));
                            break;
                        default:
                            System.out.println("Fehler: Ungültige Kontoart.");
                            break;
                    }
                    break;
                case 2:
                    /**
                    System.out.println("Kontonummer: ");
                    String kontonummer2 = scanner.next();
                    boolean kontoGefunden = false;
                    for (Konto konto : konten) {
                        if (konto.getKontonummer().equals(kontonummer2)) {
                            konten.remove(konto);
                            kontoGefunden = true;
                            System.out.println("Konto erfolgreich aufgelöst.");
                            break;
                        }
                    }
                    if (!kontoGefunden) {
                        System.out.println("Fehler: Konto nicht gefunden.");
                    }
                    break;
                        **/
                case 3:
                    /**
                    System.out.println("Kontonummer: ");
                    String kontonummer3 = scanner.next();
                    System.out.println("Betrag: ");
                    double betrag3 = scanner.nextDouble();
                    kontoGefunden = false;
                    for (Konto konto : konten) {
                        if (konto.getKontonummer().equals(kontonummer3)) {
                            konto.einzahlen(betrag3);
                            kontoGefunden = true;
                            break;
                        }
                    }
                    if (!kontoGefunden) {
                        System.out.println("Fehler: Konto nicht gefunden.");
                    }
                    break;
                     **/
                case 4:
                    /**
                    System.out.println("Kontonummer: ");
                    String kontonummer4 = scanner.next();
                    System.out.println("Betrag: ");
                    double betrag4 = scanner.nextDouble();
                    kontoGefunden = false;
                    for (Konto konto : konten) {
                        if (konto.getKontonummer().equals(kontonummer4)) {
                            konto.abheben(betrag4);
                            kontoGefunden = true;
                            break;
                        }
                    }
                    if (!kontoGefunden) {
                        System.out.println("Fehler: Konto nicht gefunden.");
                    }
                    break;
                        **/
                case 5:
                    /**
                    System.out.println("Kontonummer: ");
                    String kontonummer5 = scanner.next();
                    kontoGefunden = false;
                    for (Konto konto : konten) {
                        if (konto.getKontonummer().equals(kontonummer5)) {
                            konto.kontoauszug();
                            kontoGefunden = true;
                            break;
                        }
                    }
                    if (!kontoGefunden) {
                        System.out.println("Fehler: Konto nicht gefunden.");
                    }
                    break;
                        **/
                case 6:
                    /**
                    System.out.println("Kontonummer des Absenders: ");
                    String kontonummer6a = scanner.next();
                    System.out.println("Kontonummer des Empfängers: ");
                    String kontonummer6b = scanner.next();
                    System.out.println("Betrag: ");
                    double betrag6 = scanner.nextDouble();
                    boolean kontoGefundenA = false;
                    boolean kontoGefundenB = false;
                    Konto kontoA = null;
                    Konto kontoB = null;
                    for (Konto konto : konten) {
                        if (konto.getKontonummer().equals(kontonummer6a)) {
                            kontoA = konto;
                            kontoGefundenA = true;
                        }
                        if (konto.getKontonummer().equals(kontonummer6b)) {
                            kontoB = konto;
                            kontoGefundenB = true;
                        }
                        if (kontoGefundenA && kontoGefundenB) {
                            break;
                        }
                    }
                    if (!kontoGefundenA) {
                        System.out.println("Fehler: Absender-Konto nicht gefunden.");
                    } else if (!kontoGefundenB) {
                        System.out.println("Fehler: Empfänger-Konto nicht gefunden.");
                    } else {
                        kontoA.abheben(betrag6);
                        kontoB.einzahlen(betrag6);
                        System.out.println("Überweisung erfolgreich.");
                    }
                    break;
                        **/
                case 7:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Fehler: Ungültige Auswahl.");
                    break;
            }
        }
    }
}
