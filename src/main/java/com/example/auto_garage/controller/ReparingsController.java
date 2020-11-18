package com.example.auto_garage.controller;


import com.example.auto_garage.model.Reparings;
import com.example.auto_garage.service.ReparingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RequestMapping("/reparings")

@RestController
@PreAuthorize("hasAnyRole('ADMIN','STOCK_MW')")
public class ReparingsController {


    @Autowired
    private ReparingsService reparingsService;

    // display list of Reparingss
    @GetMapping(value = "")
    @PreAuthorize("hasAnyRole('ADMIN','MONTEUR')")
    public ResponseEntity<Object> getReparings() {
        return ResponseEntity.ok().body(reparingsService.getAllReparings());
    }


    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MONTEUR')")
    public ResponseEntity<Object> getReparings(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(reparingsService.getReparingsById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createReparings(@RequestBody Reparings reparings) {
        long newId = reparingsService.createReparings(reparings);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateReparings(@PathVariable("id") long id, @RequestBody Reparings reparings) {
        reparingsService.updateReparings(id, reparings);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateReparingsreparingsial(@PathVariable("id") long id, @RequestBody Map<String, String> fields,Map<Double,Double>fields2) {
        reparingsService.partialUpdateReparings(id, fields,fields2);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteReparingsById(@PathVariable("id") long id) {
        reparingsService.deleteReparingsById(id);
        return ResponseEntity.noContent().build();
    }


}
