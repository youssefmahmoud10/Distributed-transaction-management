package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.DtmRequest;
import com.example.demo.services.DtmService;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:49:42 AM
 */

@RestController
@RequestMapping("dtmController") //http://localhost:8080/dtmController/makeDistributedTransaction
public class DtmController {

	@Autowired
	private DtmService dtmService;

	@CrossOrigin
	@PostMapping(path = "/addUser")
	public void addUser(@RequestBody DtmRequest dtmRequest) {
		dtmService.addUser(dtmRequest);
	}

	@CrossOrigin
	@PostMapping(path = "/addDepartment")
	public void addDepartment(@RequestBody DtmRequest dtmRequest) {
		dtmService.addDepartment(dtmRequest);
	}

	@CrossOrigin
	@PostMapping(path = "/makeDistributedTransaction")
	public Integer makeDistributedTransaction(@RequestBody DtmRequest dtmRequest) {
		return dtmService.makeDistributedTransaction(dtmRequest);
	}

}