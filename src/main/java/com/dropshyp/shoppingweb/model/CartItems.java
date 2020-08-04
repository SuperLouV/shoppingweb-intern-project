package com.dropshyp.shoppingweb.model;

import javax.persistence.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

/**
 * @author Haodong Wu
 * @date 8/04/20
 * @Email:hwu38@stevens.edu
 */

@Entity //define the entity
@Table(name = "cart_items")
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cart_item_id;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="buyer_id", referencedColumnName = "buyer_id")//设置在cart_items表中的关联字段(外键)
    private Buyers buyers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", referencedColumnName = "product_id")//设置在cart_items表中的关联字段(外键)
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id", referencedColumnName = "cart_id")//设置在cart_items表中的关联字段(外键)
    private Carts carts;

    public long getCart_item_id() {
        return cart_item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Buyers getBuyers() {
        return buyers;
    }

    public Products getProducts() {
        return products;
    }

    public Carts getCarts() {
        return carts;
    }

    public void setCart_item_id(long cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBuyers(Buyers buyers) {
        this.buyers = buyers;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public void setCarts(Carts carts) {
        this.carts = carts;
    }
}