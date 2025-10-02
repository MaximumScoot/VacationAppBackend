package com.d288.maximscott.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cart {

    //Mapping PK for Cart.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    //Mapping the rest of the database columns, including metadata for creation and update timestamps.
    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "party_size")
    private int party_size;

    //Current status of cart (pending, ordered, cancelled).
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "postal_code")
    private String postal_code;

    //Relationships: many-to-one, each cart belongs to one customer, FK is customer_id.
    //one-to-many, cart can have multiple cart items. cascade so cart items are persisted/deleted with cart.
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItem = new HashSet<>();

    //Method to add CartItem to cart.
    public void add(CartItem cartItem) {
        this.cartItem.add(cartItem);
    }

}
