/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asn.mensa.test.web.services;

import com.asn.mensa.test.entities.Doctor;
import com.asn.mensa.test.entities.Skp;
import java.util.List;

/**
 *
 * @author AdityaSatrio
 */
public interface FormService {

    public boolean save(Doctor doctor, Skp skp) throws Exception;
    public List<Skp> findAll() throws Exception;
    public Doctor findByDoctorName(String doctorName) throws Exception;;
}
