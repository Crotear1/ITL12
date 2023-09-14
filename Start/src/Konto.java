import java.util.ArrayList;

public class Konto {
    private String accountHolder;
    private int bankCode;
    private int accountNumber;

    private int accountMaintenanceFees;
    private int accountBalance;
    private int accountBalanceInCents;

    private ArrayList<Konto> accounts;

    // Methode
    private ArrayList<Konto> konten;

        konten = new ArrayList<Konto>();

    public void addKonto(Konto konto) {
        konten.add(konto);
    }

    public void removeKonto(Konto konto) {
        konten.remove(konto);
    }
    public void deposit(double amount) {
        this.accountBalance += amount;
    }

    public void withdraw(double amount) {
        if (this.accountBalance - amount >= -ueberziehungsrahmen) {
            this.accountBalance -= amount;
        } else {
            System.out.println("Error: Not enough money on your account");
        }
    }

    public void accountState() {
        System.out.println("Kontostand: " + this.accountBalance);
    }

    public void kontoAnlegen() {
        // Code to create a new account
    }

    public void kontoAufloesen() {
        // Code to close an account
    }

    void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    // set random account bank code
    void setBankCode() {
        this.bankCode = (int) (Math.random() * 100000);
    }
    // set random account number
    void setAccountNumber() {
        this.accountNumber = (int) (Math.random() * 100000);
    }
}
