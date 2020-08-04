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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="buyer_id",referencedColumnName = "buyer_id")//设置在Order_items表中的关联字段(外键)
    private Buyers buyers;

    @JsonBackReference //表示生成json时该属性排除
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Products> products;

    public long cart_id() {
        return cart_id;
    }

    public void setCart_id(long cart_id) {
        this.cart_id= cart_id;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
