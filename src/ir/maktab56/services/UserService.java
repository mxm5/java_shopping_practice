package ir.maktab56.services;

import ir.maktab56.base.services.BaseService;
import ir.maktab56.models.User;
import ir.maktab56.repositories.UserRepositoryImpl;

public class UserService extends BaseService<User,Long, UserRepositoryImpl> {
    public UserService(UserRepositoryImpl repository) {
        super(repository);
    }

    @Override
    public User read(User user) {
        return super.read(user);
    }
}
