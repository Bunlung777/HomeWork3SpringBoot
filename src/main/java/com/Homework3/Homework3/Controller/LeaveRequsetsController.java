package com.Homework3.Homework3.Controller;


import com.Homework3.Homework3.Entity.LeaveRequestsEntity;
import com.Homework3.Homework3.Model.LeaveRequestsModel;
import com.Homework3.Homework3.Service.LeaveRequsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/leave-requests")
@CrossOrigin(origins = "http://localhost:4200")
public class LeaveRequsetsController {
    @Autowired
    private LeaveRequsetService leaveRequsetService;

    @GetMapping
    public List<LeaveRequestsModel> getAll() {
        return leaveRequsetService.getAll();
    }
    @PostMapping
    public LeaveRequestsModel addLeaveRequests(@RequestBody LeaveRequestsModel leaveRequestsModel) {
        return leaveRequsetService.saveAll(leaveRequestsModel);
    }
    @PutMapping("/{id}")
    public LeaveRequestsModel updateLeave(@PathVariable String id,@RequestBody LeaveRequestsModel leaveRequestsModel)
    {
        return leaveRequsetService.updateLeave(id, leaveRequestsModel);
    }

}
