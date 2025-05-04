package com.cure.bridge.controller;

import com.cure.bridge.entity.Doctor;
import com.cure.bridge.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping("/getalldoctor")
    public List<Doctor> getAllDoctor() throws Exception{
        List<Doctor> doctorList = new ArrayList<>();
        try{
            doctorList = doctorService.listOfAllDoctor();
        }catch (Exception e){
            e.printStackTrace();
        }
        return doctorList;
    }
}

