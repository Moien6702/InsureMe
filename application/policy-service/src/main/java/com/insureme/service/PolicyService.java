package com.insureme.service;

import com.insureme.model.Policy;
import com.insureme.repository.PolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {
    private final PolicyRepository repo;

    public PolicyService(PolicyRepository repo) {
        this.repo = repo;
    }

    public Policy create(Policy p) { return repo.save(p); }

    public Policy update(Long id, Policy p) {
        p.setId(id);
        return repo.save(p);
    }

    public Optional<Policy> get(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Policy> getAll() {
        return repo.findAll();
    }
}
