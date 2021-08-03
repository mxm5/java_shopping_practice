package ir.maktab56.services;

import ir.maktab56.base.services.BaseService;
import ir.maktab56.models.Product;
import ir.maktab56.repositories.ProductRepository;

public class ProductService extends BaseService<Product,Long, ProductRepository> implements ProductServiceIF {
    public ProductService(ProductRepository repository) {
        super(repository);
    }

    @Override
    public Product[] readAll() {
        return super.readAll();
    }
}
