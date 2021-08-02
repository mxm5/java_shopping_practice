package ir.maktab56.services;

import ir.maktab56.base.services.BaseService;
import ir.maktab56.models.User;
import ir.maktab56.repositories.UserRepository;

public class UserService extends BaseService<User,Long, UserRepository> implements UserServiceIF{
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


}
