/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asn.smvc.test.web.dao;

import com.asn.smvc.test.entities.Doctor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AdityaSatrio
 */
//public class DoctorDaoImpl extends BaseAbstractDao<Doctor, String> implements DoctorDao {
@Repository
public class DoctorDaoImpl implements DoctorDao {

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
    public void saveOrUpdate(Doctor doctor) {
        getCurrentSession().saveOrUpdate(doctor);
    }

    @Override
    public Doctor findByDoctorName(String doctorName) {
        Criteria criteria = getCurrentSession().createCriteria(Doctor.class);
        criteria.add(Restrictions.like("nama", doctorName, MatchMode.START));
        return (Doctor) criteria.uniqueResult();
    }
}
