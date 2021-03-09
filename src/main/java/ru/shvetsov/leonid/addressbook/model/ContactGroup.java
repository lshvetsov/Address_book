package ru.shvetsov.leonid.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactGroup extends BaseEntity {

    private String name;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToMany
    @JoinTable(name = "person_group",
            joinColumns = {@JoinColumn(name = "contact_group_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private Set<Person> participants;
}
