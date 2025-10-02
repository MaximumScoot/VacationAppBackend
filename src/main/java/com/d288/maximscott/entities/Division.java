package com.d288.maximscott.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Division {

    //Mapping PK for Division.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    //Mapping the rest of the database columns, including metadata for creation and update timestamps.
    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;


    //Relationships: many-to-one, each division belongs to a country. FK is country_id.
    //one-to-many, division can contain multiple customers. Cascade to propagate Division change to Customers.
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    //Read only shadow field for FK. Access FK without grabbing Country object.
    @Column(name = "country_id", insertable = false, updatable = false)
    private Long country_id;

    //Setter for country relationship.
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private Set<Customer> customers;

}
