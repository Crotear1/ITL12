import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tier tier = new Hund("Aika", 5);
        tier.gibLaut(); // Output: Wuff

        tier = new Katze("Felix", 3);
        tier.gibLaut(); // Output: Miau

        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welches Tier soll einen Laut von sich geben?");
        System.out.println("Auswahl zwischen Katze, Hund, Kuh, Fisch und Schwein.");
        String input = scanner.nextLine();

        switch(input.toLowerCase()) {
            case "katze":
                tier = new Katze("Felix", 2);
                break;
            case "hund":
                tier = new Hund("Kain", 4);
                break;
            case "kuh":
                tier = new Kuh("Berta", 6);
                break;
            case "fisch":
                tier = new Fisch("Findet Nemo", 1);
                break;
            case "schwein":
                tier = new Schwein("Traude", 3);
                break;
            default:
                System.out.println("Das Tier ist nicht bekannt.");
                return;
        }

        tier.gibLaut();
    }
}