package com.example.auto_garage.service;

import com.example.auto_garage.exceptions.RecordNotFoundException;
import com.example.auto_garage.model.Reparings;
import com.example.auto_garage.repository.ReparingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
public class ReparingsService {

    @Autowired
    private ReparingsRepository reparingsRepository;


    public Collection<Reparings> getAllReparings() {
        return reparingsRepository.findAll();
    }


    public Optional<Reparings> getReparingsById(long id) {
        if (!reparingsRepository.existsById(id)) throw new RecordNotFoundException();
        return reparingsRepository.findById(id);
    }

    public long createReparings(Reparings reparings) {
        Reparings newReparings = reparingsRepository.save(reparings);
        return newReparings.getId();
    }

    public void updateReparings(long id, Reparings reparings) {
        if (!reparingsRepository.existsById(id)) throw new RecordNotFoundException();
        Reparings existingReparings = reparingsRepository.findById(id).get();
        existingReparings.setName(reparings.getName());
        existingReparings.setReparingPrice(reparings.getReparingPrice());
        reparingsRepository.save(existingReparings);
    }

    public void partialUpdateReparings(long id, Map<String, String> fields, Map<Double, Double> fields2) {
        if (!reparingsRepository.existsById(id)) throw new RecordNotFoundException();
        Reparings reparings = reparingsRepository.findById(id).get();
        for (String field : fields.keySet()) {
            switch (field.toLowerCase()) {
                case "name":
                    reparings.setName((String) fields.get(field));
                    break;
                case "price":
                    reparings.setReparingPrice((double) fields2.get(field));
                    break;
            }
        }
        reparingsRepository.save(reparings);
    }

    public void deleteReparingsById(long id) {
        if (!reparingsRepository.existsById(id)) throw new RecordNotFoundException();
        reparingsRepository.deleteById(id);
    }


}


