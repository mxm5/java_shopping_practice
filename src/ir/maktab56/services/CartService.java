package ir.maktab56.services;

import ir.maktab56.App;
import ir.maktab56.models.Order;
import ir.maktab56.models.Product;
import ir.maktab56.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartService implements CartServiceIF {

    private static final UserService userService = new UserService(new UserRepository(App.connection));


    private Double cartTotalOrdersPrice = 0.0;

    @Override
    public Double calculateOrdersTotalCost(Order order) {
        return order.getProduct().getPrice() * order.getAmount();
    }

    @Override
    public String addProductToCart(Order order) {
        final Long productId = order.getProduct().getId();
        if (cart.containsKey(productId)) {
            cartTotalOrdersPrice = cartTotalOrdersPrice - calculateOrdersTotalCost(cart.get(productId));
            cartTotalOrdersPrice = cartTotalOrdersPrice + calculateOrdersTotalCost(order);
            cart.put(order.getProduct().getId(), order);
            return "you already had this product ordered in cart your entered amount will change";
        } else if (cart.size() >= 5) {
            //could not add a product
            return "can only have 5 product orders in cart";
        } else {
            cartTotalOrdersPrice = cartTotalOrdersPrice + calculateOrdersTotalCost(order);
            cart.put(order.getProduct().getId(), order);
            return "your order successfully added to cart";
        }

    }


    @Override
    public String removeProductFromCart(Product product) {
        final Long productId = product.getId();
        if (cart.containsKey(productId)) {
            Order removedOrder = cart.get(productId);
            cartTotalOrdersPrice = cartTotalOrdersPrice - calculateOrdersTotalCost(removedOrder);
            cart.remove(productId);
            return "successfully removed the product order from cart";
        } else
            return "you haven't ordered this product";

    }

    @Override
    public boolean submitAllCartOrders() {
        for (Order order : cart.values()) {
            userService.placeAnOrder(order);
        }
        return false;
    }


    private Map<Long, Order> cart = new HashMap<>();

    public Double getCartTotalOrdersPrice() {
        return cartTotalOrdersPrice;
    }


    @Override
    public Order[] getOrders() {
        ArrayList<Order> orders = new ArrayList<>(cart.values());
        return orders.toArray(new Order[0]);
    }
}
