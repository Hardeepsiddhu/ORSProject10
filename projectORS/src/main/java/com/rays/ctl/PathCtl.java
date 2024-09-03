

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
import com.rays.dto.PathDTO;
import com.rays.form.PathForm;
import com.rays.service.PathServiceInt;

@RestController
@RequestMapping(value = "Path")
public class PathCtl extends BaseCtl<PathForm, PathDTO, PathServiceInt> {

	
	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
	
		
		HashMap<Integer, String> map1=new HashMap<Integer, String>();
		map1.put(1, "as222");
		map1.put(2, "as333");
		map1.put(3, "as444");
		res.addResult("pathList", map1);
		return res;
	}

	@PostMapping
	public ResponseEntity<String> createPath(@Valid @RequestBody PathForm PathForm) {
		return new ResponseEntity<>("Path created successfully", HttpStatus.CREATED);
	}
}

