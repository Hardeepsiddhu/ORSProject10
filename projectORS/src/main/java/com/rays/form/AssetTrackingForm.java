package com.rays.form;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AssetTrackingDTO;
import com.rays.validation.ValidDate;

public class AssetTrackingForm extends BaseForm {

	@NotNull(message = "Please enter longitude")
	private Double longitude;
	
	@NotNull(message = "Please enter latitude")

	private Double latitude;

	@NotNull(message = "Please enter assetId")
	private Long assetId;

	private String assetIdName;

	@NotNull(message = "Please enter trakingDate")
	@ValidDate(message = "Invalid date format or value")
	private String trackingDate;

	
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

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getAssetIdName() {
		return assetIdName;
	}

	public void setAssetIdName(String assetIdName) {
		this.assetIdName = assetIdName;
	}

	public String getTrackingDate() {
		return trackingDate;
	}

	public void setTrackingDate(String trackingDate) {
		this.trackingDate = trackingDate;
	}

	@Override
	public BaseDTO getDto() {

		AssetTrackingDTO dto = initDTO(new AssetTrackingDTO());

		dto.setAssetId(assetId);
		dto.setLongitude(longitude);
		dto.setLatitude(latitude);
		dto.setAssetIdName(assetIdName);
		if (trackingDate != null && !trackingDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(trackingDate);
				dto.setTrackingDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}

		return dto;
	}

}