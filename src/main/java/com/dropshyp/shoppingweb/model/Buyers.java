package com.dropshyp.shoppingweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

/**
 * @author Yilinlou
 * @date 7/16/20 5:52 下午
 * @Email:ylou7@stevens.edu
 */

@Entity //define the entity
@Table(name = "buyers")
public class Buyers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long buyer_id;

//    private long shipping_address_id;

    private String username;

    private String gender;

    private String email;

    private String password;

    private Time created_at;

    @JsonBackReference //表示生成json时该属性排除
    @OneToMany(mappedBy = "buyers", cascade = CascadeType.ALL)
    private List<Orders> orders;

    @JsonBackReference //表示生成json时该属性排除
    @OneToMany(mappedBy = "buyers", cascade = CascadeType.ALL)
    private List<ShippingAddress> shippingAddresses;

    public long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(long buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Time getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Time created_at) {
        this.created_at = created_at;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<ShippingAddress> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setShippingAddresses(List<ShippingAddress> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }
}
