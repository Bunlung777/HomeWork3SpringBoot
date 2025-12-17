package com.Homework3.Homework3.Repository;

import com.Homework3.Homework3.Entity.LeaveBalancesEntity;
import com.Homework3.Homework3.Entity.LeaveRequestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveBalancesRepository extends JpaRepository<LeaveBalancesEntity, String> {
}
