package com.rbvgt.lab5.jpa.repository;

import com.rbvgt.lab5.jpa.model.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceUserRepository extends JpaRepository<ServiceUser, Integer> {
    List<ServiceUser> findServiceUserByNameOfProfile(String nameOfProfile);
}
