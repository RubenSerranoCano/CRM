package com.rubensc.crm.persistence.model.opportunity;

import com.rubensc.crm.persistence.model.user.AppUser;
import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
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
    private Long id;

    @Size(max = 40)
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client")
    private Client client;

    @OneToMany(mappedBy = "opportunity", fetch = FetchType.EAGER)
    private List<PlannedAction> plannedActionList;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OpportunityStatusType statusType;

    @NotNull
    private LocalDateTime creationDateTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "app_user")
    private AppUser user;
}
