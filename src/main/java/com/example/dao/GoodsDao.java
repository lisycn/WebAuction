package com.example.dao;

import com.example.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GoodsDao {
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
