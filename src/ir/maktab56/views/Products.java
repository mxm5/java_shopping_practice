package ir.maktab56.views;

import ir.maktab56.App;
import ir.maktab56.base.views.BasePage;
import ir.maktab56.models.Product;
import ir.maktab56.models.User;
import ir.maktab56.repositories.ProductRepository;
import ir.maktab56.repositories.UserRepository;
import ir.maktab56.services.ProductService;
import ir.maktab56.services.UserService;

public class Products extends BasePage {
    private final User user;
    private static final ProductService productService = new ProductService(new ProductRepository(App.connection));
    private static final UserService userService = new UserService(new UserRepository(App.connection));

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
        int k =0;
        Product[] allProducts = productService.readAll();
        for (Product product: allProducts){
            print("\t\t Number"+ ++k);
            print("\t\t id :"+product.getId());
            print("\t\t name :"+product.getProductName());
            print("\t\t description :"+product.getDescription());
            print("\t\t category :"+product.getCat());
            print("\t\t price :"+product.getPrice());
            print("\t\t stock :"+product.getAmount());

            line();
        }

        while (true) {
                if(input("select a product number to order [y to select]").equalsIgnoreCase("y")) {
                    int select = inputSelector(k, "select an item by its number");
                    Product selectedProduct = allProducts[select - 1];
                    print(" you selected product");
                    UserService.currentUser = user;
                    userService.addItemToCart(selectedProduct);
                }else break;
        }


    }
}
