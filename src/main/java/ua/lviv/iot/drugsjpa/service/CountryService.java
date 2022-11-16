package ua.lviv.iot.drugsjpa.service;

import ua.lviv.iot.drugsjpa.domain.Country;

public interface CountryService extends ServiceTemplate<Country, String> {

    void createEntity(String name);

}
