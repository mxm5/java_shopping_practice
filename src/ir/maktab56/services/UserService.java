package ir.maktab56.services;

import ir.maktab56.App;
import ir.maktab56.base.services.BaseService;
import ir.maktab56.models.Order;
import ir.maktab56.models.Product;
import ir.maktab56.models.User;
import ir.maktab56.repositories.OrderRepository;
import ir.maktab56.repositories.ProductRepository;
import ir.maktab56.repositories.UserRepository;

public class UserService extends BaseService<User, Long, UserRepository> implements UserServiceIF {
    private static final OrderService orderService = new OrderService(new OrderRepository(App.connection));


    public UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public User read(User user) {
        return super.read(user);
    }

    @Override
    public boolean checkUserNameAvailable(User user) {
        return repository.readByUsrName(user);
    }

    @Override
    public boolean registerNewUser(User user) {
        return repository.insertNewUser(user);
    }



    @Override
    public boolean addItemToCart(Product product, int amount) {

        Order order = new Order(product, currentUser, amount);

        return orderService.save(order);
    }

    public static User currentUser;


}
