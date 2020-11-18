package com.example.auto_garage.service;


import com.example.auto_garage.exceptions.RecordNotFoundException;
import com.example.auto_garage.model.Auto;
import com.example.auto_garage.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
public class AutoService  {

    @Autowired
private AutoRepository autoRepository;


        public Collection<Auto> getAllAutos() {
            return autoRepository.findAll();
        }



        public Optional<Auto> getAutoById(long id) {
            if (!autoRepository.existsById(id)) throw new RecordNotFoundException();
            return autoRepository.findById(id);
        }

        public long createAuto(Auto auto) {
            Auto newAuto = autoRepository.save(auto);
            return newAuto.getId();
        }
        public void updateAuto(long id, Auto auto) {
            if (!autoRepository.existsById(id)) throw new RecordNotFoundException();
            Auto existingAuto = autoRepository.findById(id).get();
            existingAuto.setPlate(auto.getPlate());
            existingAuto.setBrand(auto.getBrand());
            existingAuto.setModel(auto.getModel());
            existingAuto.setBuildYear(auto.getBuildYear());
            existingAuto.setKiloStand(auto.getKiloStand());
            autoRepository.save(existingAuto);
        }

        public void partialUpdateAuto(long id, Map<String, String> fields) {
            if (!autoRepository.existsById(id)) throw new RecordNotFoundException();
            Auto auto = autoRepository.findById(id).get();
            for (String field : fields.keySet()) {
                switch (field.toLowerCase()) {
                    case "plate":
                        auto.setPlate((String) fields.get(field));
                        break;
                    case "brand":
                        auto.setBrand((String) fields.get(field));
                        break;
                    case "model":
                        auto.setModel((String) fields.get(field));
                        break;
                    case "buildYear":
                        auto.setBuildYear((String) fields.get(field));
                        break;
                    case "kiliStand":
                        auto.setKiloStand((String) fields.get(field));
                        break;
                }
            }
            autoRepository.save(auto);
        }

        public void deleteAutoById(long id) {
            if (!autoRepository.existsById(id)) throw new RecordNotFoundException();
            autoRepository.deleteById(id);
        }



}

