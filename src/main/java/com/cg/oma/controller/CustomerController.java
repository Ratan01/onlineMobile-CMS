package com.cg.oma.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.cg.oma.beans.Customer;
import com.cg.oma.beans.ResponseInfo;

public class CustomerController {
	String endPoint="http://localhost:8081/customers";
	
	@Autowired
	RestTemplate rt;
	
	@PostMapping("/customer")
	ResponseEntity<ResponseInfo> addCustomer(@RequestBody Customer customer){
		return rt.postForEntity(endPoint, customer, ResponseInfo.class);
	}
	
	@PutMapping("/customer")
	String updateCustomers(@RequestBody Customer customer) {
		rt.put(endPoint, customer, ResponseInfo.class);
		return "Updated successfully";
	}
	
	@DeleteMapping("/customer")
	String deleteCustomers(@RequestBody int id) {
		rt.delete(endPoint+"/"+id);
		return "Deletedte successfully";
	}
	
	@GetMapping
	List<Customer> getAllCustomer(){
		List<Customer> list=Arrays.asList(rt.getForObject(endPoint, Customer[].class));
		return list;
	}
}
