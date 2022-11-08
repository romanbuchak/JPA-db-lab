package com.rbvgt.lab5.jpa.repository;

import com.rbvgt.lab5.jpa.model.Download;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadRepository extends JpaRepository<Download, Integer> {
    @Query(value = "CALL CalcAveragePrice();", nativeQuery = true)
    Integer getAveragePrice();
}
