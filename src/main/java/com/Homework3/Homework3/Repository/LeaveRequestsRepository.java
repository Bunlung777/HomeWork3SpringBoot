package com.Homework3.Homework3.Repository;

import com.Homework3.Homework3.Entity.LeaveRequestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestsRepository extends JpaRepository<LeaveRequestsEntity, String> {
}
