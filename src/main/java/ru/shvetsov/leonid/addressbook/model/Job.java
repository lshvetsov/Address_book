package ru.shvetsov.leonid.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job extends BaseEntity {

    @OneToOne(mappedBy = "job")
    private Person person;
    private String company;
    private String department;
    private String position;

}
