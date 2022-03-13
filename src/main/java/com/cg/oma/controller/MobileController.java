package com.cg.oma.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.cg.oma.beans.Mobile;
import com.cg.oma.beans.ResponseInfo;

public class MobileController {
	String endPoint="http://localhost:8084/mobiles";

	@Autowired
	RestTemplate rt;

	@PostMapping("/mobile")
	ResponseEntity<ResponseInfo> addMobile(@RequestBody Mobile mobile){
		return rt.postForEntity(endPoint, mobile, ResponseInfo.class);
	}

	@PutMapping("/mobile")
	String updateMobile(@RequestBody Mobile mobile) {
		rt.put(endPoint, mobile, ResponseInfo.class);
		return "Updated successfully";
	}

	@DeleteMapping("/mobile")
	String deleteMobile(@RequestBody int id) {
		rt.delete(endPoint+"/"+id);
		return "Deletedte successfully";
	}

	@GetMapping
	List<Mobile> getAllMobile(){
		List<Mobile> list=Arrays.asList(rt.getForObject(endPoint, Mobile[].class));
		return list;
	}
	@GetMapping("/mobile/{id}")
	Mobile getMobileById(@PathVariable("id") int id) {
	Mobile mob=rt.getForObject(endPoint+"/"+id, Mobile.class);
	return mob;
	}
}
