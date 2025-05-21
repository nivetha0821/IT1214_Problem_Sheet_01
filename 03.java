class BankAccount{
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void withdraw(double amount)throws Exception{
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new Exception("Insufficient balance");
        }
    }
}

class Bank{
    BankAccount[] accounts = new BankAccount[5];
    int count = 0;

    public void addAccount(BankAccount acc){
        if (count < 5) {
            accounts[count] = acc;
            count++;
        } else {
            System.out.println("Cannot add more accounts.");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount){
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber){
                found = true;
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawal successful.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
               
            }
        }
        if (!found){
            System.out.println("Account not found.");
        }
    }

    public void displayAccounts(){
        for (int i = 0; i < count; i++){
            System.out.println("AccountNo: " + accounts[i].getAccountNumber() +", Holder: " + accounts[i].getAccountHolder() +", Balance: " + accounts[i].getBalance());
        }
    }
}

class Main{
    public static void main(String[] args){
        Bank b1 = new Bank();
        b1.addAccount(new BankAccount(1001, "Alice", 5000.0));
        b1.addAccount(new BankAccount(1002, "Bob", 3000.0));
        b1.withdrawFromAccount(1001, 6000.0); 
        b1.withdrawFromAccount(1002, 1000.0); 
        b1.displayAccounts();
    }
}


