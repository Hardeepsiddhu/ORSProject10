
package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ContactDAOInt;
import com.rays.dto.ContactDTO;

@Service
@Transactional
public class ContactServiceImpl extends BaseServiceImpl<ContactDTO, ContactDAOInt> implements ContactServiceInt {

	@Autowired
	ContactDAOInt ContactDAO;

}



