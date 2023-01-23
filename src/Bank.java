public class Bank {
    private String name;
    private String headOfficeLocation;
    private Account[] accounts = new Account[4];
    private int hesapsayisi;
    public static final double usdRateInformation = 18.5255;

    public Bank(String name, String headOfficeLocation) {
        this.name = name;
        this.headOfficeLocation = headOfficeLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadOfficeLocation() {
        return headOfficeLocation;
    }

    public void setHeadOfficeLocation(String newHeadOfficeLocation) {
        this.headOfficeLocation = newHeadOfficeLocation;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Account[] getAccounts() {
        return accounts;
    }


    public void accountAdd(Account account) {

        this.accounts[hesapsayisi++] = account;
    }

    public boolean moneyTransfer(String senderAccountNumber, String buyerAccountNumber,double amount) {
        double senderBalance = 0.0;
        boolean durum = false;
        for (int i = 0; i < hesapsayisi; i++) {
            if (accounts[i].getAccountNumber().equals(senderAccountNumber) && accounts[i].getBalance() >= amount) {
                senderBalance = amount;
                accounts[i].setBalance(accounts[i].getBalance()-amount);
                durum = true;
            }
            if (accounts[i].getAccountNumber().equals(buyerAccountNumber)) {
                accounts[i].setBalance(accounts[i].getBalance() + senderBalance);
            }
        }
        return durum;
    }

    public static double usdTLCurrencyConvert(double usd) {
            return  usdRateInformation * usd;


    }

    public void showInfo() {
        System.out.println("\n**************Banka Bilgileri****************\n");
        System.out.println("Banka Adı : " + this.name);
        System.out.println("Banka merkez Ofisi : " + this.headOfficeLocation);
        System.out.println("Bankada Bulunan Hesap Sayısı : " + this.hesapsayisi);
        System.out.println("\n***********Banka hesap sahibi müşteriler**************\n");
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                accounts[i].showInfo();
            }
            System.out.println("^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-");
        }
    }
}
