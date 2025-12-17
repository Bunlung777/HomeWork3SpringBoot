package com.Homework3.Homework3.Controller;

import com.Homework3.Homework3.Entity.LeaveBalancesEntity;
import com.Homework3.Homework3.Model.LeaveBalancesModel;
import com.Homework3.Homework3.Model.LeaveRequestsModel;
import com.Homework3.Homework3.Service.LeaveBalancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave-balances")
@CrossOrigin(origins = "http://localhost:4200")
public class LeaveBalancesController {
    @Autowired
    private LeaveBalancesService leaveBalancesService;
    @GetMapping
    public List<LeaveBalancesModel> getAll() {
        return leaveBalancesService.getAll();
    }
    @PutMapping("/{id}")
    public LeaveBalancesModel updateLeave(@PathVariable String id, @RequestBody LeaveBalancesModel leaveBalancesModel)
    {
        return leaveBalancesService.updateLeave(id, leaveBalancesModel);
    }
}
