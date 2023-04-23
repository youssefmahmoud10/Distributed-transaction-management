package com.example.demo.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.UserEntity;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:39:49 AM
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}