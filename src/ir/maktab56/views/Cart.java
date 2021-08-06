package ir.maktab56.views;

import ir.maktab56.base.views.BasePage;
import ir.maktab56.models.Order;
import ir.maktab56.models.User;
import ir.maktab56.services.CartService;

public class Cart extends BasePage {
    private final CartService service;
    private final User user;

    Cart(CartService service, User user) {
        this.service = service;
        this.user = user;
        run();
    }

    @Override
    protected void run() {
        showCartList();
        String opt = input("do you want to [f]inalize or [e]dit order");
        while (true)
            if (opt.strip().equalsIgnoreCase("f")) {
                try {
                    service.submitAllCartOrders();
                    print("thank you ! your order has been " +
                            "placed");
                    print();
                    print();

                    if (input("if you want to place more orders return to shopping page " +
                            "\nby pressing any key \n" +
                            "or x to e[x]it").equalsIgnoreCase("x")) {
                        {
                            print();
                            line();
                            print("GOOD BYE AND TAKE CARE");
                            print(" exiting ...");
                        }
                    }
                    print();

                } catch (Exception e) {
                    err();
                }
                break;
            } else if (opt.strip().equalsIgnoreCase("e")) {
                new Products(user);
                break;

            } else
                err("invalid input");
    }

    private void showCartList() {
        int k = 0;
        for (Order order : service.getOrders()) {
            print(" item number :" + ++k);
            print("product  :" + order.getProduct().getProductName());
            print("product id  :" + order.getProduct().getId());
            print("Price  :" + order.getProduct().getPrice());
            print("amount  :" + order.getAmount());
            print("Orders cost :" + service.calculateOrdersTotalCost(order));
            line();

        }
    }
}
