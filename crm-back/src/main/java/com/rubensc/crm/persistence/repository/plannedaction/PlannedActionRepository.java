package com.rubensc.crm.persistence.repository.plannedaction;

import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannedActionRepository extends JpaRepository<PlannedAction, Long> {
}
