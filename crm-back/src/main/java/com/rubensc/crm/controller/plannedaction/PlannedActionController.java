package com.rubensc.crm.controller.plannedaction;

import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
import com.rubensc.crm.service.plannedaction.PlannedActionService;
import com.rubensc.crm.util.ColorLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PlannedActionController {

    @Autowired
    PlannedActionService plannedActionService;

    @GetMapping("/plannedActions")
    List<PlannedAction> getAllPlannedActions(Authentication auth) {
        String username = auth.getName();
        ColorLogger.info("Username to filter requests: " + username);
        return plannedActionService.getAllPlannedActions();
    }

    @PostMapping("/plannedAction")
    PlannedAction createPlannedAction(@RequestBody PlannedAction plannedAction) {
        return plannedActionService.createPlannedAction(plannedAction);
    }

}
