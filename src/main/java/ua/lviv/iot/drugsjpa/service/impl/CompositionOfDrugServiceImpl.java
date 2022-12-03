package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.CompositionOfDrug;
import ua.lviv.iot.drugsjpa.repository.CompositionOfDrugRepository;
import ua.lviv.iot.drugsjpa.service.CompositionOfDrugService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompositionOfDrugServiceImpl implements CompositionOfDrugService {

    @Autowired
    private CompositionOfDrugRepository compositionOfDrugRepository;

    public List<CompositionOfDrug> getAll() {
        return compositionOfDrugRepository.findAll();
    }

    public CompositionOfDrug getById(Integer id) {
        return compositionOfDrugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public CompositionOfDrug create(CompositionOfDrug compositionOfDrug) {
        compositionOfDrugRepository.save(compositionOfDrug);
        return compositionOfDrug;
    }

    @Transactional
    public CompositionOfDrug update(Integer id, CompositionOfDrug compositionOfDrug) {
        CompositionOfDrug newCompositionOfDrug = compositionOfDrugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newCompositionOfDrug.setActiveIngredients(compositionOfDrug.getActiveIngredients());
        newCompositionOfDrug.setDrugId(compositionOfDrug.getDrugId());
        compositionOfDrugRepository.save(newCompositionOfDrug);
        return newCompositionOfDrug;
    }

    @Transactional
    public void delete(Integer id) {
        CompositionOfDrug compositionOfDrug = compositionOfDrugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        compositionOfDrugRepository.delete(compositionOfDrug);
    }
}
