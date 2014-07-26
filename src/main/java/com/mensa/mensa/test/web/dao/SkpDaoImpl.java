/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mensa.mensa.test.web.dao;

import com.mensa.mensa.test.entities.Skp;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AdityaSatrio
 */
@Repository
public class SkpDaoImpl implements SkpDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            System.out.println("get current session");
        } catch (HibernateException he) {
            session = sessionFactory.openSession();
            System.out.println("get current session");
        }
        return session;
    }

    @Override
    public void saveOrUpdate(Skp skp) {
        getCurrentSession().saveOrUpdate(skp);
    }

    @Override
    public List<Skp> findAll() {
        Criteria criteria = getCurrentSession().createCriteria(Skp.class);
        criteria.add(Restrictions.isNotNull("namaKegiatan"));
        return criteria.list();
    }
}
