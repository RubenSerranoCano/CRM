package com.rubensc.crm.persistence.model.client;

import com.rubensc.crm.persistence.model.opportunity.Opportunity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @OneToMany
    List<Opportunity> opportunityList;
}
