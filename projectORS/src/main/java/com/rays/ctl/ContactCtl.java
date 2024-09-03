

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
import com.rays.dto.ContactDTO;
import com.rays.form.ContactForm;
import com.rays.service.ContactServiceInt;

@RestController
@RequestMapping(value = "Contact")
public class ContactCtl extends BaseCtl<ContactForm, ContactDTO, ContactServiceInt> {

	
	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
	
		
		HashMap<Integer, String> map1=new HashMap<Integer, String>();
		map1.put(1, "Indore");
		map1.put(2, "Bhopal");
		map1.put(3, "Kota");
		res.addResult("cityList", map1);
		return res;
	}

	@PostMapping
	public ResponseEntity<String> createContact(@Valid @RequestBody ContactForm ContactForm) {
		return new ResponseEntity<>("Contact created successfully", HttpStatus.CREATED);
	}
}

