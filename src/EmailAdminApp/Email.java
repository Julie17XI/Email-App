package EmailAdminApp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int passwordLength = 9;
    private int mailboxCapacity = 1000;
    static final String DEFAULTDOMAIN = "company.com";
    private String alternativeEmail;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        String printableFirstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
        String printableLastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
        System.out.println("CREATE EMAIL: " + printableFirstName + " " + printableLastName);
        String depName = getDepName();
        this.email = setCompanyEmail(firstName, lastName, depName);
        this.password = setPassword(passwordLength);
        System.out.println("YOUR DEFAULT PASSWORD IS: " + password);
        showInfo(depName);
    }

    private void showInfo(String depName){
        System.out.print("FIRST NAME: " + firstName.toUpperCase() + "     LAST NAME: " + lastName.toUpperCase() + "\nDEPARTMENT: " + depName.toUpperCase() +
                "\nEMAIL: " + email + "\nEMAIL CAPACITY: " + mailboxCapacity + "MB");
    }
    private String setCompanyEmail(String firstName, String lastName, String depName){
        String domain = depName.equals("")  ? DEFAULTDOMAIN : depName + "." + DEFAULTDOMAIN;
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + domain;
    }

    private String setPassword(int length){
        String alphanums = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        int choiceNums = alphanums.length();
        char[] passwordChars = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random() * choiceNums);
            passwordChars[i] = alphanums.charAt(rand);
        }
        return new String(passwordChars);
    }
    private String getDepName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("DEPARTMENT CODE: \n1: SALES \n2: DEVELOPEMENT \n3: ACCOUNTING \n0: None OF THE ABOVE " +
                "\nEnter Department Code: ");
        int depCode = sc.nextInt();
        switch(depCode){
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }
    }

    public void setAlternativeEmail(String altemail){
        this.alternativeEmail = altemail;
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void changePassword(String customPassword){
        this.password = customPassword;
    }

    public String getAlternativeEmail(){ return alternativeEmail; }
    public int getMailboxCapacity(){ return mailboxCapacity; }
    public String getPassword(){ return password; }
}
