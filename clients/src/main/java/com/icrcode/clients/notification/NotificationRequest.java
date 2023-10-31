package com.icrcode.clients.notification;

public record NotificationRequest(
    Integer toCustomerId,
    String toCustomerName,
    String message
) {

}
