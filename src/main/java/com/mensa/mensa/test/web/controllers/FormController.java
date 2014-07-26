/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mensa.mensa.test.web.controllers;

import com.mensa.mensa.test.entities.Doctor;
import com.mensa.mensa.test.entities.Skp;
import com.mensa.mensa.test.web.domain.DoctorSkpForm;
import com.mensa.mensa.test.web.services.FormService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author AdityaSatrio
 */
@Controller
@RequestMapping(value = "/form")
public class FormController {

    @Autowired
    private FormService formService;

    @RequestMapping(value = "/addDoctorSkp", method = RequestMethod.GET)
    public String formMenu(Model model, DoctorSkpForm doctorSkpForm) {
        model.addAttribute("doctorSkpForm", doctorSkpForm);
        try {
            List<Skp> list =  formService.findAll();
            model.addAttribute("list", list);
            
        } catch (Exception ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "formAdd";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addform(HttpServletRequest request, HttpServletResponse response,
            Model model, @Valid @ModelAttribute("doctorSkpForm") DoctorSkpForm doctorSkpForm, BindingResult bindingResult) {

        Doctor doctor = new Doctor();
        List<Skp> list = new ArrayList<Skp>();
        try {
            if(bindingResult.hasErrors()){
                return "formAdd";
            }

            doctor.setNama(doctorSkpForm.getDoctorName());
            doctor.setNpaId(Integer.parseInt(doctorSkpForm.getNpaId()));
            doctor.setSpesialis(doctorSkpForm.getSpecialist());
            Skp skp = new Skp(doctor, doctorSkpForm.getActivityName(), Integer.parseInt(doctorSkpForm.getTotalSkp()));

            formService.save(doctor, skp);
            list = formService.findAll();
            model.addAttribute("list", list);
            clearSkpForm(doctorSkpForm);
            
        } catch (Exception ex) {
            Logger.getLogger(FormController.class.getName()).log(Level.SEVERE, null, ex);
            model.addAttribute("message", "data Failed to save . . . ");
        }
        
        model.addAttribute("message", "data sucessfully saved . . . ");
        model.addAttribute("list", list);
        model.addAttribute("doctorSkpForm", doctorSkpForm);
        return "formAdd";
    }

    private void clearSkpForm(DoctorSkpForm doctorSkpForm) {
        doctorSkpForm.setActivityName("");
        doctorSkpForm.setNpaId("");
    }

}
