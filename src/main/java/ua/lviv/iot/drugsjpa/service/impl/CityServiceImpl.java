package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.City;
import ua.lviv.iot.drugsjpa.repository.CityRepository;
import ua.lviv.iot.drugsjpa.service.CityService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    public City getById(Integer id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Transactional
    public City create(City city) {
        cityRepository.save(city);
        return city;
    }

    @Transactional
    public City update(Integer id, City city) {
        City newCity = cityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newCity.setName(city.getName());
        newCity.setCountryName(city.getCountryName());
        cityRepository.save(newCity);
        return newCity;
    }

    @Transactional
    public void delete(Integer id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        cityRepository.delete(city);
    }

}
