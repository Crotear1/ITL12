import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        boolean action = true;

        while (action) {
            System.out.println("1. Create new account");
            System.out.println("2. Show account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Deactivate account");
            System.out.println("6. Exit");
            System.out.print("Choose an action: ");
            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    System.out.println("Create new account");
                    Konto konto = new Konto();
                    System.out.print("KontoInhaber: ");
                    konto.setAccountHolder(scanner.nextLine());
                    System.out.print("Bankleitzahl: ");
                    konto.setBankCode();
                    System.out.print("Kontonummer: ");
                    konto.setAccountNumber();
                    bank.kontoAnlegen(konto);
                    break;
                case 2:
                    System.out.println("Show account");
                    System.out.print("Kontonummer: ");
                    String kontonummer = scanner.nextLine();
                    Konto kontoToShow = bank.getKontoByAccountNumber(kontonummer);
                    if (kontoToShow != null) {
                        System.out.println(kontoToShow.toString());
                    } else {
                        System.out.println("Konto not found");
                    }
                    break;
                case 3:
                    System.out.println("Deposit");
                    System.out.print("Kontonummer: ");
                    kontonummer = scanner.nextLine();
                    konto = bank.getKontoByAccountNumber(kontonummer);
                    if (konto != null) {
                        System.out.print("Betrag: ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        konto.deposit(amount);
                        System.out.println("Deposit successful");
                    } else {
                        System.out.println("Konto not found");
                    }
                    break;
                case 4:
                    System.out.println("Withdraw");
                    System.out.print("Kontonummer: ");
                    kontonummer = scanner.nextLine();
                    konto = bank.getKontoByAccountNumber(kontonummer);
                    if (konto != null) {
                        System.out.print("Betrag: ");
                        double betrag = Double.parseDouble(scanner.nextLine());
                        if (konto.abheben(betrag)) {
                            System.out.println("Withdrawal successful");
                        } else {
                            System.out.println("Insufficient funds");
                        }
                    } else {
                        System.out.println("Konto not found");
                    }
                    break;
                case 5:
                    System.out.println("Deactivate account");
                    System.out.print("Kontonummer: ");
                    kontonummer = scanner.nextLine();
                    konto = bank.getKontoByAccountNumber(kontonummer);
                    if (konto != null) {
                        konto.deactivateAccount();
                        System.out.println("Account deactivated");
                    } else {
                        System.out.println("Konto not found");
                    }
                    break;
                case 6:
                    System.out.println("Exit");
                    action = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
}