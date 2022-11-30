package com.rubensc.crm.persistence.model.opportunity;

import com.rubensc.crm.persistence.model.client.Client;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
import com.rubensc.crm.persistence.model.user.AppUser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", client=" + client +
                ", plannedActionList=" + plannedActionList +
                ", statusType=" + statusType +
                ", creationDateTime=" + creationDateTime +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Opportunity that = (Opportunity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
