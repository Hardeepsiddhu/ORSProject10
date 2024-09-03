package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ContactDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class ContactForm extends BaseForm {

	@Size(min = 2, max = 30, message = "Name must greater than 2 letter and upto 50")
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid name format")
	@NotEmpty(message = "Please enter Name ")
	private String name;

	@NotEmpty(message = "Please enter contactNo")
	@Pattern(regexp = "(^$|^[6-9]\\d{9}$)", message = "Invalid input for mobile")
	private String mobileNo;

	@NotEmpty(message = "Please enter  date of birth")
	@ValidDate(message = "enter current or previous date")
	private String dob;

	private String cityName;

	@NotEmpty(message = "Please enter cityId")
	@ValidLong(message = "Invalid input for cityId", allowEmpty = true)
	@Min(value = 1, message = "cityId should be greater than 0")
	private String cityId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	@Override
	public BaseDTO getDto() {
		ContactDTO dto = initDTO(new ContactDTO());

		if (mobileNo != null && !mobileNo.isEmpty()) {
			dto.setMobileNo(Long.valueOf(mobileNo));
		}

		if (cityId != null && !cityId.isEmpty()) {
			dto.setCityId(Long.valueOf(cityId));
		}
		dto.setName(name);

		if (dob != null && !dob.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(dob);
				dto.setDob(parsedDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}
}
