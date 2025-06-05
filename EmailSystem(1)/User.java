package EmailSystem;

import java.util.Objects;

public class User {
    //fields
    private String username;
    private String email;
    private String password; //Password should be hashed before storage

    //Constructors
    public User (String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //getters 
    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    //setters
    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    //register method
    public void register ()
    {

    }

    /**
     * Authenticates the user.
     *
     * @param email    The user's email.
     * @param password The user's password.
     * @return true if authentication is successful, false otherwise.
     */


    //update profile method
    public void updateProfile (String newUsername, String newEmail)
    {
        this.username = newUsername;
        this.email = newEmail;
        System.out.println ("Profile Updated");
    }

    //Overides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
