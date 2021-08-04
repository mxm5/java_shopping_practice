package ir.maktab56.services;

import ir.maktab56.models.Order;
import ir.maktab56.models.Product;

public interface CartServiceIF {

    void  initOtherServices();

    Double calculateOrdersTotalCost(Order order);

    String addProductToCart(Order order);

    String removeProductFromCart(Order order);

    boolean submitAllCartOrders();

    Order[] getOrders ();
}
