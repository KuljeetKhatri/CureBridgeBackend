package com.cure.bridge.controller;

import com.cure.bridge.dto.AppointmentDTO;
import com.cure.bridge.entity.*;
import com.cure.bridge.repo.AppointmentRepo;
import com.cure.bridge.repo.DoctorRepo;
import com.cure.bridge.repo.PatientRepo;
import com.cure.bridge.repo.UserRepo;
import com.cure.bridge.response.Response;
import com.cure.bridge.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Autowired
    private AppointmentRepo appointmentRepository;

    @Autowired
    private DoctorRepo doctorRepository;

    @Autowired
    private PatientRepo patientRepository;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/createappointment")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Response response = new Response();
        try {
            // Fetch Doctor and Patient via User IDs
            User doctorUser = userRepo.findById(Long.parseLong(appointmentDTO.getDoctorId()))
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            User patientUser = userRepo.findById(Long.parseLong(appointmentDTO.getPatientId()))
                    .orElseThrow(() -> new RuntimeException("Patient not found"));

            Doctor doctor = doctorRepository.findByUserId(Long.parseLong(appointmentDTO.getDoctorId()));
            Patient patient = patientRepository.findByUserId(Long.parseLong(appointmentDTO.getPatientId()));

            if (doctor == null || patient == null) {
                throw new RuntimeException("Doctor or Patient not found");
            }

            // Create and save appointment
            Appointment appointment = new Appointment();
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            String isoDate = appointmentDTO.getAppointmentDate();
            Instant instant = Instant.parse(isoDate);
            Timestamp timestamp = Timestamp.from(instant);
            appointment.setAppointmentDate(timestamp);
            appointment.setStatus(AppointmentStatus.SCHEDULED);

            Appointment savedAppointment = appointmentRepository.save(appointment);

            // Manually construct the response data
            Map<String, Object> appointmentData = new HashMap<>();
            appointmentData.put("id", savedAppointment.getId());
            appointmentData.put("appointmentDate", savedAppointment.getAppointmentDate().toString());
            appointmentData.put("createdAt", savedAppointment.getCreatedAt() != null ? savedAppointment.getCreatedAt().toString() : null);
            appointmentData.put("status", savedAppointment.getStatus().toString());

            // Include doctor details
            Map<String, Object> doctorData = new HashMap<>();
            doctorData.put("user", Map.of("fullName", doctor.getUser().getFullName()));
            doctorData.put("specialization", doctor.getSpecialization());
            appointmentData.put("doctor", doctorData);

            Map<String, Object> data = new HashMap<>();
            data.put("appointment", appointmentData);

            // Set response
            response.setResponseCode(Constants.SUCCESS_CODE); // Assuming "00"
            response.setResponseMessage("Appointment created successfully");
            response.setMapData(data); // Use mapData to match Response class structure

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setResponseCode("01");
            response.setResponseMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}