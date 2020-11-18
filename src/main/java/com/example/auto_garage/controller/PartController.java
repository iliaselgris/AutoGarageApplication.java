package com.example.auto_garage.controller;


import com.example.auto_garage.model.Part;
import com.example.auto_garage.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RequestMapping("/parts")

@RestController
@PreAuthorize("hasAnyRole('ADMIN','STOCK_MW')")
public class PartController {


    @Autowired
    private PartService partService;

    // display list of Parts
    @GetMapping(value = "")
    @PreAuthorize("hasAnyRole('ADMIN','MONTEUR')")
    public ResponseEntity<Object> getParts() {
        return ResponseEntity.ok().body(partService.getAllParts());
    }


    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MONTEUR')")
    public ResponseEntity<Object> getPart(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(partService.getPartById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createPart(@RequestBody Part part) {
        long newId = partService.createPart(part);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updatePart(@PathVariable("id") long id, @RequestBody Part part) {
        partService.updatePart(id, part);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updatePartPartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields, Map<Double, Double> fields2) {
        partService.partialUpdatePart(id, fields, fields2);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePartById(@PathVariable("id") long id) {
        partService.deletePartById(id);
        return ResponseEntity.noContent().build();
    }


}
