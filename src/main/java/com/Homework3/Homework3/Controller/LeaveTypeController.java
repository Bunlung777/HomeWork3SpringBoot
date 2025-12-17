package com.Homework3.Homework3.Controller;

import com.Homework3.Homework3.Model.LeaveRequestsModel;
import com.Homework3.Homework3.Model.LeaveTypeModel;
import com.Homework3.Homework3.Service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LeaveTypeController {
    @Autowired
    LeaveTypeService leaveTypeService;
    @GetMapping("/api/leave-types")
    public List<LeaveTypeModel> getAll() {
        return leaveTypeService.getAll();
    }
}
