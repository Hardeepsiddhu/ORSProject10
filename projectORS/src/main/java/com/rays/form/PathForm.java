package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PathDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class PathForm extends BaseForm {

	@Size(min = 2, max = 30, message = "routeName must greater than 2 letter and upto 50")
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid name format")
	@NotEmpty(message = "Please enter routeName ")
	private String routeName;

	@NotNull(message = "Please enter permittedNumber")
	private Long permittedNumber;

	@NotNull(message = "Please enter initializationDate")
	@PastOrPresent(message = "enter current or previous Date")
	private Date initializationDate;

	private String assetIdName;

	@NotNull(message = "Please enter PathStatusId")
	private Long assetId;

	

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



	public Date getInitializationDate() {
		return initializationDate;
	}



	public void setInitializationDate(Date initializationDate) {
		this.initializationDate = initializationDate;
	}



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



	@Override
	public BaseDTO getDto() {
		PathDTO dto = initDTO(new PathDTO());

		dto.setAssetId(assetId);
		dto.setAssetIdName(assetIdName);
		dto.setPermittedNumber(permittedNumber);
		dto.setRouteName(routeName);
		dto.setInitializationDate(initializationDate);
			
		return dto;
	}
}
