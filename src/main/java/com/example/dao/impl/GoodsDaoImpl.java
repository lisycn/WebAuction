package com.example.dao.impl;

import com.example.dao.GoodsDao;
import com.example.entity.Goods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "goodsDao")
public class GoodsDaoImpl implements GoodsDao {

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
    public void addGoods(Goods goods) {
        // TODO Auto-generated method stub
        getSession().save(goods);
    }

    @Override
    public Goods getGoodsById(Integer id) {
        // TODO Auto-generated method stub
        return getSession().get(Goods.class, id);
    }

    @SuppressWarnings({"unlikely-arg-type", "unchecked"})
    @Override
    public List<Goods> getGoods(Goods goods) {
        // TODO Auto-generated method stub
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Goods> query = builder.createQuery(Goods.class);
        Root<Goods> root = query.from(Goods.class);
        List<Predicate> predicateList = new ArrayList<>();
        if (goods.getGoodsStatus()!=null){
            predicateList.add(builder.equal(root.get("goodsStatus"), goods.getGoodsStatus()));
        }
        if (goods.getSeller() != null) {
            predicateList.add(builder.equal(root.get("seller"), goods.getSeller()));
        }
		Predicate[] p = new Predicate[predicateList.size()];
        query.where(predicateList.toArray(p));
        return getSession().createQuery(query).getResultList();
    }

    @Override
    public void updateGoods(Goods goods) {
        // TODO Auto-generated method stub
        getSession().update(goods);
    }

}
