package ua.lviv.iot.drugsjpa.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.drugsjpa.domain.Location;


public interface LocationService extends ServiceTemplate<Location, Integer>{
}
