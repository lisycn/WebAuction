package com.example.service;

import com.example.entity.Goods;

import java.util.List;


public interface GoodsService {
    /**
     * add goods
     *
     * @param goods
     */
    public void addGoods(Goods goods);

    /**
     * get goods by id
     *
     * @param id
     * @return
     */
    public Goods getGoodsById(Integer id);

    /**
     * search goods
     *
     * @param goods
     * @return
     */
    public List<Goods> getGoods(Goods goods);

    /**
     * update goods
     *
     * @param goods
     */
    public void updateGoods(Goods goods);

}
