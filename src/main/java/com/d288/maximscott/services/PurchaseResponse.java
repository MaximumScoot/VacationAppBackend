package com.d288.maximscott.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseResponse {

    private final String orderTrackingNumber;
    //Have to make a constructor since @Data is apparently glitchy with this Lombok version and
    //I cant just declare orderTrackingNumber as private final.
    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
