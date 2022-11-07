package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.CategoryOfDrug;
import ua.lviv.iot.drugsjpa.repository.CategoryOfDrugRepository;
import ua.lviv.iot.drugsjpa.service.CategoryOfDrugService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryOfDrugServiceImpl implements CategoryOfDrugService {

    @Autowired
    private CategoryOfDrugRepository categoryOfDrugRepository;

    public CategoryOfDrug getById(Integer id) {
        return categoryOfDrugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<CategoryOfDrug> getAll() {
        return categoryOfDrugRepository.findAll();
    }

    @Transactional
    public CategoryOfDrug create(CategoryOfDrug categoryOfDrug) {
        categoryOfDrugRepository.save(categoryOfDrug);
        return categoryOfDrug;
    }

    @Transactional
    public CategoryOfDrug update(Integer id, CategoryOfDrug categoryOfDrug) {
        CategoryOfDrug newCategoryOfDrug = categoryOfDrugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newCategoryOfDrug.setRequiredPrescription(categoryOfDrug.isRequiredPrescription());
        newCategoryOfDrug.setType(categoryOfDrug.getType());
        newCategoryOfDrug.setDrugId(categoryOfDrug.getDrugId());
        categoryOfDrugRepository.save(newCategoryOfDrug);
        return newCategoryOfDrug;
    }

    @Transactional
    public void delete(Integer id) {
        CategoryOfDrug categoryOfDrug = categoryOfDrugRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        categoryOfDrugRepository.delete(categoryOfDrug);
    }
}
