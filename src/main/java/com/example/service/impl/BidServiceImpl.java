package com.example.service.impl;

import com.example.dao.BidDao;
import com.example.entity.Bid;
import com.example.service.BidService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "bidService")
public class BidServiceImpl implements BidService {
    @Resource
    private BidDao bidDao;

    @Override
    public void addBid(Bid bid) {
        bidDao.addBid(bid);
    }

    @Override
    public Bid getBid(Integer id) {
        return bidDao.getBid(id);
    }

    @Override
    public void updateBid(Bid bid) {
        bidDao.updateBid(bid);
    }
}
