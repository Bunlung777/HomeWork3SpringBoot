package com.Homework3.Homework3.Controller;

import com.Homework3.Homework3.Model.LeaveTypeModel;
import com.Homework3.Homework3.Model.UsersModel;
import com.Homework3.Homework3.Service.LeaveTypeService;
import com.Homework3.Homework3.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
    @Autowired
    UsersService usersService;
    @GetMapping("/api/Users")
    public List<UsersModel> getAll() {
        return usersService.getAll();
    }
}
