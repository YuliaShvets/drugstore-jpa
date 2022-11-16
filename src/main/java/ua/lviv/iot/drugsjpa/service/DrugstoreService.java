package ua.lviv.iot.drugsjpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.drugsjpa.domain.Drugstore;

public interface DrugstoreService extends ServiceTemplate<Drugstore, Integer>{

    void createTenDrugstores(String name);
}
