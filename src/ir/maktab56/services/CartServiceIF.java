package ir.maktab56.services;

import ir.maktab56.models.Order;
import ir.maktab56.models.Product;

public interface CartServiceIF {


    Double calculateOrdersTotalCost(Order order);

    String addProductToCart(Order order);

    String removeProductFromCart(Product product);

    boolean submitAllCartOrders();

    Order[] getOrders ();
}
