package com.rubensc.crm.persistence.model.client;

import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import com.rubensc.crm.persistence.model.plannedaction.PlannedAction;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(max = 9)
    @NotNull
    @Column(unique = true)
    String tin;

    @Size(max = 80)
    @NotNull
    String name;

    @Size(max = 15)
    String phoneNumber;

    @Size(max = 50)
    @Email
    @NotNull
    @Column(unique = true)
    String email;

    @Size(max = 80)
    String address;

    @Enumerated(EnumType.STRING)
    @NotNull
    ClientStatusType statusType;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    List<Opportunity> opportunityList;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    List<PlannedAction> plannedActionList;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", tin='" + tin + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", statusType=" + statusType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
