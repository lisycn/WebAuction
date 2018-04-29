package com.example.dao;


import com.example.entity.Bid;
import org.springframework.stereotype.Repository;

public interface BidDao {
	/**
	 * add bid
	 * 
	 * @param bid
	 */
	public void addBid(Bid bid);

	/**
	 * get bid by id
	 * 
	 * @param id
	 * @return
	 */
	public Bid getBid(Integer id);

	/**
	 * update bid
	 * 
	 * @param bid
	 */
	public void updateBid(Bid bid);
}
