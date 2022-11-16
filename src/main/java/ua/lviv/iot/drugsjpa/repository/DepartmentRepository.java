package ua.lviv.iot.drugsjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.drugsjpa.domain.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    @Procedure("add_new_db")
    void createDB();
}
