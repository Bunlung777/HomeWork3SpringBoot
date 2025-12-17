package com.Homework3.Homework3.Repository;

import com.Homework3.Homework3.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersEntity, String> {
}
