package ir.maktab56.models;

import ir.maktab56.base.models.BaseEntity;

import java.sql.Timestamp;
import java.util.Date;

public class Order extends BaseEntity<Long> {
    private Product product;
    private User user;
    private Timestamp time;

public Order(){

}
//    Date date = new Date();
//    Timestamp ts = new Timestamp(date.getTime());
//    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
//            System.out.print(formatter.format(ts));
    public Order(Product product, User user){
        this.product = product;
        this.user = user;
        setOrderTimeToNow();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrderTimeToNow(){
        Date date =new Date();
        this.time = new Timestamp(date.getTime());
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
