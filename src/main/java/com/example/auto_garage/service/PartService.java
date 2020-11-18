package com.example.auto_garage.service;

import com.example.auto_garage.exceptions.RecordNotFoundException;
import com.example.auto_garage.model.Part;
import com.example.auto_garage.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
public class PartService {

    @Autowired
    private PartRepository partRepository;


    public Collection<Part> getAllParts() {
        return partRepository.findAll();
    }


    public Optional<Part> getPartById(long id) {
        if (!partRepository.existsById(id)) throw new RecordNotFoundException();
        return partRepository.findById(id);
    }

    public long createPart(Part part) {
        Part newPart = partRepository.save(part);
        return newPart.getId();
    }

    public void updatePart(long id, Part part) {
        if (!partRepository.existsById(id)) throw new RecordNotFoundException();
        Part existingPart = partRepository.findById(id).get();
        existingPart.setName(part.getName());
        existingPart.setPrice(part.getPrice());
        partRepository.save(existingPart);
    }

    public void partialUpdatePart(long id, Map<String, String> fields, Map<Double, Double> fields2) {
        if (!partRepository.existsById(id)) throw new RecordNotFoundException();
        Part part = partRepository.findById(id).get();
        for (String field : fields.keySet()) {
            switch (field.toLowerCase()) {
                case "name":
                    part.setName((String) fields.get(field));
                    break;
                case "price":
                    part.setPrice((double) fields2.get(field));
                    break;
            }
        }
        partRepository.save(part);
    }

    public void deletePartById(long id) {
        if (!partRepository.existsById(id)) throw new RecordNotFoundException();
        partRepository.deleteById(id);
    }


}

