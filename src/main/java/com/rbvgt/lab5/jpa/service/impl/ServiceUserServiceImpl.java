package com.rbvgt.lab5.jpa.service.impl;

import com.rbvgt.lab5.jpa.exception.ServiceUserNotFoundException;
import com.rbvgt.lab5.jpa.model.ServiceUser;
import com.rbvgt.lab5.jpa.repository.ServiceUserRepository;
import com.rbvgt.lab5.jpa.service.ServiceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceUserServiceImpl implements ServiceUserService {

    @Autowired
    ServiceUserRepository serviceUserRepository;

    @Override
    public List<ServiceUser> findServiceUserByNameOfProfile(String nameOfProfile) {
        return serviceUserRepository.findServiceUserByNameOfProfile(nameOfProfile);
    }

    @Override
    public List<ServiceUser> findAll() {
        return serviceUserRepository.findAll();
    }

    @Override
    public ServiceUser findById(Integer id) {
        return serviceUserRepository.findById(id)
                .orElseThrow(() -> new ServiceUserNotFoundException(id));
    }

    @Transactional
    public ServiceUser create(ServiceUser serviceUser) {
        serviceUserRepository.save(serviceUser);
        return serviceUser;
    }

    @Transactional
    public void update(Integer id, ServiceUser uServiceUser) {
        ServiceUser serviceUser = serviceUserRepository.findById(id)
                .orElseThrow(() -> new ServiceUserNotFoundException(id));
        //update
        serviceUser.setId(uServiceUser.getId());
        serviceUser.setNameOfProfile(uServiceUser.getNameOfProfile());

        serviceUserRepository.save(uServiceUser);
    }

    @Transactional
    public void delete(Integer id) {
        ServiceUser serviceUser = serviceUserRepository.findById(id)
                .orElseThrow(() -> new ServiceUserNotFoundException(id));
        serviceUserRepository.delete(serviceUser);
    }
}
