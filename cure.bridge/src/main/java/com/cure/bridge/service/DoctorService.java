package com.cure.bridge.service;

import com.cure.bridge.entity.Doctor;
import com.cure.bridge.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;



    public List<Doctor> listOfAllDoctor(){
        return (List<Doctor>) doctorRepo.findAll();
    }
}
