package ir.maktab56.services;

import ir.maktab56.App;
import ir.maktab56.base.services.BaseService;
import ir.maktab56.models.Order;
import ir.maktab56.repositories.OrderRepository;
import ir.maktab56.repositories.ProductRepository;

public class OrderService extends BaseService<Order, Long, OrderRepository> implements OrderServiceIF {
    public OrderService(OrderRepository repository) {
        super(repository);
    }

    private static final ProductService productService = new ProductService(new ProductRepository(App.connection));


    @Override
    public boolean save(Order order) {
        boolean res1 = productService.updateRepositoryAmount(order.getAmount(), order.getProduct());


        boolean res2 = repository.save(order);
        return res1 && res2;

    }
}
