package com.harish.app.rest.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int age;

    @Column
    private String occupation;

}
