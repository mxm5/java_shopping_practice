package ir.maktab56.repositories;

import ir.maktab56.base.repositories.Repository;
import ir.maktab56.models.Product;

public interface ProductRepositoryIF extends Repository<Product,Long> {
    boolean insertFakeData();
}
