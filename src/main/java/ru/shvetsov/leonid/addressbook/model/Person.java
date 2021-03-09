package ru.shvetsov.leonid.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {

    private String name;
    private String surname;
    private String patronymic;
    private String nick;

    @EqualsAndHashCode.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", nullable = true)
    private Job job;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<ContactGroup> myGroups;

}
