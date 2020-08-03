package com.dropshyp.shoppingweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * @author Yilinlou
 * @date 7/16/20 5:11 下午
 * @Email:ylou7@stevens.edu
 */

@Entity //define the entity
@Table(name = "suppliers")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long supplier_id;

    private String supplier_name;

    private String contact_name;

    @JsonBackReference //表示生成json时该属性排除
    @OneToMany(mappedBy = "suppliers", cascade = CascadeType.ALL)
    private List<Products> products;

    public long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
