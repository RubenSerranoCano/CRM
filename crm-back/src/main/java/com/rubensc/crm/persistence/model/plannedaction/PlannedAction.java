package com.rubensc.crm.persistence.model.plannedaction;


import com.rubensc.crm.persistence.model.appuser.AppUser;
import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "planned_action")
@Getter
@Setter
@NoArgsConstructor
public class PlannedAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "user")
//    AppUser user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "opportunity")
    Opportunity opportunity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client")
    Client client;

    @Override
    public String toString() {
        return "PlannedAction{" +
                "id=" + id +
                ", actionType=" + actionType +
                ", description='" + description + '\'' +
                ", statusType=" + statusType +
                ", dueDateTime=" + dueDateTime +
                ", creationDateTime=" + creationDateTime +
                ", opportunity=" + opportunity +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlannedAction that = (PlannedAction) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
