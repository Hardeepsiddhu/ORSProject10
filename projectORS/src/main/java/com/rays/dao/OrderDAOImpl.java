package com.rays.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.OrderDTO;

@Repository
public class OrderDAOImpl extends BaseDAOImpl<OrderDTO> implements OrderDAOInt {

	@Override
	public Class<OrderDTO> getDTOClass() {
		return OrderDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(OrderDTO dto, CriteriaBuilder builder, Root<OrderDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getCustomerName())) {
			whereCondition.add(builder.like(qRoot.get("customerName"),dto.getCustomerName() + "%"));
		}

		if (isNotNull(dto.getOrderDate())) {
			Date searchDate = dto.getOrderDate();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(searchDate);
			calendar.set(Calendar.HOUR_OF_DAY, 0); // Start of the day
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date startDate = calendar.getTime();

			calendar.set(Calendar.HOUR_OF_DAY, 23); // End of the day
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			Date endDate = calendar.getTime();

			// Create predicate for date range
			Predicate datePredicate = builder.between(qRoot.get("orderDate"), startDate, endDate);
			whereCondition.add(datePredicate);
		}

		if (!isZeroNumber(dto.getTrackingNumber())) {
			whereCondition.add(builder.equal(qRoot.get("trackingNumber"), dto.getTrackingNumber()));
		}

		if (!isZeroNumber(dto.getOrderStatusId())) {
			whereCondition.add(builder.equal(qRoot.get("orderStatusId"), dto.getOrderStatusId()));
		}

		if (!isEmptyString(dto.getOrderStatusName())) {
			whereCondition.add(builder.like(qRoot.get("orderStatusName"),dto.getOrderStatusName() + "%"));
		}

		return whereCondition;
	}
}

