package com.admazsshipping.application;

import com.admazsshipping.domain.Customer;
import com.admazsshipping.domain.dto.CustomerDTO;
import com.admazsshipping.domain.ports.interfaces.CustomerServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerServicePort customerServicePort;


    public CustomerController(CustomerServicePort customerServicePort) {
        this.customerServicePort = customerServicePort;
    }

    @PostMapping
    public ResponseEntity<Customer> insert(@RequestBody CustomerDTO customerData){
        var customer = this.customerServicePort.insert(customerData.toEntity());
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") String id){
        var customer = this.customerServicePort.findById(id);
        return ResponseEntity.ok().body(customer);
    }

}
