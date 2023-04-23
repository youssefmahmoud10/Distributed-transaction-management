package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entities.DepartmentEntity;
import com.example.demo.entities.UserEntity;
import com.example.demo.models.DtmRequest;
import com.example.demo.repositories.department.DepartmentRepository;
import com.example.demo.repositories.user.UserRepository;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:43:46 AM
 */

@Service
public class DtmService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	public void addUser(DtmRequest dtmRequest) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(dtmRequest.getUserName());
		userRepository.save(userEntity);
		throw new RuntimeException("Runtime Exception");
	}

	public void addDepartment(DtmRequest dtmRequest) {
		DepartmentEntity departmentEntity = new DepartmentEntity();
		departmentEntity.setName(dtmRequest.getDepartmentName());
		departmentRepository.save(departmentEntity);
	}

	@Transactional(value = "chainedTransactionManager")
	public Integer makeDistributedTransaction(DtmRequest dtmRequest) {
		addUser(dtmRequest);
		addDepartment(dtmRequest);
		return 1;
	}

}