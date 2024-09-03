

package com.rays.ctl;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.OrderDTO;
import com.rays.form.OrderForm;
import com.rays.service.OrderServiceInt;

@RestController
@RequestMapping(value = "Order")
public class OrderCtl extends BaseCtl<OrderForm, OrderDTO, OrderServiceInt> {

	
	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
	
		
		HashMap<Integer, String> map1=new HashMap<Integer, String>();
		map1.put(1, "Shipped");
		map1.put(2, "Pending");
		map1.put(3, "Delivered");
		res.addResult("orderList", map1);
		return res;
	}

	@PostMapping
	public ResponseEntity<String> createOrder(@Valid @RequestBody OrderForm OrderForm) {
		return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
	}
}

