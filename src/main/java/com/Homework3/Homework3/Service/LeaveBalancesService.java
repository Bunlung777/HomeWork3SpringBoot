package com.Homework3.Homework3.Service;

import com.Homework3.Homework3.Entity.LeaveBalancesEntity;
import com.Homework3.Homework3.Entity.LeaveRequestsEntity;
import com.Homework3.Homework3.Model.LeaveBalancesModel;
import com.Homework3.Homework3.Model.LeaveRequestsModel;
import com.Homework3.Homework3.Repository.LeaveBalancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveBalancesService {
    @Autowired
    private LeaveBalancesRepository leaveBalancesRepository;

    public List<LeaveBalancesModel> getAll() {
        List<LeaveBalancesModel> result = new ArrayList<>();
        List<LeaveBalancesEntity> entities = leaveBalancesRepository.findAll();

        for (LeaveBalancesEntity e : entities) {
            LeaveBalancesModel m = new LeaveBalancesModel();
            m.setId(e.getId());
            m.setUserId(e.getUserId());
            m.setLeaveTypeId(e.getLeaveTypeId());
            m.setYear(e.getYear());
            m.setRemainingDays(e.getRemainingDays());
            result.add(m);
        }
        return result;
    }
    public LeaveBalancesModel updateLeave(String id, LeaveBalancesModel leaveBalancesModel) {
        LeaveBalancesEntity entity = leaveBalancesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave request not found: " + id));
        if (leaveBalancesModel.getRemainingDays() != null) {
            entity.setRemainingDays(leaveBalancesModel.getRemainingDays());
        }
        LeaveBalancesEntity saved = leaveBalancesRepository.save(entity);
        LeaveBalancesModel res = new LeaveBalancesModel();
        res.setRemainingDays(saved.getRemainingDays());

        return res;
    }
}
