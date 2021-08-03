package ir.maktab56.views;

import ir.maktab56.App;
import ir.maktab56.base.views.BasePage;
import ir.maktab56.models.Product;
import ir.maktab56.models.User;
import ir.maktab56.repositories.ProductRepository;
import ir.maktab56.repositories.UserRepository;
import ir.maktab56.services.ProductService;
import ir.maktab56.services.UserService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Products extends BasePage {
    private final User user;
    private static final ProductService service = new ProductService(new ProductRepository(App.connection));

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

        for (Product product: service.readAll()){

            print("\t\t id :"+product.getId());
            print("\t\t name :"+product.getProductName());
            print("\t\t description :"+product.getDescription());
            print("\t\t category :"+product.getCat());
            print("\t\t price :"+product.getPrice());
            print("\t\t stock :"+product.getAmount());

            line();
        }


    }
}
