import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrivateBank bank = new PrivateBank("AkBank", "Gaziantep/Şahinbey");
        Customer customer1 = new Customer("", "Kebabcı", "12345685143");
        Customer customer2 = new Customer("Mehmet", "Gazi", "32541798746");
        Customer customer3 = new Customer("Leyla", "Sapmaz", "32578965471");
        Customer customer4 = new Customer("Murat", "Sönmez", "25487632458");
        Account hesap1 = new Account("110", "TL", 152, customer1);
        Account hesap2 = new Account("111", "USD", 10, customer2);
        Account hesap3 = new Account("234", "TL", 10, customer3);
        Account hesap4 = new Account("458", "TL", 356.4, customer4);
        bank.accountAdd(hesap1);
        bank.accountAdd(hesap2);
        bank.accountAdd(hesap3);
        bank.accountAdd(hesap4);


        while (true) {
            System.out.println("\t\t-İşlem Seçiniz-\t\t");
            System.out.println("-> Para Trasnferi İçin (1)'e Basınız");
            System.out.println("-> Hesap Detayları için (2)'e Basınız");
            System.out.println("-> Usd/Tl Çevirimi çin (3)'e Basınız");
            System.out.println("-> Çıkma için (4)'e Basınız");
            System.out.print("Seçim Yapınız : ");
            Scanner scanner = new Scanner(System.in);
            String select = scanner.nextLine();

            if (select.equals("1")) {
                System.out.print("Lütfen Hesap Numaranızı Giriniz : ");
                String senderAccountNumber = scanner.nextLine();
                System.out.print("Lütfen Alıcı Hesap Numarasını Giriniz : ");
                String buyerAccountNumber = scanner.nextLine();
                System.out.print("Lütfen Göndermek İStediğiniz Miktarı Gİriniz : ");
                String amountInput = scanner.nextLine(); // **
                double amount = Double.parseDouble(amountInput);
                System.out.print("Onaylıyor musunuz ? (e/h) : ");
                String confirmation = scanner.nextLine().toLowerCase().trim();
                if (confirmation.equals("e")){
                    boolean result = bank.moneyTransfer(senderAccountNumber, buyerAccountNumber,amount);
                    System.out.println(result);
                }else if (confirmation.equals("h")){
                    continue;
                }else {
                    System.out.println("Geçersiz Seçim");
                }

            } else if (select.equals("2")) {
                bank.showInfo();
            } else if (select.equals("3")) {
                System.out.print("Lütfen Usd Miktarını Giriniz : ");
                double usd = scanner.nextDouble();
                System.out.println("Usd : " + Bank.usdTLCurrencyConvert(usd) + " Tl");

            } else if (select.equals("4")) {
                System.out.println("Çıkış Yapılıyor...");
                break;
            } else {
                System.out.println("Geçersiz Seçim yaptınız");
            }
        }
    }
}