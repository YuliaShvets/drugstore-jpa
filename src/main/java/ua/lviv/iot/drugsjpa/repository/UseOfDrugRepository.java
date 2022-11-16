package ua.lviv.iot.drugsjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.drugsjpa.domain.UseOfDrug;

@Repository
public interface UseOfDrugRepository extends JpaRepository<UseOfDrug, Integer> {
}
