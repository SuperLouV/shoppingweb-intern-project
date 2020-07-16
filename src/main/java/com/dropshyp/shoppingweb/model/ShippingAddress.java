package com.dropshyp.shoppingweb.model;

import javax.persistence.*;

/**
 * @author Yilinlou
 * @date 7/16/20 6:13 下午
 * @Email:ylou7@stevens.edu
 */

@Entity
@Table(name = "shipping_address")
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long shipping_address_id;

//    private long order_id;

    private String first_name;

    private String last_name;

    private String address_street;

    private String address_city;

    private String address_apt;

    private String address_country;

    private String address_zipcode;     //Canada zip has letters

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")//设置在shipping_address表中的关联字段(外键)
    private Orders order;

//    @ManyToOne(cascade = CascadeType.REFRESH)
//    private Buyers buyer;


}
