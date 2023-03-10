package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;

    private String email;
    private int defaultPasswordLength = 16;

    private String companySuffix = "tiberbytes.pl";
    private int mailBoxCapacity = 500;
    private String alternateEmail;

    // constructor to receive first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // Call a method asking for the department - Return String department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //Call a method - Return String password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Password: " + this.password);

        //Generate email:
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department +  "." + companySuffix;
        System.out.println("Email: " + this.email);
    }
    // ask for the department
private String setDepartment(){
        System.out.print("Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1) { return "sales"; }
        else if(depChoice == 2) { return "dev"; }
        else if(depChoice == 3) { return "acct"; }
        else { return ""; }
}
    // generate the random password
private String randomPassword(int length){
    String passwordSet = "ABCDEFGHIJKLMNOPRSTUWYXZ0123456789!@#$%^&*()_";
    char[] password = new char[length];
    for(int i = 0; i < length; i++){
        int rand = (int) (Math.random() * passwordSet.length());
        password[i] = passwordSet.charAt(rand);
    }
    return new String(password);
}

    // set the mailbox capacity
public void setMailboxCapacity(int newCapacity){
        this.mailBoxCapacity = newCapacity;
}
    // set the alternate email
public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
}

    // change the password
public void setPassword(String newPassword) {
    this.password = newPassword;
}

    // get methods
    public int getMailBoxCapacity() { return mailBoxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public  String getPassword() { return password; }
}
