package ua.lviv.iot.drugsjpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.drugsjpa.domain.Drug;


public interface DrugService extends ServiceTemplate<Drug, Integer>{
}
