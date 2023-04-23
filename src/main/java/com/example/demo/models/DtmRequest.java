package com.example.demo.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author YoussefMahmoud
 * @created Apr 23, 2023-1:41:23 AM
 */

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DtmRequest {

	String userName;
	String departmentName;

}