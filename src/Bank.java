import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

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

    public int getHesapsayisi() {
        return hesapsayisi;
    }

    public void accountAdd(Account account) {
        try {
            this.accounts[hesapsayisi++] = account;
        }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Hesap 4'den fazla olamaz");
            hesapsayisi--;
        }

    }
    public void accountClose(Account account){
        for (int i = 0; i < hesapsayisi; i++) {
            if (accounts[i].equals(account)){
                accounts[i] = null;
                hesapsayisi--;
            }
        }
    }
    public  void  accountClose(String accountNumber){
        for (int i = 0; i < hesapsayisi; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)){
                accounts[i] = null;
            }
        }hesapsayisi--;

    }

    public boolean moneyTransfer(String senderAccountNumber, String buyerAccountNumber,double amount) {
        double senderBalance = 0.0;
        boolean status = false;
        for (int i = 0; i < hesapsayisi; i++) {
            if (accounts[i].getAccountNumber().equals(senderAccountNumber) && accounts[i].getBalance() >= amount && accounts[i].getAccountType().equals("USD")) {
                senderBalance = Bank.usdTLCurrencyConvert(amount);
                accounts[i].setBalance(accounts[i].getBalance()-amount);
                status = true;
            }
            else {
                senderBalance = amount;
                accounts[i].setBalance(accounts[i].getBalance()-amount);
                status = true;
            }
            if (accounts[i].getAccountNumber().equals(buyerAccountNumber)) {
                accounts[i].setBalance(accounts[i].getBalance() + senderBalance);
            }
        }
        return status;
    }

    public static double usdTLCurrencyConvert(double usd) {
            return  usdRateInformation * usd;


    }

    public void showInfo() {
        System.out.println("\n**************Banka Bilgileri****************\n");
        System.out.println("Banka Ad?? : " + this.name);
        System.out.println("Banka merkez Ofisi : " + this.headOfficeLocation);
        System.out.println("Bankada Bulunan Hesap Say??s?? : " + this.hesapsayisi);
        System.out.println("\n***********Banka hesap sahibi m????teriler**************\n");
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null){
                accounts[i].showInfo();
            }

            System.out.println("^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-");
        }
    }
}
