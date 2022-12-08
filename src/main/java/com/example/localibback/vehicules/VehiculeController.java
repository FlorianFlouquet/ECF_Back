package com.example.localibback.vehicules;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicules")
public class VehiculeController {
    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping("")
    public List<Vehicule> findAll() {
        return vehiculeService.findAll();
    }

    @PostMapping("")
    public Vehicule save(@RequestBody Vehicule entity) {
        return vehiculeService.save(entity);
    }

    @GetMapping("{id}")
    public Vehicule findById(@PathVariable String id) {
        return vehiculeService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        vehiculeService.deleteById(id);
    }
}
