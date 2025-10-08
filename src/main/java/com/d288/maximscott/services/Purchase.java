package com.d288.maximscott.services;

import com.d288.maximscott.entities.Cart;
import com.d288.maximscott.entities.CartItem;
import com.d288.maximscott.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
