package com.Homework3.Homework3.Service;

import com.Homework3.Homework3.Entity.LeaveRequestsEntity;
import com.Homework3.Homework3.Entity.LeaveTypeEntity;
import com.Homework3.Homework3.Entity.UsersEntity;
import com.Homework3.Homework3.Model.LeaveRequestsModel;
import com.Homework3.Homework3.Repository.LeaveRequestsRepository;
import com.Homework3.Homework3.Repository.LeaveTypeRepository;
import com.Homework3.Homework3.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LeaveRequsetService {
    @Autowired
    private LeaveRequestsRepository leaveRequestsRepository;
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;
    @Autowired
    private UsersRepository usersRepository;
//    public LeaveRequsetService(LeaveRequestsRepository leaveRequestsRepository,
//                               UsersRepository usersRepository,
//                               LeaveTypeRepository leaveTypeRepository) {
//        this.leaveRequestsRepository = leaveRequestsRepository;
//        this.usersRepository = usersRepository;
//        this.leaveTypeRepository = leaveTypeRepository;
//    }
    public List<LeaveRequestsModel> getAll() {
        List<LeaveRequestsModel> result = new ArrayList<>();
        List<LeaveRequestsEntity> entities = leaveRequestsRepository.findAll();

        for (LeaveRequestsEntity e : entities) {
            LeaveRequestsModel m = new LeaveRequestsModel();
            m.setId(e.getId());
            if (e.getUser() != null) {
                m.setUserId(e.getUser().getId());
                m.setUserName(e.getUser().getName());
                m.setDepartment(e.getUser().getDepartment());
            }
            if (e.getLeaveType() != null) {
                m.setLeaveTypeId(e.getLeaveType().getId());
                m.setLeaveTypeName(e.getLeaveType().getName());
            }
            m.setStartDate(e.getStartDate());
            m.setEndDate(e.getEndDate());
            m.setStatus(e.getStatus());
            m.setReason(e.getReason());
            result.add(m);
        }
        return result;
    }




    public LeaveRequestsModel saveAll(LeaveRequestsModel m) {
        LeaveRequestsEntity entity = new LeaveRequestsEntity();

        String id = (m.getId() == null || m.getId().isBlank())
                ? UUID.randomUUID().toString()
                : m.getId();
        entity.setId(id);

        UsersEntity user = usersRepository.findById(m.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found: " + m.getUserId()));

        LeaveTypeEntity leaveType = leaveTypeRepository.findById(m.getLeaveTypeId())
                .orElseThrow(() -> new RuntimeException("LeaveType not found: " + m.getLeaveTypeId()));

        entity.setUser(user);
        entity.setLeaveType(leaveType);

        entity.setStartDate(m.getStartDate());
        entity.setEndDate(m.getEndDate());
        entity.setStatus(m.getStatus());
        entity.setReason(m.getReason());

        LeaveRequestsEntity saved = leaveRequestsRepository.save(entity);
        LeaveRequestsModel res = new LeaveRequestsModel();
        res.setId(saved.getId());
        res.setUserId(saved.getUser().getId());
        res.setLeaveTypeId(saved.getLeaveType().getId());
        res.setStartDate(saved.getStartDate());
        res.setEndDate(saved.getEndDate());
        res.setStatus(saved.getStatus());
        res.setReason(saved.getReason());

        return res;
    }


    public LeaveRequestsModel updateLeave(String id, LeaveRequestsModel leaveRequestsModel) {
        LeaveRequestsEntity entity = leaveRequestsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave request not found: " + id));
        if (leaveRequestsModel.getStatus() != null) {
            entity.setStatus(leaveRequestsModel.getStatus());
        }
        if (leaveRequestsModel.getComment() != null) {
            entity.setComment(leaveRequestsModel.getComment());
        }
        LeaveRequestsEntity saved = leaveRequestsRepository.save(entity);
        LeaveRequestsModel res = new LeaveRequestsModel();
        res.setStatus(saved.getStatus());
        res.setComment(saved.getComment());

        return res;
    }
}
