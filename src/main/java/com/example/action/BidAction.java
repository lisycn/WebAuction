package com.example.action;

import com.example.entity.Bid;
import com.example.entity.Goods;
import com.example.entity.Users;
import com.example.service.BidService;
import com.example.service.GoodsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@Scope("prototype")
public class BidAction extends ActionSupport {
    @Resource
    private BidService bidService;
    @Resource
    private GoodsService goodsService;

    private Integer bidId;
    private float bidPrice;
    private Goods goods;

    public String doBid() {
        Goods good = goodsService.getGoodsById(goods.getId());
        Users buyer = (Users) ActionContext.getContext().getSession().get("users");
        Bid bid = new Bid();
        bid.setBidPrice(bidPrice);
        bid.setBidStatus(0);
        bid.setBidTime(new Date());
        bid.setBuyer(buyer);
        bid.setGoods(good);
        bidService.addBid(bid);
        return "index";
    }

    public String doDeal() {
        Bid bid = bidService.getBid(bidId);
        Goods good = bid.getGoods();
        Users buyer = bid.getBuyer();
        bid.setBidStatus(1);
        bidService.updateBid(bid);

        good.setGoodsStatus(1);
        good.setBuyer(buyer);
        goodsService.updateGoods(good);
        return "index";
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public float getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(float bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
