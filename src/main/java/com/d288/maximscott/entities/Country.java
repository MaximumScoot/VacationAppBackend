package com.d288.maximscott.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Country {

    //Mapping PK for Country.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    //Mapping the rest of the database columns, including metadata for creation and update timestamps.
    @Column(name = "country")
    private String country_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;


    //Relationships: one-to-many, country can have multiple divisions. Cascade for changes from Country to propagate Divisions.
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Division> divisions;


}
