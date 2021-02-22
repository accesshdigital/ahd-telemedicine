package com.example.demo.controller;



import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Vital;
import com.example.demo.repo.VitalRepository;

@RestController
@RequestMapping("/api/v1/vital")
public class VitalController {  
    private final VitalRepository vitalRepository;

    @Autowired
    public VitalController(VitalRepository vitalRepository) {
        this.vitalRepository = vitalRepository;
    }

    @PostMapping
    public ResponseEntity<Vital> create(@Valid @RequestBody Vital vital) {
    	Vital savedVital = vitalRepository.save(vital);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(savedVital.getId()).toUri();

        return ResponseEntity.created(location).body(savedVital);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vital> update(@PathVariable Integer id, @Valid @RequestBody Vital vital) {
        Optional<Vital> optionalVital = vitalRepository.findById(id);
        if (!optionalVital.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        vital.setId(optionalVital.get().getId());
        vitalRepository.save(vital);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vital> delete(@PathVariable Integer id) {
        Optional<Vital> optionalVital = vitalRepository.findById(id);
        if (!optionalVital.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        vitalRepository.delete(optionalVital.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vital> getById(@PathVariable Integer id) {
        Optional<Vital> optionalVital = vitalRepository.findById(id);
        if (!optionalVital.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalVital.get());
    }

    @GetMapping
    public ResponseEntity<Page<Vital>> getAll(Pageable pageable) {
        return ResponseEntity.ok(vitalRepository.findAll(pageable));
    }
}
