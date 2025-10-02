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
@Table(name = "cart_items")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CartItem {

    //Mapping PK for cart_items.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;


    //Mapping the rest of the database columns, including metadata for creation and update timestamps.
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;



    //Relationships: many-to-one, each cart item associated with one vacation. FK is vacation_id.
    //many-to-one, each cart item belongs to single cart. FK is cart_id.
    //many-to-many, cart item can include multiple excursions and vice versa.
    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    private Set<Excursion> excursions;

}
