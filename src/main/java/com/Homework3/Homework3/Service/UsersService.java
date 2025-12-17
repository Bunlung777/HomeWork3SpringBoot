package com.Homework3.Homework3.Service;

import com.Homework3.Homework3.Entity.LeaveTypeEntity;
import com.Homework3.Homework3.Entity.UsersEntity;
import com.Homework3.Homework3.Model.LeaveTypeModel;
import com.Homework3.Homework3.Model.UsersModel;
import com.Homework3.Homework3.Repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<UsersModel> getAll() {
        List<UsersModel> result = new ArrayList<>();
        List<UsersEntity> entities = usersRepository.findAll();
        for (UsersEntity e : entities) {
            UsersModel m = new UsersModel();
            m.setId(e.getId());
            m.setName(e.getName());
            m.setEmail(e.getEmail());
            m.setRole(e.getRole());
            m.setDepartment(e.getDepartment());
            result.add(m);
        }
        return result;
    }
}
