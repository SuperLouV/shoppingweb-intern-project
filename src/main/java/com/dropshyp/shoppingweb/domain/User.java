package com.dropshyp.shoppingweb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Yilinlou
 * @date 7/8/20 4:08 下午
 * @Email:ylou7@stevens.edu
 */

@Entity //declear the entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String birthday;
    private String address_street;
    private String address_city;
    private String address_apt;
    private String address_county;
    private int address_zipcode;
    private int phonenumber;



    public User() {
    }

    public User(String name, String password) {

        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}
