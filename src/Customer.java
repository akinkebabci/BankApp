public class Customer {
    private String firstName;
    private String lastName;
    private String identityNumber;


    public Customer(String firstName, String lastName, String identityNumber) {

        if (firstName.isEmpty()){
            firstName = "empty";
        }
        if (lastName.isEmpty()){
            lastName = "empty";
        }
        if (identityNumber.isEmpty()){
            identityNumber = "00000000000";
        }if (identityNumber.length() != 11){
            identityNumber = "00000000000";
        }
        this.firstName = firstName.trim().toUpperCase();
        this.lastName = lastName.trim().toUpperCase();
        this.identityNumber = identityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void showInfo(){
        System.out.println("Adı : " + this.firstName);
        System.out.println("Soyadı : " + this.lastName);
        System.out.println("Tc Kimlik No : " + this.identityNumber);
    }
}
