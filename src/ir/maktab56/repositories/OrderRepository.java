package ir.maktab56.repositories;

import ir.maktab56.base.repositories.BaseRepository;
import ir.maktab56.models.Order;

import java.sql.Connection;

public class OrderRepository extends BaseRepository<Order, Long> implements OrdersRepositoryIF {



    public OrderRepository(Connection connection) {
        super(connection);
        createTable();
    }

    @Override
    protected void createTable() {
        final String sql = "CREATE TABLE IF NOT EXISTS `shopping_app`.`orders` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `date_time` DATETIME NOT NULL,\n" +
                "  `amount` INT NOT NULL,\n" +
                "  `user_id` INT NOT NULL,\n" +
                "  `product_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,\n" +
//                "  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,\n" +
//                "  UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC) VISIBLE,\n" +
                "  CONSTRAINT `fk_orders_users`\n" +
                "    FOREIGN KEY (`user_id`)\n" +
                "    REFERENCES `shopping_app`.`users` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `fk_orders_products`\n" +
                "    FOREIGN KEY (`product_id`)\n" +
                "    REFERENCES `shopping_app`.`products` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION);\n";

        basicUpdate(sql);

    }

    @Override
    public boolean save(Order order) {

        String sql = String.format("INSERT INTO `shopping_app`.`orders` " +
                        "( `date_time`, `user_id`, `product_id`,`amount`) VALUES ( '%s', '%s', '%s', '%s');",
                order.getTime(), order.getUser().getId(), order.getProduct().getId(),order.getAmount());
        return basicUpdate(sql);


    }
}
