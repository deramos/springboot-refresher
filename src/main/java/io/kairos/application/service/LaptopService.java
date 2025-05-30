package io.kairos.application.service;

import io.kairos.application.model.Laptop;
import io.kairos.application.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop laptop) {
        repo.save(laptop);
    }

    public boolean isGoodForProgramming(Laptop laptop) {
        return true;
    }
}
