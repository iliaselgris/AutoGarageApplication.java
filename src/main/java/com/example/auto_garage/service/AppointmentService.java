package com.example.auto_garage.service;

import com.example.auto_garage.exceptions.RecordNotFoundException;
import com.example.auto_garage.model.Appointment;
import com.example.auto_garage.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
public class AppointmentService  {

    @Autowired
    private AppointmentRepository appointmentRepository;


    public Collection<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }



    public Optional<Appointment> getAppointmentById(long id) {
        if (!appointmentRepository.existsById(id)) throw new RecordNotFoundException();
        return appointmentRepository.findById(id);
    }

    public long createAppointment(Appointment appointment) {
        Appointment newAppointment = appointmentRepository.save(appointment);
        return newAppointment.getId();
    }
    public void updateAppointment(long id, Appointment appointment) {
        if (!appointmentRepository.existsById(id)) throw new RecordNotFoundException();
        Appointment existingAppointment = appointmentRepository.findById(id).get();
        existingAppointment.setExamination(appointment.getExamination());
        existingAppointment.setAppointment2(appointment.getAppointment2());
        appointmentRepository.save(existingAppointment);
    }

    public void partialUpdateAppointment(long id, Map<String, String> fields) {
        if (!appointmentRepository.existsById(id)) throw new RecordNotFoundException();
        Appointment appointment = appointmentRepository.findById(id).get();
        for (String field : fields.keySet()) {
            switch (field.toLowerCase()) {
                case "examination":
                    appointment.setExamination((String) fields.get(field));
                    break;
                case "appointment2":
                    appointment.setAppointment2((String) fields.get(field));
                    break;
            }
        }
        appointmentRepository.save(appointment);
    }

    public void deleteAppointmentById(long id) {
        if (!appointmentRepository.existsById(id)) throw new RecordNotFoundException();
        appointmentRepository.deleteById(id);
    }



}


