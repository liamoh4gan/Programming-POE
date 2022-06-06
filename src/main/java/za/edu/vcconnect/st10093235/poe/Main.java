package za.edu.vcconnect.st10093235.poe;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    // Initialise saved user
    public static Login savedLogin;

    public static void main(String[] args) {

        // initialise variables
        String firstname;
        String lastname;
        String username;
        String password;

        //Initialise scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your first name");
        // set first name
        firstname = input.next();

        System.out.println("Please enter your last name.");
        // set last name
        lastname = input.next();

        System.out.println("Please create a username.");
        // set username
        username = input.next();

        System.out.println("Please create a password.");
        // set password
        password = input.next();

        // create a new Login instance for the user
        Login login = new Login(firstname, username, password, lastname);
        // set saved user
        registerUser(login);
        // login user
        loginUser();
    }

    // Sets savedLogin to current user
    public static void registerUser(Login login) {
        if (checkUserName(login.getUsername()) && checkPasswordComplexity(login.getPassword())) {
            savedLogin = login;
            System.out.println("You have successfully registered as a new user");
            loginUser();
        } else {
            main(null);

        }
    }

    // Allows user to login
    public static void loginUser() {
        System.out.println("Please login.");
        Scanner input = new Scanner(System.in);

        String username;
        String password;

        System.out.println("Please enter your username.");
        username = input.next();

        System.out.println("Please enter your password.");
        password = input.next();

        if (savedLogin.getUsername().equals(username) && savedLogin.getPassword().equals(password)) {
            System.out.println("Welcome " + savedLogin.getFirstname() + ", " + savedLogin.getLastname() + " It's great to see you again");
            savedLogin.setLoggedIn(true);
            savedLogin.returnLoginStatus();

        } else {
            System.out.println("Username or password is incorrect. Please try again.");
            loginUser();
        }

    }

    //Returns if the username meets all requirements.
    public static boolean checkUserName(String username) {
        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username successfully captured.");
            return true;

        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }
    }

    //Returns if the password meets all the requirements
    public static boolean checkPasswordComplexity(String password) {
        if (password.length() >= 8 && Pattern.compile("^(?=.{10,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\W).*$").matcher(password).matches()) {
            System.out.println("Password successfully captured.");
            return true;

        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return false;
        }
    }
}
