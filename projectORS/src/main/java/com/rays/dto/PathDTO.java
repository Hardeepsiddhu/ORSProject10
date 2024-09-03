
package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_Path")
public class PathDTO extends BaseDTO {

	@Column(name = "ASSETID_NAME")
    private String assetIdName; 
	
	@Column(name = "ASSET_ID")
	private Long assetId;

	@Column(name = "INITIALIZATION_DATE")
	private Date initializationDate;

	@Column(name = "ROUTE_NAME", length=50)
	private String routeName;

	@Column(name = "PERMITTED_NUMBER", length = 50)
	private Long permittedNumber = null;


		
	@Column(name = "ORG_NAME", length = 50)
	private String orgName;
	
	
	
	

	
	
	public String getAssetIdName() {
		return assetIdName;
	}

	public void setAssetIdName(String assetIdName) {
		this.assetIdName = assetIdName;
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public Date getInitializationDate() {
		return initializationDate;
	}

	public void setInitializationDate(Date initializationDate) {
		this.initializationDate = initializationDate;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Long getPermittedNumber() {
		return permittedNumber;
	}

	public void setPermittedNumber(Long permittedNumber) {
		this.permittedNumber = permittedNumber;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getKey() {
		return id + "";
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
		map.put("routeName", "asc");
		
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}

}

