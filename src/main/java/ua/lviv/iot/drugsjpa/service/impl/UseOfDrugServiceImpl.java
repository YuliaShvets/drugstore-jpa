package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.UseOfDrug;
import ua.lviv.iot.drugsjpa.repository.UseOfDrugRepository;
import ua.lviv.iot.drugsjpa.service.UseOfDrugService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UseOfDrugServiceImpl implements UseOfDrugService {

    @Autowired
    private UseOfDrugRepository useOfDrugRepository;

    public UseOfDrug getById(Integer id) {
        return useOfDrugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<UseOfDrug> getAll() {
        return useOfDrugRepository.findAll();
    }

    @Transactional
    public UseOfDrug create(UseOfDrug useOfDrug) {
        useOfDrugRepository.save(useOfDrug);
        return useOfDrug;
    }

    @Transactional
    public UseOfDrug update(Integer id, UseOfDrug useOfDrug) {
        UseOfDrug newUseOfDrug = useOfDrugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newUseOfDrug.setUseType(useOfDrug.getUseType());
        newUseOfDrug.setDrugId(useOfDrug.getDrugId());
        useOfDrugRepository.save(newUseOfDrug);
        return newUseOfDrug;
    }

    @Transactional
    public void delete(Integer id) {
        UseOfDrug useOfDrug = useOfDrugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        useOfDrugRepository.delete(useOfDrug);
    }

}
