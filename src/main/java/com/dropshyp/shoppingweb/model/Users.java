package com.dropshyp.shoppingweb.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String username;

    private String first_name;

    private String last_name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String gender;

    private Date birthday;

    private String address_street;

    private String address_city;

    private String address_apt;

    private String address_county;

    private String address_zipcode;

    private String phone_number;

    @Enumerated(EnumType.STRING)
    private UserType user_type;

    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id")
    private Shops shop_detail;

    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @javax.persistence.Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public String getAddress_zipcode() {
        return address_zipcode;
    }

    public void setAddress_zipcode(String address_zipcode) {
        this.address_zipcode = address_zipcode;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

//    public UserType getUserType() {
//        return user_type;
//    }
//
//    public void setUserType(UserType user_type) {
//        this.user_type = user_type;
//    }
}
