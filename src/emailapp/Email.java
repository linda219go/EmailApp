package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private  int mailboxCapacity;
    private int defaultPWLen = 10;
    private String alternateEmail;

    //constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + this.department + ".com";
        this.password= randomPW(defaultPWLen);

    }

    //asking for the department
    private String setDepartment(){
        System.out.println("Enter the department \n 1 for Sales \n 2 for Development \n 3 for Accounting \n 0 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1) {return "sales";}
        else if(depChoice == 2) {return "dev";}
        else if(depChoice == 3) {return "acct";}
        else {return "";}
    }

    //Generate a random password
    private String randomPW(int len){
        String pw = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[len];
        for (int i = 0; i < len; i++) {
            int rand = (int)(Math.random()*pw.length());
            password[i] = pw.charAt(rand);
        }
        return new String(password);
    }

    private void setMailboxCapacity(int cap){
        this.mailboxCapacity = cap;
    }
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    private void changePW(String pw){
        this.password = pw;
    }
    public void showInfo(){
        System.out.println("Hi, your email is: " + this.email + ", password: " + this.password +  ", department: " + this.department + ", alternate email: " + this.alternateEmail + ".");
    }
}
