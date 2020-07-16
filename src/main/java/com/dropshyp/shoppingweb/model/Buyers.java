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

//    @OneToMany(mappedBy = "buyer",cascade = CascadeType.ALL)
//    @JoinColumn(name = "shipping_address_id", referencedColumnName = "shipping_address_id")//设置在shipping_address表中的关联字段(外键)
//    private List<ShippingAddress> shippingAddresses;


}
