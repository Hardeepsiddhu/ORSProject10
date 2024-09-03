package com.rays.ctl;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.AssetTrackingDTO;
import com.rays.form.AssetTrackingForm;
import com.rays.service.AssetTrackingServiceInt;

@RestController
@RequestMapping(value = "AssetTracking")
public class AssetTrackingCtl extends BaseCtl<AssetTrackingForm, AssetTrackingDTO, AssetTrackingServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a123a");
		map.put(2, "b123b");
		map.put(3, "c123c");
		res.addResult("assetTrackingList", map);
		return res;
	}

}
