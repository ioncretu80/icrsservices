package com.icrcode.customer;


import com.icrcode.clients.fraud.FraudCheckResponse;
import com.icrcode.clients.fraud.FraudClient;
import com.icrcode.clients.notification.NotificationClient;
import com.icrcode.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;

//  private final RestTemplate restTemplate;
  private final FraudClient fraudClient;
  private final NotificationClient notificationClient;


  public void registerCustomer(CustomerRequest customerRequest){
    Customer customer = Customer.builder()
        .firstName(customerRequest.firstName())
        .lastName(customerRequest.lastName())
        .email(customerRequest.email())
        .build();
    //todo: check if email is valid
    //todo: check if isfraudster

    customerRepository.saveAndFlush(customer);

//    FraudCheckResponse fraudCheckResponse;
//    try{
//      fraudCheckResponse = restTemplate.getForObject(
//          "http://localhost:8081/api/v1/fraud-check/{customerId}",
//          FraudCheckResponse.class,
//          customer.getId());
//      if(Boolean.TRUE.equals(fraudCheckResponse.isFraudster())){
//        throw new IllegalStateException("fraudster");
//      }
//
//    }catch (NullPointerException e){
//      e.printStackTrace();
//    }

    FraudCheckResponse fraudResponse =
        fraudClient.isFraudster(customer.getId());

    if (fraudResponse.isFraudster()){
      throw new IllegalStateException("fraudster");
    }
  //todo: send notification

    notificationClient.sendNotification(new NotificationRequest(
        customer.getId(),
        customer.getEmail()
        ,String.format("Hi %s,  welcome to Amigoscode...", customer.getFirstName())
    ));
  }
}
