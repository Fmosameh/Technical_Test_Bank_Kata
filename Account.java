import java.util.ArrayList;
import java.util.List;

class Transaction {
    String date;
    int amount;
    int balance;

    public Transaction(String date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }
}

public class Account implements AccountService {
    private int balance = 0;
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(java.time.LocalDate.now().toString(), amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;
        transactions.add(new Transaction(java.time.LocalDate.now().toString(), -amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("Date       | Montant | Solde");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            System.out.printf("%s | %d | %d\n", t.date, t.amount, t.balance);
        }
    }
}
