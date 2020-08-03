package com.dropshyp.shoppingweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @author Yilinlou
 * @date 7/15/20 4:43 下午
 * @Email:ylou7@stevens.edu
 */


@Entity //define the entity
@Table(name = "shops")
public class Shops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shop_id;

    private String shop_name;

    private String shop_url;

    /**
     * @Description: Casacade refresh and merge operation
     * @Param:
     * @return:
     * @Author: Yilin Lou
     * @Date: 7/15/20
     */
    @OneToOne(mappedBy = "shop", cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private Users seller;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "shops_products")
    private List<Products> products;


    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_url() {
        return shop_url;
    }

    public void setShop_url(String shop_url) {
        this.shop_url = shop_url;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    private long product_id;

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}