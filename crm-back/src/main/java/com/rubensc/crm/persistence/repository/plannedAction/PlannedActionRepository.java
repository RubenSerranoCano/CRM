package com.rubensc.crm.persistence.repository.plannedAction;

import com.rubensc.crm.persistence.model.plannedAction.PlannedAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannedActionRepository extends JpaRepository<PlannedAction, Long> {
}
