public class PrivateBank extends Bank {
    public PrivateBank(String name, String headOfficeLocation) {
        super(name, headOfficeLocation);
    }

    @Override
    public boolean moneyTransfer(String senderAccountNumber, String buyerAccountNumber,double amount) {
        for (int i = 0; i < getAccounts().length; i++) {
            if (getAccounts()[i]!=null){
                if (getAccounts()[i].getAccountType().equals("TL")){
                    if (getAccounts()[i].getAccountNumber().equals(senderAccountNumber) && getAccounts()[i].getBalance()>=amount+2){
                        getAccounts()[i].setBalance(getAccounts()[i].getBalance()-2);
                    }
                } else if (getAccounts()[i].getAccountType().equals("USD")) {
                    if (getAccounts()[i].getAccountNumber().equals(senderAccountNumber)  && getAccounts()[i].getBalance()>=amount+1){

                        getAccounts()[i].setBalance(getAccounts()[i].getBalance()-1);
                    }
                }
            }

        }
        return super.moneyTransfer(senderAccountNumber, buyerAccountNumber,amount);
    }
}
