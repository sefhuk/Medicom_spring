package com.team5.hospital_here.hospital.repository;


import com.team5.hospital_here.hospital.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    // 필요한 검색 메서드를 추가할 수 있습니다.
    Page<Hospital> findByNameContaining(String name, Pageable pageable);
    List<Hospital> findByCity(String city);
}