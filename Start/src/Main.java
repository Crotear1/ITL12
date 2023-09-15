import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

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
                    System.out.print("Kontoinhaber: ");
                    scanner.nextLine();
                    String kontoinhaber = scanner.nextLine();
                    System.out.print("Bankleitzahl: ");
                    String bankleitzahl = scanner.nextLine();

                    System.out.print("Kontonummer: ");
                    String kontonummer = scanner.nextLine();

                    System.out.print("Überziehungsrahmen: ");
                    double ueberziehungsrahmen = scanner.nextDouble();

                    System.out.print("Kontoführungsgebühren: ");
                    double kontofuehrungsgebuehren = scanner.nextDouble();

                    System.out.print("Kontostand: ");
                    double kontostand = scanner.nextDouble();

                    System.out.print("Kontoart: ");
                    String kontoart = scanner.next();

                    Konto konto = new Konto(kontoinhaber, bankleitzahl, kontonummer, kontofuehrungsgebuehren, kontostand, kontoart); // Create a new Konto object
                    // Add the new Konto object to the ArrayList
                    konten.add(konto);
                    for (int i = 0; i < konten.size(); i++) {
                        Konto x = (Konto) konten.get(i);
                        x.kontoauszug();
                    }
                    System.out.println("Konto erfolgreich angelegt.");
                    // system print für methode kontoauszug
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