package com.Homework3.Homework3.Entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "leave_requests",catalog = "postgres")
public class LeaveRequestsEntity {
    @Id
    @Column(name = "id")
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity user;
    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    private LeaveTypeEntity leaveType;
    @Column(name = "start_date")
    private Date startDate;
    @Column (name = "end_date")
    private Date endDate;
    @Column (name = "status")
    private String status;
    @Column (name = "reason")
    private String reason;
    @Column (name = "comment")
    private String comment;

    public LeaveRequestsEntity(String id, UsersEntity user, LeaveTypeEntity leaveType, Date startDate, Date endDate, String status, String reason, String comment) {
        this.id = id;
        this.user = user;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.reason = reason;
        this.comment = comment;
    }
    public LeaveRequestsEntity() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public LeaveTypeEntity getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveTypeEntity leaveType) {
        this.leaveType = leaveType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
