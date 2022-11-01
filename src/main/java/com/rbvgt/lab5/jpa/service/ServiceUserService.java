package com.rbvgt.lab5.jpa.service;

import com.rbvgt.lab5.jpa.model.ServiceUser;
import java.util.List;

public interface ServiceUserService extends GeneralService<ServiceUser, Integer>{
    List<ServiceUser> findServiceUserByNameOfProfile(String nameOfProfile);
}
