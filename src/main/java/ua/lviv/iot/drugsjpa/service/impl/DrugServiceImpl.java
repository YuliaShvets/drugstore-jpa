package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.Drug;
import ua.lviv.iot.drugsjpa.repository.DrugRepository;
import ua.lviv.iot.drugsjpa.service.DrugService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugRepository drugRepository;

    public Drug getById(Integer id) {
        return drugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Drug> getAll() {
        return drugRepository.findAll();
    }

    @Transactional
    public Drug create(Drug drug) {
        drugRepository.save(drug);
        return drug;
    }

    @Transactional
    public Drug update(Integer id, Drug drug) {
        Drug newDrug = drugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newDrug.setName(drug.getName());
        newDrug.setProductionDate(drug.getProductionDate());
        newDrug.setExpirationDate(drug.getExpirationDate());
        newDrug.setAvailable(drug.isAvailable());
        newDrug.setPriceInDollars(drug.getPriceInDollars());
        newDrug.setProducerId(drug.getProducerId());
        newDrug.setDrugstoreId(drug.getDrugstoreId());
        drugRepository.save(newDrug);
        return newDrug;
    }

    @Transactional
    public void delete(Integer id) {
        Drug drug = drugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        drugRepository.delete(drug);
    }

}
