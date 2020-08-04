package com.dropshyp.shoppingweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

/**
 * @author Haodong Wu
 * @date 8/04/20
 * @Email:hwu38@stevens.edu
 */

@Entity //define the entity
@Table(name = "carts")
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cart_id;

    @JsonBackReference //表示生成json时该属性排除
    @OneToMany(mappedBy = "carts",cascade = CascadeType.REFRESH)
    private List<CartItems> cart_itemsSet;

    @OneToOne(mappedBy = "cart", cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private Buyers buyer;

    public Carts() {

    }

    public long getCart_id() {
        return cart_id;
    }

    public List<CartItems> getCart_itemsSet() {
        return cart_itemsSet;
    }

    public Buyers getBuyer() {
        return buyer;
    }

    public void setCart_id(long cart_id) {
        this.cart_id = cart_id;
    }

    public void setCart_itemsSet(List<CartItems> cart_itemsSet) {
        this.cart_itemsSet = cart_itemsSet;
    }

    public void setBuyer(Buyers buyer) {
        this.buyer = buyer;
    }
}
