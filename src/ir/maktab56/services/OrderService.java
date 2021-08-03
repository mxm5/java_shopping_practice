package ir.maktab56.services;

import ir.maktab56.base.services.BaseService;
import ir.maktab56.models.Order;
import ir.maktab56.repositories.OrderRepository;

public class OrderService extends BaseService<Order,Long, OrderRepository>  implements OrderServiceIF{
    public OrderService(OrderRepository repository) {
        super(repository);
    }

    @Override
    public boolean save(Order order) {
        return repository.save(order);
    }
}
