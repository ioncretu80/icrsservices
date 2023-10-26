package com.icrcode.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;

  private final RestTemplate restTemplate;


  public void registerCustomer(CustomerRequest customerRequest){
    Customer customer = Customer.builder()
        .firstName(customerRequest.firstName())
        .lastName(customerRequest.lastName())
        .email(customerRequest.email())
        .build();
    //todo: check if email is valid
    //todo: check if isfraudster

    customerRepository.saveAndFlush(customer);

    FraudCheckResponse fraudCheckResponse;
    try{
      fraudCheckResponse = restTemplate.getForObject(
          "http://localhost:8081/api/v1/fraud-check/{customerId}",
          FraudCheckResponse.class,
          customer.getId());

      if(Boolean.TRUE.equals(fraudCheckResponse.isFraudster())){
        throw new IllegalStateException("fraudster");
      }

    }catch (NullPointerException e){
      e.printStackTrace();
    }



  }
}
