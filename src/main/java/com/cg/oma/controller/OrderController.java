package com.cg.oma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.cg.oma.beans.Order;
import com.cg.oma.beans.ResponseInfo;

public class OrderController {
	String endPoint="http://localhost:8085/orders";

	@Autowired
	RestTemplate rt;

	@PostMapping("/order")
	ResponseEntity<ResponseInfo> addOrders(@RequestBody Order order){
		return rt.postForEntity(endPoint, order, ResponseInfo.class);
	}

	@PutMapping("/order")
	String updateOrders(@RequestBody Order order) {
		rt.put(endPoint, order, ResponseInfo.class);
		return "Updated successfully";
	}

	@DeleteMapping("/customer")
	String deleteOrders(@RequestBody int id) {
		rt.delete(endPoint+"/"+id);
		return "Deleted successfully";
	}

}
