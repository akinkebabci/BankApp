public class Account {
    private String accountNumber;
    private String accountType;
    private double balance;
    Customer customer;

    public Account(String accountNumber, String accountType, double balance, Customer customer) {

        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public void depositMoney(double amount) {
        this.balance += amount;
        System.out.println("Para Yatırıldı");
    }

    public boolean withdrawMoney(double amount) {
        if (this.balance < amount) {
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }

    public void showInfo() {
        System.out.println("Hesap Numarası : " + this.accountNumber);
        System.out.println("Hesap Tipi : " + this.accountType);
        System.out.println("Hesap Bakiyesi : " + this.balance);
        customer.showInfo();
    }
}
