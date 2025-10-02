package com.d288.maximscott.entities;

//Shows possible status value for a Cart in system. Stored in database as string because of @Enumerated mapping in Cart entity.
public enum StatusType {
    pending,
    ordered,
    canceled
}
