package ir.maktab56.views;

import ir.maktab56.App;
import ir.maktab56.base.views.BasePage;
import ir.maktab56.models.Order;
import ir.maktab56.models.Product;
import ir.maktab56.models.User;
import ir.maktab56.repositories.ProductRepository;
import ir.maktab56.repositories.UserRepository;
import ir.maktab56.services.CartService;
import ir.maktab56.services.ProductService;
import ir.maktab56.services.UserService;

public class Products extends BasePage {
    private final User user;

    private static final ProductService productService = new ProductService(new ProductRepository(App.connection));

    private static final CartService cartService = new CartService();

    public Products(User user) {
        this.user = user;
        defaultInit();
    }


    @Override
    protected void run() {

        print("welcome to products");
        sayTime();
        print(" ".repeat(10) + user.getFirstName() + " " + user.getLastName());
        print("list of products ");
        line();
        int k = 0;
        Product[] allProducts = productService.readAll();
        for (Product product : allProducts) {
            print("\t\t Number" + ++k);
            print("\t\t id :" + product.getId());
            print("\t\t name :" + product.getProductName());
            print("\t\t description :" + product.getDescription());
            print("\t\t category :" + product.getCat());
            print("\t\t price :" + product.getPrice());
            print("\t\t stock :" + product.getAmount());

            line();
        }

        while (true) {
            if (input("select a product number from list \n" +
                    "[ (y) to select a product] \n " +
                    "[or any key to view cart]").strip()
                    .equalsIgnoreCase("y")) {
                int select = inputSelector(k, "select an item by its number");
                Product selectedProduct = allProducts[select - 1];

                print(" you selected product : [ "+selectedProduct.getProductName() + " ]");
                String opt= input(
                        "[ press ( a ) to add product to cart] \n " +
                                "[or ( r ) key to remove product from cart]");

                if (opt.strip().equalsIgnoreCase("a")) {
                    int amount = inputSelector(selectedProduct.getAmount(), "select the amount");
                    Order givenOrder = new Order(selectedProduct, user, amount);
                    print(cartService.addProductToCart(givenOrder));}
                else  if (opt .equalsIgnoreCase("r")){
                    print(cartService.removeProductFromCart(selectedProduct));
                }else {
                    print("invalid input");
                }

            } else {
                new Cart(cartService,user);
                break;
            }
        }



    }
}
