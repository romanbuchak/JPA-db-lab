package com.rbvgt.lab5.jpa.service.impl;

import com.rbvgt.lab5.jpa.exception.UserCardNotFoundException;
import com.rbvgt.lab5.jpa.model.UserCard;
import com.rbvgt.lab5.jpa.repository.UserCardRepository;
import com.rbvgt.lab5.jpa.service.UserCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserCardServiceImpl implements UserCardService {
    
    @Autowired
    UserCardRepository userCardRepository;

    @Override
    public List<UserCard> findAll() {
        return userCardRepository.findAll();
    }

    @Override
    public UserCard findById(Integer id) {
        return userCardRepository.findById(id)
                .orElseThrow(() -> new UserCardNotFoundException(id));
    }

    @Override
    public UserCard create(UserCard entity) {
        return userCardRepository.save(entity);
    }

    @Override
    public void update(Integer id, UserCard newUserCard) {
        UserCard userCard = userCardRepository.findById(id)
                .orElseThrow(() -> new UserCardNotFoundException(id));
        userCard.setName(newUserCard.getName());
        userCardRepository.save(userCard);
    }

    @Override
    public void delete(Integer id) {
        UserCard userCard = userCardRepository.findById(id)
                .orElseThrow(() -> new UserCardNotFoundException(id));
        userCardRepository.delete(userCard);
    }
}
