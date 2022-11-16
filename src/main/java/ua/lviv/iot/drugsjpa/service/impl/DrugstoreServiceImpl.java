package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.Drugstore;
import ua.lviv.iot.drugsjpa.repository.DrugstoreRepository;
import ua.lviv.iot.drugsjpa.service.DrugstoreService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DrugstoreServiceImpl implements DrugstoreService {

    @Autowired
    private DrugstoreRepository drugstoreRepository;

    public Drugstore getById(Integer id) {
        return drugstoreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Drugstore> getAll() {
        return drugstoreRepository.findAll();
    }

    @Transactional
    public Drugstore create(Drugstore drugstore) {
        drugstoreRepository.save(drugstore);
        return drugstore;
    }

    @Transactional
    public Drugstore update(Integer id, Drugstore drugstore) {
        Drugstore newDrugstore = drugstoreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newDrugstore.setName(drugstore.getName());
        drugstoreRepository.save(newDrugstore);
        return newDrugstore;
    }

    @Transactional
    public void delete(Integer id) {
        Drugstore drugstore = drugstoreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        drugstoreRepository.delete(drugstore);
    }

    @Override
    public void createTenDrugstores(String name) {
        drugstoreRepository.createTenDrugstores(name);
    }
}
