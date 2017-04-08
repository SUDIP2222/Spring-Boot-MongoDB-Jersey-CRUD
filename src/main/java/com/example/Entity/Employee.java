package com.example.Entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by sudip sarker on 4/9/2017.
 */
public class Employee {

    @Id
    private String id;

    @Size(min = 2, max = 70, message = "First Name must be more than 1 and less than 128 characters.")
    @Pattern(regexp = "^[^@$%]+$", message = "Your First Name can not contain any characters like @, $, %.")
    @NotNull(message = "Your First Name can not be null.")
    @NotEmpty(message = "Your First Name can not be empty.")
    @SafeHtml(message = "Please make sure First Name is properly formatted, containing no malicious characters.")
    private String firstname;

    @Size(min = 2, max = 70, message = "Last Name must be more than 1 and less than 128 characters.")
    @Pattern(regexp = "^[^@$%]+$", message = "Your Last Name can not contain any characters like @, $, %.")
    @NotNull(message = "Your Last Name can not be null.")
    @NotEmpty(message = "Your Last Name can not be empty.")
    @SafeHtml(message = "Please make sure Last Name is properly formatted, containing no malicious characters.")
    private String lastname;

    @Indexed(unique = true)
    @Size(min = 3, max = 70, message = "Email must be less than 254 characters.")
    @NotEmpty(message = "You must enter an email address.")
    @Pattern(regexp = "(^$|^.*@.*\\..*$)", message = "You must enter a valid email address.")
    @SafeHtml(message = "Please make sure your Email Address is properly formatted, containing no malicious characters.")
    @Email(message = "You must enter an valid email address.")
    private String email;


    @Size(min = 3, max = 70, message = "Designation must be more than 3 and less than 50 characters.")
    @Pattern(regexp = "^[^@$%]+$", message = "Designation can not contain any characters like @, $, %.")
    @NotNull(message = "Designation can not be null.")
    @NotEmpty(message = "Designation can not be empty.")
    @SafeHtml(message = "Please make sure Designation is properly formatted, containing no malicious characters.")
    private String designation;

    @Size(min = 3, max = 70, message = "Skype Id must be more than 3 and less than 128 characters.")
    @NotNull(message = "Skype Id can not be null.")
    @NotEmpty(message = "Skype Id can not be empty.")
    @SafeHtml(message = "Please make sure Skype Id is properly formatted, containing no malicious characters.")
    private String skypeid;


    @Size(min = 2, max = 10, message = "Blood Group must be more than 2 and less than 128 characters.")
    @NotNull(message = "Blood Group can not be null.")
    @NotEmpty(message = "Blood Group can not be empty.")
    @SafeHtml(message = "Please make sure Blood Group is properly formatted, containing no malicious characters.")
    private String bloodgroup;

    @NotNull(message = "Cell Number can not be null.")
    @NotEmpty(message = "Cell Number can not be empty.")
    @SafeHtml(message = "Please make sure Cell Number is properly formatted, containing no malicious characters.")
    @Pattern(regexp = "[0-9.\\-+ ]*", message = "Cell Number requires valid alphanumaric characters")
    private String cell ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSkypeid() {
        return skypeid;
    }

    public void setSkypeid(String skypeid) {
        this.skypeid = skypeid;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                ", skypeid='" + skypeid + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
                ", cell='" + cell + '\'' +
                '}';
    }
}
