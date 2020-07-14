package com.dropshyp.shoppingweb.model;

import javax.persistence.*;

@Entity
@Table(name = "shops")
public class Shops {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "shop_detail")
    private Shops shops;

    public Shops() {}
}
