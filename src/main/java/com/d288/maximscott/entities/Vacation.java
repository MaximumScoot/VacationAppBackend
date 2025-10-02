package com.d288.maximscott.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Vacation {

    //Mapping PK for Excursion.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    //Mapping the rest of the database columns, including metadata for creation and update timestamps.
    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "image_URL")
    private String image_URL;

    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    @Column(name = "vacation_title")
    private String vacation_title;


    //Relationships: one-to-many, a Vacation can include many Excursions. Cascade for persistance.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
    private Set<Excursion> excursions;

}
