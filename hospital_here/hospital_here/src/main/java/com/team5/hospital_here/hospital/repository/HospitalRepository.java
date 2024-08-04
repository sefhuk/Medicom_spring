package com.team5.hospital_here.hospital.repository;


import com.team5.hospital_here.hospital.entity.Department;
import com.team5.hospital_here.hospital.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Page<Hospital> findByNameContainingIgnoreCaseAndAddressContainingIgnoreCase(String name, String address, Pageable pageable);

    @Query("SELECT h FROM Hospital h JOIN h.hospitalDepartments hd JOIN hd.department d WHERE "
            + "(:name IS NULL OR h.name LIKE %:name%) AND "
            + "(:address IS NULL OR h.address LIKE %:address%) AND "
            + "(:departmentName IS NULL OR :departmentName = '' OR d.name LIKE %:departmentName%)")
    List<Hospital> searchHospitals(
            @Param("name") String name,
            @Param("address") String address,
            @Param("departmentName") String departmentName);
}