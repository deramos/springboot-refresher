package io.kairos.application.repository;

import io.kairos.application.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {

    public void save(Laptop laptop) {
        System.out.println("Saved in database...");
    }
}
