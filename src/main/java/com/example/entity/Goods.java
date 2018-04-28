package com.example.entity;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Goods {
    private Integer id;
    private String goodsName;
    private float goodsPrice;
    private String goodsPic;
    private String goodsDesc;
    private Integer goodsStatus;
    private Users seller;
    private Users buyer;
    private Set<Bid> bidSet;

    public Goods() {
    }

    public Goods(Integer id, String goodsName, float goodsPrice, String goodsPic, String goodsDesc, Integer goodsStatus, Users seller, Users buyer, Set<Bid> bidSet) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsPic = goodsPic;
        this.goodsDesc = goodsDesc;
        this.goodsStatus = goodsStatus;
        this.seller = seller;
        this.buyer = buyer;
        this.bidSet = bidSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    public Users getBuyer() {
        return buyer;
    }

    public void setBuyer(Users buyer) {
        this.buyer = buyer;
    }

    public Set<Bid> getBidSet() {
        return bidSet;
    }

    public void setBidSet(Set<Bid> bidSet) {
        this.bidSet = bidSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (Float.compare(goods.goodsPrice, goodsPrice) != 0) return false;
        if (!id.equals(goods.id)) return false;
        if (!goodsName.equals(goods.goodsName)) return false;
        if (!goodsPic.equals(goods.goodsPic)) return false;
        if (!goodsDesc.equals(goods.goodsDesc)) return false;
        if (!goodsStatus.equals(goods.goodsStatus)) return false;
        if (!seller.equals(goods.seller)) return false;
        if (!buyer.equals(goods.buyer)) return false;
        return bidSet.equals(goods.bidSet);
    }

}
