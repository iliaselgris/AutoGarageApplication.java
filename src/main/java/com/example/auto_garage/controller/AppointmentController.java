package com.example.auto_garage.controller;


import com.example.auto_garage.model.Appointment;
import com.example.auto_garage.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RequestMapping("/appointment")

@RestController
@PreAuthorize("hasAnyRole('ADMIN','FRONTDESK')")
public class AppointmentController {


    @Autowired
    private AppointmentService appointmentService;

    // display list of Appointments
    @PreAuthorize("hasAnyRole('ADMIN','FRONTDESK','MONTEUR')")
    @GetMapping(value = "")
    public ResponseEntity<Object> getappointments() {
        return ResponseEntity.ok().body(appointmentService.getAllAppointments());
    }

    @PreAuthorize("hasAnyRole('ADMIN','FRONTDESK','MONTEUR')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getAppointment(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(appointmentService.getAppointmentById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createAppointment(@RequestBody Appointment appointment) {
        long newId = appointmentService.createAppointment(appointment);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateAppointment(@PathVariable("id") long id, @RequestBody Appointment appointment) {
        appointmentService.updateAppointment(id, appointment);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateAppointmentPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        appointmentService.partialUpdateAppointment(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteAppointmentById(@PathVariable("id") long id) {
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.noContent().build();
    }


}
