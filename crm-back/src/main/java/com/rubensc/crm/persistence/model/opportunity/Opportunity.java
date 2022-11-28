package com.rubensc.crm.persistence.model.opportunity;

import com.rubensc.crm.persistence.model.user.User;
import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.plannedAction.PlannedAction;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Size(max = 40)
    String name;

    @ManyToOne
    Client client;

    @NotNull
    @OneToMany
    List<PlannedAction> plannedActionList;

    @NotNull
    @Enumerated(EnumType.STRING)
    OpportunityStatusType statusType;

    @NotNull
    LocalDateTime creationDateTime;

    @ManyToOne
    User user;
}
