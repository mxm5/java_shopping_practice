package ir.maktab56.models;

import ir.maktab56.base.models.BaseEntity;

import java.awt.event.PaintEvent;
import java.time.Period;

public class Product extends BaseEntity<Long> {

    private String productName;
    private String cat;
    private Integer amount;
    private Double price;
    private String description;

    public Product(){}
    public Product(
            String productName,
            Integer amount,
            Double price,
            String description
    ) {
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
