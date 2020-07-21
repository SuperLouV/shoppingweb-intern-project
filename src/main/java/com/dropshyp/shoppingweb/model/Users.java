package com.dropshyp.shoppingweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Yilinlou
 * @date 7/8/20 4:08 下午
 * @Email:ylou7@stevens.edu
 */

@Entity //define the entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

//    private long shop_id;

    private String title;

    private String username;

    private String first_name;

    private String last_name;

    private String email;

    private String password;

    private String gender;

    private String birthday;

    private String address_street;

    private String address_city;

    private String address_apt;

    private String address_county;

    private int address_zipcode;

    private int phone_number;

    private String user_types;

    private String ip_address;


    /**
     * @Description: link users and shops
     * mappedBy:users(defined in Shops.class, means a Object)
     * @Param:
     * @return:
     * @Author: Yilin Lou
     * @Date: 7/15/20
     */
    @OneToOne(cascade = CascadeType.ALL)      //所有权限，删除用户则删除店
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")//设置在users表中的关联字段(外键)
    private Shops shop;

    /**
     * @Description: link between order_itemsSet and users
     * @Param:
     * @return: set of order_itemsSet
     * @Author: Yilin Lou
     * @Date: 7/15/20
     */
    @JsonBackReference //表示生成json时该属性排除
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Order_items> order_itemsSet;


    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

//    public long getShop_id() {
//        return shop_id;
//    }
//
//    public void setShop_id(long shop_id) {
//        this.shop_id = shop_id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getAddress_county() {
        return address_county;
    }

    public void setAddress_county(String address_county) {
        this.address_county = address_county;
    }

    public int getAddress_zipcode() {
        return address_zipcode;
    }

    public void setAddress_zipcode(int address_zipcode) {
        this.address_zipcode = address_zipcode;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getUser_types() {
        return user_types;
    }

    public void setUser_types(String user_types) {
        this.user_types = user_types;
    }

    public Shops getShop() {
        return shop;
    }

    public void setShop(Shops shop) {
        this.shop = shop;
    }

    public List<Order_items> getOrder_itemsSet() {
        return order_itemsSet;
    }

    public void setOrder_itemsSet(List<Order_items> order_itemsSet) {
        this.order_itemsSet = order_itemsSet;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }
}
