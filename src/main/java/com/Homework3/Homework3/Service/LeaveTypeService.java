package com.Homework3.Homework3.Service;

import com.Homework3.Homework3.Entity.LeaveRequestsEntity;
import com.Homework3.Homework3.Entity.LeaveTypeEntity;
import com.Homework3.Homework3.Model.LeaveRequestsModel;
import com.Homework3.Homework3.Model.LeaveTypeModel;
import com.Homework3.Homework3.Repository.LeaveTypeRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveTypeService {
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    public List<LeaveTypeModel> getAll() {
        List<LeaveTypeModel> result = new ArrayList<>();
        List<LeaveTypeEntity> entities = leaveTypeRepository.findAll();
        for (LeaveTypeEntity e : entities) {
            LeaveTypeModel m = new LeaveTypeModel();
            m.setId(e.getId());
            m.setName(e.getName());
            m.setDescription(e.getDescription());
            m.setMaxDays(e.getMaxDays());
            result.add(m);
        }
        return result;
    }
}
