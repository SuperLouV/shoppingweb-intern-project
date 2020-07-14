package com.dropshyp.shoppingweb.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long user_id;
    private String status;
    private Time order_date;
    private Time shipped_date;
    private long shipped_number;
    private String created_at;

    public Orders() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Time getOrderDate() {
        return order_date;
    }

    public void setOrderDate(Time order_date) {
        this.order_date = order_date;
    }

    public Time getShippedDate() {
        return shipped_date;
    }

    public void setShippedDate(Time shipped_date) {
        this.shipped_date = shipped_date;
    }

    public long getShippedNumber() {
        return shipped_number;
    }

    public void setShippedNumber(long shipped_number) {
        this.shipped_number = shipped_number;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }
}
