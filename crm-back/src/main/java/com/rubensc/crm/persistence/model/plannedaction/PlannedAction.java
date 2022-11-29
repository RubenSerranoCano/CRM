package com.rubensc.crm.persistence.model.plannedaction;


import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;




@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class PlannedAction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Enumerated(EnumType.STRING)
    ActionType actionType;

    @Size(max = 120)
    String description;

    @Enumerated(EnumType.STRING)
    PlannedActionStatusType statusType;

    @NotNull
    LocalDateTime dueDateTime;

    @NotNull
    LocalDateTime creationDateTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "opportunity")
    Opportunity opportunity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client")
    Client client;
}