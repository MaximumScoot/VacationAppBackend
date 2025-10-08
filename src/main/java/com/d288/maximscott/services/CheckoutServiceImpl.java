package com.d288.maximscott.services;

import com.d288.maximscott.dao.CartRepository;
import com.d288.maximscott.dao.CustomerRepository;
import com.d288.maximscott.entities.Cart;
import com.d288.maximscott.entities.CartItem;
import com.d288.maximscott.entities.Customer;
import com.d288.maximscott.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve order info from dto
        Cart cart = purchase.getCart();

        //create tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cartItem -> cart.add(cartItem));
        cartItems.forEach(cartItem -> cartItem.setCart(cart));

        //set cart status
        cart.setStatus(StatusType.ordered);

        //populate customer with cart
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        //save cart to database
        customerRepository.save(customer);


        //return response
        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {

        //generating random UUID version-4
        return UUID.randomUUID().toString();
    }
}
