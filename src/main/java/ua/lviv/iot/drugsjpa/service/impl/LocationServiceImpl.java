package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.City;
import ua.lviv.iot.drugsjpa.domain.Location;
import ua.lviv.iot.drugsjpa.repository.CityRepository;
import ua.lviv.iot.drugsjpa.repository.LocationRepository;
import ua.lviv.iot.drugsjpa.service.LocationService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location getById(Integer id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Transactional
    public Location create(Location location) {
        locationRepository.save(location);
        return location;
    }

    @Transactional
    public Location update(Integer id, Location location) {
        Location newLocation = locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newLocation.setStreet(location.getStreet());
        newLocation.setDepartmentId(location.getDepartmentId());
        newLocation.setCityId(location.getCityId());
        locationRepository.save(newLocation);
        return newLocation;
    }

    @Transactional
    public void delete(Integer id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        locationRepository.delete(location);
    }
}
