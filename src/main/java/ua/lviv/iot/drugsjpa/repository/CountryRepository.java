package ua.lviv.iot.drugsjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.drugsjpa.domain.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    @Procedure("add_country")
    void createEntity(String name);
}
