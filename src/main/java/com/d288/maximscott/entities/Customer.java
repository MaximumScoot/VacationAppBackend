package com.d288.maximscott.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Customer {

    //Mapping PK for Country.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    //Mapping the rest of the database columns, including metadata for creation and update timestamps.
    @Column(name = "address")
    private String address;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "customer_first_name")
    private String firstName;

    @Column(name = "customer_last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "postal_code")
    private String postal_code;


    //Relationships: many-to-one, each customer belongs to a division. FK is division_id.
    //one-to-many, customer can have multiple carts. Cascade so changes to customer propagates to their carts.
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts;

}
