package com.icrcode.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/customers")
@AllArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @PostMapping()
  public void registerCustomer(@RequestBody CustomerRequest customerRequest){
    log.info("new customer registration {}", customerRequest);
    customerService.registerCustomer(customerRequest);
  }

  @GetMapping
  public String halloCustomer(){
    return "Hallo Customers!";
  }

}
