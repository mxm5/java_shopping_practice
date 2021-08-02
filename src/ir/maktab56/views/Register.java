package ir.maktab56.views;

import ir.maktab56.App;
import ir.maktab56.base.views.BasePage;
import ir.maktab56.models.User;
import ir.maktab56.repositories.UserRepository;
import ir.maktab56.services.UserService;

import java.util.Locale;

public class Register extends BasePage {

    private static final UserService service = new UserService(new UserRepository(App.connection));


    private String pass;
    private String usrName;
    private String phone;

    @Override
    protected void run() {
        String firstName = input(1, "insert user first name");

        String lastName = input(1, "insert user last name");
        while (true) {
            usrName = input(4, "enter a unique user name for yourself");
            User user = new User();
            user.setUsrName(usrName);
            if (!service.checkUserNameAvailable(user)) {
                print(" name is unique [OK]");
                break;
            }

        }
        while (true) {
            pass = input(4, "enter your password");
            String passConfirm = input(4, "confirm user password");
            if (pass.equals(passConfirm))
                break;
            print(" passwords should match try again");
        }
        if (input("enter your phone ( Optional ) [press y to enter phone ] ").toLowerCase().equals("y")) {
            while (true) {
                phone = input(10, " enter phone number ");
                // phone number must be less than 14 letters
                if(phone.length()<=14) break;
                print("phone number must be between 14 to 10 digits");
            }
        }

        User user = new User();
        user.setUsrName(usrName);
        user.setPass(pass);
        user.setPhoneNumber(phone);
        user.setFirstName(firstName);
        user.setLastName(lastName);
         if(service.registerNewUser(user))
             success();

        new Home();


    }
}
