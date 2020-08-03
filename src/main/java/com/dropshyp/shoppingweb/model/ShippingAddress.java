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

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "buyer_id", referencedColumnName = "buyer_id")//设置在shipping_address表中的关联字段(外键)
    private Buyers buyers;

//    @ManyToOne(cascade = CascadeType.REFRESH)
//    private Buyers buyer;


    public long getShipping_address_id() {
        return shipping_address_id;
    }

    public void setShipping_address_id(long shipping_address_id) {
        this.shipping_address_id = shipping_address_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_apt() {
        return address_apt;
    }

    public void setAddress_apt(String address_apt) {
        this.address_apt = address_apt;
    }

    public String getAddress_country() {
        return address_country;
    }

    public void setAddress_country(String address_country) {
        this.address_country = address_country;
    }

    public String getAddress_zipcode() {
        return address_zipcode;
    }

    public void setAddress_zipcode(String address_zipcode) {
        this.address_zipcode = address_zipcode;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Buyers getBuyers() {
        return buyers;
    }

    public void setBuyers(Buyers buyers) {
        this.buyers = buyers;
    }
}
