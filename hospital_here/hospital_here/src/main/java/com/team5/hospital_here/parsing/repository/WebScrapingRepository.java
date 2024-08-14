package com.team5.hospital_here.parsing.repository;

import com.team5.hospital_here.parsing.entity.WebScraping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WebScrapingRepository extends JpaRepository<WebScraping, Long> {

    @Query("SELECT w FROM WebScraping w ORDER BY w.rank ASC")
    List<WebScraping> findScrapingData();
}