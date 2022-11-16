package ua.lviv.iot.drugsjpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.drugsjpa.domain.Department;

public interface DepartmentService extends ServiceTemplate<Department, Integer> {
}
