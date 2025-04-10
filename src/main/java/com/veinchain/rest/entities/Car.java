package com.veinchain.rest.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column
    private String name;

    @Column
    private String model;

    @Column
    private int yearOfManufacturing;

    @CreationTimestamp
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp updatedTime;

}
