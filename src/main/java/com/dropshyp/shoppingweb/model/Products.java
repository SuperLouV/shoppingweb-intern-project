package com.dropshyp.shoppingweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

/**
 * @author Yilinlou
 * @date 7/15/20 4:04 下午
 * @Email:ylou7@stevens.edu
 */
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_id;

    private String name;

    private String description;

//    private long supplier_id;

//    private long category_id;

    private int price;

    private int stock;

    //@Lob 通常与@Basic同时使用，提高访问速度
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    private String status;

    private Time create_at;

    /**
     * @Description: link between products and order_items
     * @Param:
     * @return: List
     * @Author: Yilin Lou
     * @Date: 7/15/20
     */
    @JsonBackReference //表示生成json时该属性排除
    @OneToMany(mappedBy = "products")
    private List<OrderItems> order_itemsSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")//设置在suppliers表中的关联字段(外键)
    private Suppliers suppliers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")//设置在Categories中的关联字段(外键)
    private Categories categories;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "shops_products")
    private List<Shops> shops;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public long getSupplier_id() {
//        return supplier_id;
//    }
//
//    public void setSupplier_id(long supplier_id) {
//        this.supplier_id = supplier_id;
//    }
//
//    public long getCategory_id() {
//        return category_id;
//    }
//
//    public void setCategory_id(long category_id) {
//        this.category_id = category_id;
//    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderItems> getOrder_itemsSet() {
        return order_itemsSet;
    }

    public void setOrder_itemsSet(List<OrderItems> order_itemsSet) {
        this.order_itemsSet = order_itemsSet;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Time getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Time create_at) {
        this.create_at = create_at;
    }

    public List<Shops> getShops() {
        return shops;
    }

    public void setShops(List<Shops> shops) {
        this.shops = shops;
    }
}
