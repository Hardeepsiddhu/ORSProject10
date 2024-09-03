package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.OrderDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class OrderForm extends BaseForm {

	@Size(min = 2, max = 30, message = "CustomerName must greater than 2 letter and upto 50")
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid name format")
	@NotEmpty(message = "Please enter Name ")
	private String customerName;

	@NotNull(message = "Please enter trackingNumber")
	//@Pattern(regexp = "(^$|^[6-9]\\d{9}$)", message = "Invalid input for trackingNumber")
	private Long trackingNumber;

	@NotEmpty(message = "Please enter orderDate")
	@ValidDate(message = "enter current or previous date")
	private String orderDate;

	private String orderStatusName;

	@NotNull(message = "Please enter orderStatusId")
		private Long orderStatusId;

	
	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	
	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderStatusName() {
		return orderStatusName;
	}


	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}


	
	public Long getOrderStatusId() {
		return orderStatusId;
	}


	public void setOrderStatusId(Long orderStatusId) {
		this.orderStatusId = orderStatusId;
	}


	public void setTrackingNumber(Long trackingNumber) {
		this.trackingNumber = trackingNumber;
	}


	@Override
	public BaseDTO getDto() {
		OrderDTO dto = initDTO(new OrderDTO());

				dto.setCustomerName(customerName);
				dto.setTrackingNumber(trackingNumber);
				dto.setOrderStatusName(orderStatusName);
				dto.setOrderStatusId(orderStatusId);

		if (orderDate != null && !orderDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(orderDate);
				dto.setOrderDate(parsedDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}
}
