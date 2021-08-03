package ir.maktab56.models;

import ir.maktab56.base.models.BaseEntity;

public class Cart extends BaseEntity<Long> {
    private User user;
    private Order order;
}
