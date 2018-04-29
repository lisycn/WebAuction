package com.example.service.impl;

import com.example.dao.BidDao;
import com.example.dao.GoodsDao;
import com.example.dao.UsersDao;
import com.example.entity.Goods;
import com.example.entity.Users;
import com.example.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service(value = "goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Override
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    @Override
    public Goods getGoodsById(Integer id) {
        return goodsDao.getGoodsById(id);
    }

    @Override
    public List<Goods> getGoods(Goods goods) {
        return goodsDao.getGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }
}
