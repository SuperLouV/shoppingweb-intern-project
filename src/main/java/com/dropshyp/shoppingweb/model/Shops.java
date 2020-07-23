package com.dropshyp.shoppingweb.model;

import javax.persistence.*;

@Entity
@Table(name = "shops")
public class Shops {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long shop_id;

    @OneToOne(mappedBy = "shop_detail", cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    private Users seller;

    public Shops() {}

    public long getId() {
        return shop_id;
    }

    public void setShop_id(long id) {
        this.shop_id = id;
    }

//    public Users getSeller() {
//        return seller;
//    }
//
//    public void setSeller(Users seller) {
//        this.seller = seller;
//    }
}
