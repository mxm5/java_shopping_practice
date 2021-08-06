package ir.maktab56.services;

import ir.maktab56.base.services.Service;
import ir.maktab56.models.Order;
import ir.maktab56.models.Product;
import ir.maktab56.models.User;

public interface UserServiceIF extends Service<User,Long> {
    boolean checkUserNameAvailable(User user);
    boolean registerNewUser(User user);
//    boolean addItemToCart( Product product);

    boolean placeAnOrder(Order order);
}
