package za.edu.vcconnect.st10093235.poe;

public class Login {

    //Initialise variables
    private String firstname;
    private String username;
    private String password;
    private String lastname;
    public boolean isLoggedIn = false;


    //Constructor for the login instance.
    public Login(String firstname, String username, String password, String lastname) {

        //set variables
        this.firstname = firstname;
        this.username = username;
        this.password = password;
        this.lastname = lastname;

    }

    //Setters and getters for the login instance.

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    //Displays if the user is logged in
    public void returnLoginStatus() {
        if (isLoggedIn) {
            System.out.println("You are logged in.");

        } else {
            System.out.println("You are not logged in.");
        }
    }
}


