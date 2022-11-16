package ua.lviv.iot.drugsjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.drugsjpa.domain.CategoryOfDrug;

@Repository
public interface CategoryOfDrugRepository extends JpaRepository<CategoryOfDrug, Integer> {
}
