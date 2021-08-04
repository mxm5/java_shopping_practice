package ir.maktab56.repositories;

import ir.maktab56.base.repositories.BaseRepository;
import ir.maktab56.models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository extends BaseRepository<Product, Long> implements ProductRepositoryIF {
    public ProductRepository(Connection connection) {
        super(connection);
        createTable();
//        insertFakeData();
    }

    @Override
    protected void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS `shopping_app`.`products` (\n" +
                "    `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "    `name` VARCHAR(100) NOT NULL,\n" +
                "    `cat` VARCHAR(100) NOT NULL,\n" +
                "    `desc` MEDIUMTEXT NULL,\n" +
                "    `price` DOUBLE NOT NULL,\n" +
                "    `amount` INT NULL,\n" +
                "    PRIMARY KEY (`id`),\n" +
                "    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);\n";

        try {
             connection.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean insertFakeData() {
        String[] sqlList =
                {"       INSERT INTO `shopping_app`.`products` (`name`, `desc`, `price`, `amount`, `cat` ) VALUES ('iphone', 'good product', '12.00', '20' ,'electric' );\n",
                        "INSERT INTO `shopping_app`.`products` (`name`, `desc`, `price`, `amount`, `cat` ) VALUES ('nokia', 'hard product', '1.0', '20' ,'electric' );\n",
                        "INSERT INTO `shopping_app`.`products` (`name`, `desc`, `price`, `amount`, `cat` ) VALUES ('samsung', 'best product', '13.0', '20' ,'electric' );\n",
                        "INSERT INTO `shopping_app`.`products` (`name`, `desc`, `price`, `amount`, `cat` ) VALUES ('harry potter', 'best product', '13.0', '20' ,'reading' );\n",
                        "INSERT INTO `shopping_app`.`products` (`name`, `desc`, `price`, `amount`, `cat` ) VALUES ('london times', 'good product', '23.0', '20' ,'reading' );\n",
                        "INSERT INTO `shopping_app`.`products` (`name`, `desc`, `price`, `amount`, `cat` ) VALUES ('oliver twist', 'nice product', '15.0', '20' ,'reading' );\n",
                        "INSERT INTO `shopping_app`.`products` (`name`, `desc`, `price`, `amount`, `cat` ) VALUES ('nike', 'best product', '13.0', '20' ,'reading' );\n",
                        "INSERT INTO `shopping_app`.`products` (`name`, `desc`, `price`, `amount`, `cat` ) VALUES ('adidas', 'good product', '23.0', '20' ,'reading' );\n",
                        "INSERT INTO `shopping_app`.`products` (`name`, `desc`, `price`, `amount`, `cat` ) VALUES ('bur bury', 'nice product', '15.0', '20' ,'reading' );\n"};

        try {
            int res = 1;
            for (String sql : sqlList) {
                res = res * connection.createStatement().executeUpdate(sql);
            }
            return res != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateRepositoryAmount(int changedAmount, Product product) {
        int newAmount = product.getAmount() - changedAmount;
        String sql = String.format("UPDATE `shopping_app`.`products` SET `amount` = '%d' WHERE (`id` = '%d');",
                 newAmount,
                product.getId()
        );

        return basicUpdate(sql);
    }


    @Override
    public Product[] readAll() {
        String sql = "SELECT * FROM shopping_app.products;";
        ResultSet res = basicQuery(sql);
        ArrayList<Product> products = new ArrayList<>();
        while (true) {
            try {
                if (!res.next()) break;
                Product p = new Product();
                p.setId(res.getLong(1));
                p.setProductName(res.getString(2));
                p.setCat(res.getString(3));
                p.setDescription(res.getString(4));
                p.setPrice(res.getDouble(5));
                p.setAmount(res.getInt(6));
                products.add(p);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products.toArray(new Product[0]);
    }
}
