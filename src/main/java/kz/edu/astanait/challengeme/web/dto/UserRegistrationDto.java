package kz.edu.astanait.challengeme.web.dto;

public class UserRegistrationDto {
    private String firstname;
    private String lastname;
    private String email;
    private String location;
    private String password;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String firstname, String lastname, String email, String location, String password) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.location = location;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
