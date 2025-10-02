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
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Excursion {

    //Mapping PK for Excursion.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    //Mapping the rest of the database columns, including metadata for creation and update timestamps.
    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "image_URL")
    private String image_URL;

    @Column(name = "excursion_title")
    private String excursion_title;


    //Relationships: many-to-one, each excursion associated with a Vacation. FK is vacation_id.
    //many-to-many, Excursion can appear in multiple CartItems, and CartItem can include many Excursions.
    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;

}
