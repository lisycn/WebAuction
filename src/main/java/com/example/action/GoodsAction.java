package com.example.action;

import com.example.entity.Goods;
import com.example.entity.Users;
import com.example.service.GoodsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@Scope("prototype")
public class GoodsAction extends ActionSupport {
    @Resource
    private GoodsService goodsService;

    private Goods goods;
    private File goodsImage;
    private String fileName;

    /**
     * show all goods on sell
     * @return goods list
     */
    public String showOnSellGoods() {
        Goods good = new Goods();
        good.setGoodsStatus(0);
        List<Goods> goodsList = goodsService.getGoods(good);
        ServletActionContext.getRequest().setAttribute("onSellGoodsList", goodsList);
        return "goodsList";
    }

    /**
     * show my goods
     * @return my goods
     */
    public String showMyGoods() {
        Goods good = new Goods();
        Users seller = (Users) ActionContext.getContext().getSession().get("users");
        good.setSeller(seller);
//        good.setGoodsStatus(0);
        List<Goods> goodsList = goodsService.getGoods(good);
        ServletActionContext.getRequest().setAttribute("myGoodsList", goodsList);
        return "myGoodsList";
    }

    /**
     * add goods
     * @return index
     */
    public String addGoods(){
        String imgDirectory = ServletActionContext.getServletContext().getRealPath("/uploadImages");
        String imgName = rename(fileName);
        File img = new File(imgDirectory, imgName);
        try {
            FileUtils.copyFile(goodsImage, img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        goods.setGoodsPic(imgName);
        Users seller = (Users) ActionContext.getContext().getSession().get("users");
        goods.setSeller(seller);
        goods.setBuyer(seller);
        goods.setGoodsStatus(0);
        goodsService.addGoods(goods);
        return "index";
    }

    /**
     * bid on goods
     * @return goodsBid
     */
    public String doBid(){
        Goods good = goodsService.getGoodsById(goods.getId());
        ServletActionContext.getRequest().setAttribute("goodsBid", good);
        return "goodsBid";
    }

    /**
     * Rename file
     * @param fileName file name
     * @return new file name
     */
    private String rename(String fileName) {
        System.out.println(fileName);
        String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        int random = new Random().nextInt(10000);
        String extension = fileName.substring(fileName.lastIndexOf("."));
        return formatDate + random + extension;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public File getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(File goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsImageFileName() {
        return fileName;
    }

    public void setGoodsImageFileName(String fileName) {
        this.fileName = fileName;
    }
}
