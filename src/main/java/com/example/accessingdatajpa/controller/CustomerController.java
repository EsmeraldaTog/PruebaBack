package com.example.accessingdatajpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.accessingdatajpa.entity.Customer;
import com.example.accessingdatajpa.repository.CustomerRepository;

import lombok.extern.log4j.Log4j2;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/customers")
@Log4j2
public class CustomerController {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		log.info("Solicitud Get para todos los Customers");
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		return customers;
	}

	@GetMapping("{id}")
	public Customer getCustomerById(@PathVariable long id) {
		Customer customer = customerRepository.findById(id);
		return customer;
	}
	
	
	@PostMapping
	public Customer setCustomer(@RequestBody Customer customer) {
		Customer newCustomer= customerRepository.save(customer);
		return newCustomer;
	}
	
	@PutMapping("{id}")  // localhost:8080/api/vi/customers/2
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
		log.info("Solicitud put, actualizar cliente");
		
		Customer existingCustomer = customerRepository.findById( id );
		
		if( existingCustomer == null ) {
			throw new IllegalStateException("User does not exist");
		}
		
		existingCustomer.setFirstName( customer.getFirstName() );
		existingCustomer.setLastName( customer.getLastName() );
		
		
		return customerRepository.save(existingCustomer);
	}
	

	@DeleteMapping("{id}") // localhost:8080/api/vi/customers/2
	public String deleteCustomer(@PathVariable Long id) {
		
		Optional<Customer> optionalCustomer = customerRepository.findById(id); // Objeto de la clase Optional
		
		if ( optionalCustomer.isPresent() ) {
		    Customer existingCustomer = optionalCustomer.get();
		    customerRepository.delete(existingCustomer);
		    return "Cliente eliminado";
		}
			
		throw new IllegalStateException("User does not exist");
		
	}}
	

