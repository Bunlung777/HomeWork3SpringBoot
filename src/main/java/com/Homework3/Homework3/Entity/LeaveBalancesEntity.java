package com.Homework3.Homework3.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leave_balances",catalog = "postgres")
public class LeaveBalancesEntity {
    @Id
    @Column(name = "id")
    private  String id;
    @Column(name = "user_id")
    private  String userId;
    @Column(name = "leave_type_id")
    private  String leaveTypeId;
    @Column(name = "year")
    private String year;
    @Column(name = "remaining_days")
    private Integer remainingDays;

    public LeaveBalancesEntity(String id, String userId, String leaveTypeId, String year, Integer remainingDays) {
        this.id = id;
        this.userId = userId;
        this.leaveTypeId = leaveTypeId;
        this.year = year;
        this.remainingDays = remainingDays;
    }

    public LeaveBalancesEntity() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(Integer remainingDays) {
        this.remainingDays = remainingDays;
    }
}
