/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mensa.mensa.test.web.domain;

import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author AdityaSatrio
 */
public class DoctorSkpForm {

    
    private String doctorName;
    private String npaId;
    private String specialist;
    private String activityName;
    private String totalSkp;

    public DoctorSkpForm() {
    }

    @NotEmpty
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @NotEmpty
    public String getNpaId() {
        return npaId;
    }

    public void setNpaId(String npaId) {
        this.npaId = npaId;
    }

    @NotEmpty
    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getTotalSkp() {
        return totalSkp;
    }

    public void setTotalSkp(String totalSkp) {
        this.totalSkp = totalSkp;
    }
}
