package com.insureme.controller;

import com.insureme.model.Policy;
import com.insureme.service.PolicyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policy")
public class PolicyController {

    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Policy create(@RequestBody Policy policy) {
        return service.create(policy);
    }

    @PutMapping("/update/{id}")
    public Policy update(@PathVariable Long id, @RequestBody Policy policy) {
        return service.update(id, policy);
    }

    @GetMapping("/view/{id}")
    public Policy get(@PathVariable Long id) {
        return service.get(id).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/all")
    public List<Policy> getAll() {
        return service.getAll();
    }
}
