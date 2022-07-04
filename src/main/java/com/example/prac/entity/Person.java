package com.example.prac.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="FirstName")
    private String firstName;
    @Column(name="LastName")
    private String lastName;
    @Column(name="Email")
    private String email;
}
