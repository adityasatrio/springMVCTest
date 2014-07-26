/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asn.mensa.test.web.services;

import com.asn.mensa.test.entities.Doctor;
import com.asn.mensa.test.entities.Skp;
import com.asn.mensa.test.web.dao.DoctorDao;
import com.asn.mensa.test.web.dao.SkpDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AdityaSatrio
 */
@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private SkpDao skpDao;

    @Override
    public boolean save(Doctor doctor, Skp skp) throws Exception {

        //asume doctor name cant be the same
        Doctor existingDoctor = doctorDao.findByDoctorName(doctor.getNama().toLowerCase());
        if (existingDoctor != null) {
            skp.setDoctor(existingDoctor);
            skpDao.saveOrUpdate(skp);
        } else {
            doctorDao.saveOrUpdate(doctor);
            skp.setDoctor(doctor);
            skpDao.saveOrUpdate(skp);
        }

        return true;
    }

    @Override
    public List<Skp> findAll() throws Exception {
        List<Skp> list = skpDao.findAll();
        System.out.println("list " + list);

        List<Skp> skpList = new ArrayList<Skp>();
        Integer i = 1;
        for (Skp skp : list) {
            Skp newSkp = new Skp();
            newSkp.setId(i);
            newSkp.setNamaKegiatan(skp.getNamaKegiatan());
            newSkp.setJumlahSkp(skp.getJumlahSkp());
            skpList.add(newSkp);
            i++;
        }

        return skpList;
    }

    @Override
    public Doctor findByDoctorName(String doctorName) throws Exception {
        return doctorDao.findByDoctorName(doctorName);
    }
}
