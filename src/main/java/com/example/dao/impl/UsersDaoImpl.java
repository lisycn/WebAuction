package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.dao.UsersDao;
import com.example.entity.Goods;
import com.example.entity.Users;
import com.example.utils.ExampleUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "usersDao")
public class UsersDaoImpl implements UsersDao {
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
    public void addUsers(Users users) {
        // TODO Auto-generated method stub
        getSession().save(users);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Users> getUsers(Users users) {
        // TODO Auto-generated method stub
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Users> query = builder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        List<Predicate> predicateList = ExampleUtils.Example(builder, root, users);
        query.where(predicateList.toArray(new Predicate[predicateList.size()]));
        return getSession().createQuery(query).getResultList();
    }

    @Override
    public void updateUsers(Users users) {
        // TODO Auto-generated method stub
        getSession().update(users);
    }

}
