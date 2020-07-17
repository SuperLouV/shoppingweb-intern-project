package com.dropshyp.shoppingweb.model;

import javax.persistence.*;

/**
 * @author Yilinlou
 * @date 7/15/20 4:21 下午
 * @Email:ylou7@stevens.edu
 */

@Entity
@Table(name = "order_items")
public class Order_items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long order_item_id;

//    private long product_id;

//    private long user_id;

    private int quantity;

    /**
    * @Description:
    * @Param:
    * @return:
    * @Author: Yilin Lou
    * @Date: 7/15/20
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",referencedColumnName = "user_id")//设置在Order_items表中的关联字段(外键)
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id",referencedColumnName = "product_id")//设置在Order_items表中的关联字段(外键)
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id",referencedColumnName = "order_id")//设置在Order_items表中的关联字段(外键)
    private Orders orders;

    public long getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(long order_item_id) {
        this.order_item_id = order_item_id;
    }

//    public long getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(long product_id) {
//        this.product_id = product_id;
//    }

//    public long getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(long user_id) {
//        this.user_id = user_id;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
