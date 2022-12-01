package com.rubensc.crm.presentation.plannedaction;

import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
import com.rubensc.crm.service.plannedaction.PlannedActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PlannedActionController {

    @Autowired
    PlannedActionService plannedActionService;

    @GetMapping("plannedActions")
    List<PlannedAction> getAllPlannedActions() {
        return plannedActionService.getAllPlannedActions();
    }

    @PostMapping("plannedAction")
    PlannedAction createPlannedAction(@RequestBody PlannedAction plannedAction) {
        return plannedActionService.createPlannedAction(plannedAction);
    }

}
