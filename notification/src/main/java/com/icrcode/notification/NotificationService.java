package com.icrcode.notification;

import com.icrcode.clients.notification.NotificationRequest;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
  private final NotificationRepository notificationRepository;

  public void sendNotification(NotificationRequest notificationRequest) {

    Notification notification = Notification.builder()
        .toCustomerId(notificationRequest.toCustomerId())
        .toCustomerEmail(notificationRequest.toCustomerName())
        .sender("Amigoscode")
        .message(notificationRequest.message())
        .sentAt(LocalDateTime.now())
        .build();

  notificationRepository.save(notification);
  }


}
