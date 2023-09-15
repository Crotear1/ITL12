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
            System.out.println("5. Konten ausgeben");
            System.out.println("6. Überweisen");
            System.out.println("7. Beenden");

            int auswahl = scanner.nextInt();

            switch (auswahl) {
                case 1:
                    System.out.print("Kontoinhaber: ");
                    scanner.nextLine();
                    String kontoinhaber = scanner.nextLine();
                    System.out.print("Bankleitzahl: ");
                    String bankleitzahl = scanner.nextLine();

                    System.out.print("Kontonummer: ");
                    String kontonummer = scanner.nextLine();

                    System.out.print("Kontoführungsgebühren: ");
                    double kontofuehrungsgebuehren = scanner.nextDouble();

                    System.out.print("Kontostand: ");
                    double kontostand = scanner.nextDouble();

                    System.out.print("Kontoart: ");
                    String kontoart = scanner.next();
                    boolean breakLoop = false;
                    switch (kontoart.toLowerCase()) {
                        case "girokonto":
                            Konto konto = new Konto(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, kontoart); // Create a new Konto object
                            konten.add(konto);
                            konto.setGirokontos(new Girokonto(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, "Girokonto", konto));
                            break;
                        case "kreditkonto":
                            Konto kreditkonto = new Konto(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, kontoart); // Create a new Konto object
                            konten.add(kreditkonto);
                            kreditkonto.setKreditkontos(new Kreditkonto(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, "Kreditkonto", kreditkonto));
                            break;
                        case "sparkonto":
                            Konto sparkonto = new Konto(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, kontoart); // Create a new Konto object
                            konten.add(sparkonto);
                            sparkonto.setSparkontos(new Sparkonto(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, "Sparkonto", sparkonto));
                            break;
                        default:
                            System.out.println("Konto konnte nicht angelegt werden. Bitte geben Sie eine gültige Kontoart ein.");
                            breakLoop = true;
                            break;
                    }
                    if (breakLoop) {
                        break;
                    }

                    System.out.println("Konto erfolgreich angelegt.");
                    // system print für methode kontoauszug
                    break;
                case 2:
                    System.out.println("Kontonummer: ");
                    int kontonummer10 = Integer.parseInt(scanner.next());
                    float ueberziehungsrahmen = 0;
                    boolean breakLoop6 = false;
                    boolean kontoGefunden10 = false;
                    for (Konto konto : konten) {
                        if (konto.getKontonummer().equals(String.valueOf(kontonummer10))) {
                            switch (konto.getKontoTyp().toLowerCase()) {
                                case "girokonto":
                                    konto.deleteGirokontoByKontonummer(kontonummer10);
                                    break;
                                case "kreditkonto":
                                    konto.deleteKreditkontoByKontonummer(kontonummer10);
                                    break;
                                case "sparkonto":
                                    konto.deleteSparkontoByKontonummer(kontonummer10);
                                    break;
                                default:
                                    System.out.println("Konto konnte nicht angelegt werden. Bitte geben Sie eine gültige Kontoart ein.");
                                    breakLoop6 = true;
                                    break;
                            }
                            if (breakLoop6) {
                                break;
                            }
                            kontoGefunden10 = true;
                            konten.remove(konto);
                            System.out.println("Konto erfolgreich gelöscht.");
                            break;
                        }
                    }
                    if (!kontoGefunden10) {
                        System.out.println("Fehler: Konto nicht gefunden.");
                    }
                    break;
                case 3:
                    System.out.println("Kontonummer: ");
                    String kontonummer3 = scanner.next();
                    System.out.println("Betrag: ");
                    double betrag3 = scanner.nextDouble();
                    boolean kontoGefunden = false;
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
                case 4:
                    System.out.println("Kontonummer: ");
                    int kontonummer4 = Integer.parseInt(scanner.next());
                    System.out.println("Betrag: ");
                    double betrag4 = scanner.nextDouble();
                    float ueberziehungsrahmen2 = 0;
                    kontoGefunden = false;
                    boolean breakLoop2 = false;
                    for (Konto konto : konten) {
                        if (konto.getKontonummer().equals(String.valueOf(kontonummer4))) {
                            switch (konto.getKontoTyp().toLowerCase()) {
                                case "girokonto":
                                    ueberziehungsrahmen2 = konto.getGirokontoByKontonummer(kontonummer4);
                                    if (ueberziehungsrahmen2 == 0) {
                                        System.out.println("Fehler: Konto nicht gefunden.");
                                        breakLoop2 = true;
                                        break;
                                    }
                                    break;
                                case "kreditkonto":
                                    ueberziehungsrahmen2 = konto.getKreditkontoByKontonummer(kontonummer4);
                                    if (ueberziehungsrahmen2 == 0) {
                                        System.out.println("Fehler: Konto nicht gefunden.");
                                        breakLoop2 = true;
                                        break;
                                    }
                                    break;
                                case "sparkonto":
                                    break;
                                default:
                                    System.out.println("Konto konnte nicht angelegt werden. Bitte geben Sie eine gültige Kontoart ein.");
                                    breakLoop2 = true;
                                    break;
                            }
                            if (breakLoop2) {
                                break;
                            }
                            konto.abheben(betrag4, ueberziehungsrahmen2);
                            kontoGefunden = true;
                            break;
                        }
                    }
                    if (!kontoGefunden) {
                        System.out.println("Fehler: Konto nicht gefunden.");
                    }
                    break;
                case 6:
                    System.out.println("Kontonummer des Absenders: ");
                    int kontonummer6a = Integer.parseInt(scanner.next());
                    System.out.println("Kontonummer des Empfängers: ");
                    int kontonummer6b = Integer.parseInt(scanner.next());
                    System.out.println("Betrag: ");
                    double betrag6 = scanner.nextDouble();
                    float ueberziehungsrahmen3 = 0;
                    kontoGefunden = false;
                    boolean breakLoop3 = false;
                    Konto kontoReceiver = null;
                    Konto kontoSender = null;
                    for (Konto konto : konten) {
                        if (konto.getKontonummer().equals(String.valueOf(kontonummer6a))) {
                            kontoSender = (Konto) konto;
                            switch (konto.getKontoTyp().toLowerCase()) {
                                case "girokonto":
                                    ueberziehungsrahmen3 = konto.getGirokontoByKontonummer(kontonummer6a);
                                    if (ueberziehungsrahmen3 == 0) {
                                        System.out.println("Fehler: Konto nicht gefunden.");
                                        breakLoop3 = true;
                                        break;
                                    }
                                    break;
                                case "kreditkonto":
                                    ueberziehungsrahmen3 = konto.getKreditkontoByKontonummer(kontonummer6a);
                                    if (ueberziehungsrahmen3 == 0) {
                                        System.out.println("Fehler: Konto nicht gefunden.");
                                        breakLoop3 = true;
                                        break;
                                    }
                                    break;
                                case "sparkonto":
                                    break;
                                default:
                                    System.out.println("Konto konnte nicht angelegt werden. Bitte geben Sie eine gültige Kontoart ein.");
                                    breakLoop3 = true;
                                    break;
                            }
                            if (breakLoop3) {
                                break;
                            }
                            kontoGefunden = true;
                        }
                        else if (konto.getKontonummer().equals(String.valueOf(kontonummer6b))) {
                            kontoReceiver = (Konto) konto;
                        }
                    }
                    if (!kontoGefunden) {
                        System.out.println("Fehler: Konto nicht gefunden.");
                    } else if (kontoSender != null && kontoReceiver != null) {
                        kontoSender.abheben(betrag6, ueberziehungsrahmen3);
                        kontoReceiver.einzahlen(betrag6);
                    }
                    break;
                case 5:
                    System.out.println("Welche Kontoart möchten Sie abrufen? 1. Girokonto 2. Kreditkonto 3. Sparkonto 4. Alle");
                    int kontoart7 = scanner.nextInt();
                    switch (kontoart7) {
                        case 1:
                            for (int i = 0; i < konten.size(); i++) {
                                Konto x = (Konto) konten.get(i);
                                x.getGirokontos();
                            }
                            break;
                        case 2:
                            for (int i = 0; i < konten.size(); i++) {
                                Konto x = (Konto) konten.get(i);
                                x.getKreditkontos();
                            }
                            break;
                        case 3:
                            for (int i = 0; i < konten.size(); i++) {
                                Konto x = (Konto) konten.get(i);
                                x.getSparkontos();
                            }
                            break;
                        case 4:
                            for (int i = 0; i < konten.size(); i++) {
                                Konto x = (Konto) konten.get(i);
                                x.kontoauszug();
                            }
                            break;
                        default:
                            System.out.println("Fehler: Ungültige Auswahl.");
                            break;
                    }
                    break;
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