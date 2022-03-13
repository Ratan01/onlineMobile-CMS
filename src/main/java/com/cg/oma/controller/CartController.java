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

import com.cg.oma.beans.Mobile;
import com.cg.oma.beans.ResponseInfo;

public class CartController {
	String endPoint="http://localhost:8083/carts";
	
	String endPointMobile="http://localhost:8084/mobiles";

	@Autowired
	RestTemplate rt;

	@PostMapping("/cart")
	ResponseEntity<ResponseInfo> addMobileItem(@RequestBody List<Mobile> mobile){
		return rt.postForEntity(endPointMobile, mobile, ResponseInfo.class);
	}

	@PutMapping("/cart")
	String updateMobileItems(@RequestBody Mobile mobile) {
		rt.put(endPointMobile, mobile, ResponseInfo.class);
		return "Updated successfully";
	}

	@DeleteMapping("/cart")
	String deleteMobileItems(@RequestBody int mobileId) {
		rt.delete(endPointMobile+"/"+mobileId);
		return "Deletedte successfully";
	}

	@GetMapping("/cart")
	List<Mobile> getAllMobileItem(){
		List<Mobile> list=Arrays.asList(rt.getForObject(endPointMobile, Mobile[].class));
		return list;
	}
	/*
	@GetMapping("/cart/placeOrder")
	long placeOrder(Cart cart) {
		rt.
		return 0;		
	}
	*/
}
