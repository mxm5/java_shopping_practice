package ir.maktab56.views;

import ir.maktab56.App;
import ir.maktab56.base.views.BasePage;
import ir.maktab56.models.User;
import ir.maktab56.repositories.UserRepository;
import ir.maktab56.services.UserService;

public class Login extends BasePage {

    private static final UserService service = new UserService(new UserRepository(App.connection));

    public Login() {
        defaultInit();
    }

    private User foundUser;

    @Override
    protected void run() {

        String userName = input(4, "enter your user name");
        String pass = input(4, "enter your password");
        User loggedInUser = new User(userName, pass);
        foundUser = readUser(loggedInUser);
        if (foundUser != null) {
            success();
            UserService.currentUser = foundUser;
            new Products(foundUser);
        } else {
            err();
            new Home();
        }
    }

    private User readUser(User user) {

        return service.read(user);

    }
}
