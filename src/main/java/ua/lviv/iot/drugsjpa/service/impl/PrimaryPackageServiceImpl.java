package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.City;
import ua.lviv.iot.drugsjpa.domain.PrimaryPackage;
import ua.lviv.iot.drugsjpa.repository.PrimaryPackageRepository;
import ua.lviv.iot.drugsjpa.service.PrimaryPackageService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PrimaryPackageServiceImpl implements PrimaryPackageService {

    @Autowired
    private PrimaryPackageRepository primaryPackageRepository;

    public PrimaryPackage getById(Integer id) {
        return primaryPackageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<PrimaryPackage> getAll() {
        return primaryPackageRepository.findAll();
    }

    @Transactional
    public PrimaryPackage create(PrimaryPackage primaryPackage) {
        primaryPackageRepository.save(primaryPackage);
        return primaryPackage;
    }

    @Transactional
    public PrimaryPackage update(Integer id, PrimaryPackage primaryPackage) {
        PrimaryPackage newPrimaryPackage = primaryPackageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newPrimaryPackage.setTypePackaging(primaryPackage.getTypePackaging());
        newPrimaryPackage.setDrugId(primaryPackage.getDrugId());
        primaryPackageRepository.save(newPrimaryPackage);
        return newPrimaryPackage;
    }

    @Transactional
    public void delete(Integer id) {
        PrimaryPackage primaryPackage = primaryPackageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        primaryPackageRepository.delete(primaryPackage);
    }

}
