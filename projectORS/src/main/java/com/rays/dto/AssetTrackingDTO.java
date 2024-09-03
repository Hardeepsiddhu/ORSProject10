package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_ASSETTRACKING")
public class AssetTrackingDTO extends BaseDTO{

	
	@Column(name = "LONGITUDE")
	private Double longitude;


	@Column(name = "LATITUDE")
	private Double latitude;

	@Column(name = "TRACKING_DATE")
	private Date trackingDate;

	@Column(name = "ASSETID_NAME")
    private String assetIdName; 
	
	@Column(name = "ASSET_ID")
	private Long assetId;

	
		


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public String getAssetIdName() {
		return assetIdName;
	}


	public void setAssetIdName(String assetIdName) {
		this.assetIdName = assetIdName;
	}


	public Date getTrackingDate() {
		return trackingDate;
	}


	public void setTrackingDate(Date trackingDate) {
		this.trackingDate = trackingDate;
	}




	
	public Long getAssetId() {
		return assetId;
	}


	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	@Column(name = "ORG_NAME", length = 50)
	private String orgName;


	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+ "";
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "orgName";
	}


	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "orgName";
	}


	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return "orgName";
	}


	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "orgName";
	}


	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("assetId", "asc");
		return map;
	}


	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}
	
	

}
