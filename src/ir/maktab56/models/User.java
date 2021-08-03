package ir.maktab56.models;

import ir.maktab56.base.models.BaseEntity;

public class User extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String pass;
    private String usrName;

    public User() {
    }

    public User(String usrName,String pass){

        this.usrName = usrName;
        this.pass = pass;

    }

    public User(String firstName,
                String lastName,
                String usrName,
                String phoneNumber,
                String pass,
                Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.usrName = usrName;
        this.phoneNumber = phoneNumber;
        this.pass = pass;
        setId(id);
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
//                ", pass='" + pass + '\'' +
                ", usrName='" + usrName + '\'' +
                ", id='" + getId() + '\'' +
                '}';
    }
}
