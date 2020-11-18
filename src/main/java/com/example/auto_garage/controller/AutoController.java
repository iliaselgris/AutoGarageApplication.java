package com.example.auto_garage.controller;


import com.example.auto_garage.model.Auto;
import com.example.auto_garage.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RequestMapping("/autos")

@RestController
@PreAuthorize("hasAnyRole('ADMIN','FRONTDESK')")
public class AutoController {


    @Autowired
    private AutoService autoService;

    // display list of Autos
    @GetMapping(value = "")
    public ResponseEntity<Object> getautos() {
        return ResponseEntity.ok().body(autoService.getAllAutos());
    }


    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','FRONTDESK','MONTEUR')")
    public ResponseEntity<Object> getAuto(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(autoService.getAutoById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createAuto(@RequestBody Auto auto) {
        long newId = autoService.createAuto(auto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateAuto(@PathVariable("id") long id, @RequestBody Auto auto) {
        autoService.updateAuto(id, auto);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateAutoPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        autoService.partialUpdateAuto(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteAutoById(@PathVariable("id") long id) {
        autoService.deleteAutoById(id);
        return ResponseEntity.noContent().build();
    }


}
