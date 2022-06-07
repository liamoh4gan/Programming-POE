package za.edu.vcconnect.st10093235.poe;

import javax.swing.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {
    // Initialise saved user
    public static Login savedLogin;
    public static Set<Task> savedTasks = new HashSet<>();

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
            System.out.println("Welcome to EasyKanban.");

            while (true) {

                System.out.println("1. Add Tasks\n2. Show Report\n3. Quit ");
                switch (input.nextInt()) {
                    //Add tasks
                    case 1:


                        System.out.println("How many tasks would you like to add?");
                        int numberOfTasks = input.nextInt();

                        while (numberOfTasks > 0) {
                            Scanner sc = new Scanner(System.in);
                            Task newTask = new Task();

                            System.out.println("Please enter the Task name.");
                            newTask.setTaskName(sc.nextLine());

                            System.out.println("Please enter the task description");
                            newTask.setTaskDescription(sc.nextLine());

                            System.out.println("Please enter developer details.");
                            newTask.setDeveloperDetails(sc.nextLine());

                            System.out.println("Please enter task duration. (hours)");
                            newTask.setTaskDuration(sc.nextFloat());


                            System.out.println("Please select a task status\n1. To Do\n2. Done\n3. Doing");
                            switch (sc.nextInt()) {


                                case 1:

                                    newTask.setTaskStatus(TaskStatus.TODO);

                                    break;


                                case 2:

                                    newTask.setTaskStatus(TaskStatus.DONE);

                                    break;

                                case 3:

                                    newTask.setTaskStatus(TaskStatus.DOING);

                                    break;

                                default:

                            }

                            newTask.setTaskNumber(savedTasks.size());

                            char[] taskChars = newTask.getTaskName().toUpperCase().toCharArray();
                            char[] developerChars = newTask.getDeveloperDetails().toUpperCase().toCharArray();
                            newTask.setTaskId(taskChars[0] + taskChars[1] + ":" + newTask.getTaskNumber() + ":" + developerChars[developerChars.length - 3] + developerChars[developerChars.length - 2] + developerChars[developerChars.length-1]);

                            savedTasks.add(newTask);
                            System.out.println("Task successfully saved");
                            JOptionPane.showConfirmDialog(null, "Task Status: " + newTask.getTaskStatus().toString() + "\nDeveloper Details: " + newTask.getDeveloperDetails() + "\nTask Number: " + newTask.getTaskNumber() + "\nTask Name: " + newTask.getTaskName() + "\nTask Description: " + newTask.getTaskDescription() + "\nTask ID: " + newTask.getTaskId() + "\nTask Duration: " + newTask.getTaskDuration(), "Task Details", JOptionPane.OK_OPTION);

                            numberOfTasks--;
                        }

                        break;

                    //Show report
                    case 2:
                        System.out.println("Coming soon.");

                        break;
                    //Quit
                    case 3:
                        System.exit(0);
                        break;
                    default:
                }
            }


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
