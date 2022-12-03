package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.Producer;
import ua.lviv.iot.drugsjpa.repository.ProducerRepository;
import ua.lviv.iot.drugsjpa.service.ProducerService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    public Producer getById(Integer id) {
        return producerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Producer> getAll() {
        return producerRepository.findAll();
    }

    @Transactional
    public Producer create(Producer producer) {
        producerRepository.save(producer);
        return producer;
    }

    @Transactional
    public Producer update(Integer id, Producer producer) {
        Producer newProducer = producerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newProducer.setName(producer.getName());
        newProducer.setCountryName(producer.getCountryName());
        producerRepository.save(newProducer);
        return newProducer;
    }

    @Transactional
    public void delete(Integer id) {
        Producer producer = producerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        producerRepository.delete(producer);
    }

}
