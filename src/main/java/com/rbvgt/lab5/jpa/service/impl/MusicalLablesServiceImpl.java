package com.rbvgt.lab5.jpa.service.impl;

import com.rbvgt.lab5.jpa.exception.MusicalLablesNotFoundException;
import com.rbvgt.lab5.jpa.model.MusicalLables;
import com.rbvgt.lab5.jpa.repository.MusicalLablesRepository;
import com.rbvgt.lab5.jpa.service.MusicalLablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MusicalLablesServiceImpl implements MusicalLablesService {

    @Autowired
    MusicalLablesRepository musicalLablesRepository;

    @Override
    public List<MusicalLables> findAll() {
        return musicalLablesRepository.findAll();
    }

    @Override
    public MusicalLables findById(Integer id) {
        return musicalLablesRepository.findById(id)
                .orElseThrow(() -> new MusicalLablesNotFoundException(id));
    }

    @Transactional
    public MusicalLables create(MusicalLables musicalLables) {
        musicalLablesRepository.save(musicalLables);
        return musicalLables;
    }

    @Transactional
    public void update(Integer id, MusicalLables uMusicalLables) {
        MusicalLables musicalLables = musicalLablesRepository.findById(id)
                .orElseThrow(() -> new MusicalLablesNotFoundException(id));
        //update
        musicalLables.setId(uMusicalLables.getId());
        musicalLables.setName(uMusicalLables.getName());
        musicalLables.setIsAvard(uMusicalLables.getIsAvard());

        musicalLablesRepository.save(uMusicalLables);
    }

    @Transactional
    public void delete(Integer id) {
        MusicalLables musicalLables = musicalLablesRepository.findById(id)
                .orElseThrow(() -> new MusicalLablesNotFoundException(id));
        musicalLablesRepository.delete(musicalLables);
    }
}
