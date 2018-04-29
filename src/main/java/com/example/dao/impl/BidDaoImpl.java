package com.example.dao.impl;

import com.example.dao.BidDao;
import com.example.entity.Bid;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository(value = "bidDao")
public class BidDaoImpl implements BidDao {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        Session session = null;
        try{
            session = sessionFactory.getCurrentSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    @Override
    public void addBid(Bid bid) {
        // TODO Auto-generated method stub
        getSession().save(bid);
    }

    @Override
    public Bid getBid(Integer id) {
        // TODO Auto-generated method stub
        return getSession().get(Bid.class, id);
    }

    @Override
    public void updateBid(Bid bid) {
        // TODO Auto-generated method stub
        getSession().update(bid);
    }

}
