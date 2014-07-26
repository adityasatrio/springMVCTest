/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asn.mensa.test.web.dao;

import com.asn.mensa.test.entities.Doctor;

/**
 *
 * @author AdityaSatrio
 */
public interface DoctorDao {
    public void saveOrUpdate(Doctor doctor);
    public Doctor findByDoctorName(String doctorName);
    
}
