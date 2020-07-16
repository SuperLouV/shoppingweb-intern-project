package com.dropshyp.shoppingweb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * @author Yilinlou
 * @date 7/16/20 5:15 下午
 * @Email:ylou7@stevens.edu
 */

@Entity //define the entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long category_id;

    private String categories_name;

    private String description;

    @JsonBackReference //表示生成json时该属性排除
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Products> products;

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getCategories_name() {
        return categories_name;
    }

    public void setCategories_name(String categories_name) {
        this.categories_name = categories_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
