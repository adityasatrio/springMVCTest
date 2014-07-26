/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asn.mensa.test.web.dao;

import com.asn.mensa.test.entities.Skp;
import java.util.List;

/**
 *
 * @author AdityaSatrio
 */
public interface SkpDao {
    public void saveOrUpdate(Skp skp);
    public List<Skp> findAll();
}
