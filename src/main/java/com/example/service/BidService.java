package com.example.service;

import com.example.entity.Bid;
import org.springframework.stereotype.Service;

public interface BidService {
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
