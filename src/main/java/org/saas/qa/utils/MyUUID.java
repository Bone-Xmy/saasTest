package org.saas.qa.utils;

import java.util.UUID;

public class MyUUID{
	public static String getUUID(){
		String uuid = UUID.randomUUID().toString().toLowerCase();;
		return uuid;
	}
}