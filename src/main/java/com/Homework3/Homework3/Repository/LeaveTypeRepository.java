package com.Homework3.Homework3.Repository;

import com.Homework3.Homework3.Entity.LeaveTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepository extends JpaRepository<LeaveTypeEntity,String> {
}
