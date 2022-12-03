package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.Country;
import ua.lviv.iot.drugsjpa.repository.CountryRepository;
import ua.lviv.iot.drugsjpa.service.CountryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getById(String id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country create(Country country) {
        countryRepository.save(country);
        return country;
    }

    @Transactional
    public Country update(String id, Country country) {
        Country newCountry = countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newCountry.setName(country.getName());
        countryRepository.save(newCountry);
        return newCountry;
    }

    @Transactional
    public void delete(String id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        countryRepository.delete(country);
    }

    @Override
    public void createEntity(String name) {
        countryRepository.createEntity(name);
    }
}
