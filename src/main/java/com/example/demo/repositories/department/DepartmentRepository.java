package com.example.demo.repositories.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.DepartmentEntity;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:40:49 AM
 */

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

}