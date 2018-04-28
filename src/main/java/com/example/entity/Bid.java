package com.example.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Bid {
    private Integer id;
    private Goods goods;
    private Users buyer;
    private Date bidTime;
    private float bidPrice;
    private Integer bidStatus;

    public Bid() {
    }

    public Bid(Integer id, Goods goods, Users buyer, Date bidTime, float bidPrice, Integer bidStatus) {
        this.id = id;
        this.goods = goods;
        this.buyer = buyer;
        this.bidTime = bidTime;
        this.bidPrice = bidPrice;
        this.bidStatus = bidStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Users getBuyer() {
        return buyer;
    }

    public void setBuyer(Users buyer) {
        this.buyer = buyer;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    public float getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(float bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Integer getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(Integer bidStatus) {
        this.bidStatus = bidStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bid = (Bid) o;

        if (Float.compare(bid.bidPrice, bidPrice) != 0) return false;
        if (!id.equals(bid.id)) return false;
        if (!goods.equals(bid.goods)) return false;
        if (!buyer.equals(bid.buyer)) return false;
        if (!bidTime.equals(bid.bidTime)) return false;
        return bidStatus.equals(bid.bidStatus);
    }

}
