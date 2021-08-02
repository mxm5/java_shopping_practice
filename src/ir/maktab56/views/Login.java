package ir.maktab56.views;

import ir.maktab56.App;
import ir.maktab56.base.views.BasePage;
import ir.maktab56.models.User;
import ir.maktab56.repositories.UserRepositoryImpl;
import ir.maktab56.services.UserService;

public class Login extends BasePage {

    private final UserService service = new UserService(new UserRepositoryImpl(App.connection));

    @Override
    protected void run() {

        String userName = input(4, "enter your user name");
        String pass = input(8, "enter your password");
        User loggedInUser = new User(userName, pass);
        if (readUser(loggedInUser))
            new Products();
        else
            new Home();
    }

    private boolean readUser(User user) {
        boolean isValid = false;

        return isValid;
    }
}
