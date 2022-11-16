package ua.lviv.iot.drugsjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.drugsjpa.domain.Drugstore;

@Repository
public interface DrugstoreRepository  extends JpaRepository<Drugstore, Integer> {

    @Procedure("add_ten_drugstores")
    void createTenDrugstores(String name);
}
