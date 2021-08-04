package ir.maktab56.services;

import ir.maktab56.base.services.Service;
import ir.maktab56.models.Product;

public interface ProductServiceIF extends Service<Product,Long> {
       boolean updateRepositoryAmount(int changedAmount , Product product);

}
