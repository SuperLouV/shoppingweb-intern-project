package com.dropshyp.shoppingweb.model;

import javax.persistence.*;

/**
 * @author Yilinlou
 * @date 8/3/20 5:02 下午
 * @Email:ylou7@stevens.edu
 */

/**
 * @Description: Pictures data table
 * @Param:
 * @return:
 * @Author: Yilin Lou
 * @Date: 8/3/20
 */
@Entity //define the entity
@Table(name = "pictures")
public class Pictures {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long picture_id;

    private String product_id;

    private String picture_url;

    public long getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(long picture_id) {
        this.picture_id = picture_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }
}
