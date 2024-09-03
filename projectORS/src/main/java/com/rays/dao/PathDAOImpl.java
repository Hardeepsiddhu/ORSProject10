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
import com.rays.dto.PathDTO;

@Repository
public class PathDAOImpl extends BaseDAOImpl<PathDTO> implements PathDAOInt {

	@Override
	public Class<PathDTO> getDTOClass() {
		return PathDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(PathDTO dto, CriteriaBuilder builder, Root<PathDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (!isEmptyString(dto.getRouteName())) {
			whereCondition.add(builder.like(qRoot.get("routeName"), dto.getRouteName() + "%"));
		}

		if (isNotNull(dto.getInitializationDate())) {
			Date searchDate = dto.getInitializationDate();

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
			Predicate datePredicate = builder.between(qRoot.get("initializationDate"), startDate, endDate);
			whereCondition.add(datePredicate);
		}

		if (!isZeroNumber(dto.getPermittedNumber())) {
			whereCondition.add(builder.equal(qRoot.get("permittedNumber"), dto.getPermittedNumber()));
		}

		if (!isZeroNumber(dto.getAssetId())) {
			whereCondition.add(builder.equal(qRoot.get("assetId"), dto.getAssetId()));
		}

		if (!isEmptyString(dto.getAssetIdName())) {
			whereCondition.add(builder.like(qRoot.get("assetIdName"), dto.getAssetIdName() + "%"));
		}

		return whereCondition;
	}
}

