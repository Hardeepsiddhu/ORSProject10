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
import com.rays.dto.ContactDTO;

@Repository
public class ContactDAOImpl extends BaseDAOImpl<ContactDTO> implements ContactDAOInt {

	@Override
	public Class<ContactDTO> getDTOClass() {
		return ContactDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ContactDTO dto, CriteriaBuilder builder, Root<ContactDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (isNotNull(dto.getDob())) {
			Date searchDate = dto.getDob();

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
			Predicate datePredicate = builder.between(qRoot.get("dob"), startDate, endDate);
			whereCondition.add(datePredicate);
		}

		if (!isZeroNumber(dto.getMobileNo())) {
			whereCondition.add(builder.equal(qRoot.get("mobileNo"), dto.getMobileNo()));
		}

		if (!isZeroNumber(dto.getCityId())) {
			whereCondition.add(builder.equal(qRoot.get("cityId"), dto.getCityId()));
		}

		if (!isEmptyString(dto.getCityName())) {
			whereCondition.add(builder.like(qRoot.get("cityName"), dto.getCityName() + "%"));
		}

		return whereCondition;
	}
}

