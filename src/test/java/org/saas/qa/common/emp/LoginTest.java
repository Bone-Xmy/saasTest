package org.saas.qa.common.emp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.HashMap;

public class LoginTest {

	@Test
	public void test(){
		Map<String,String> formDate = new HashMap<>();
		formDate.put("shopName","凯德测试");
		formDate.put("empCode","001");
		formDate.put("empPWD","8888");
		formDate.put("clientType","PC_Web");
		formDate.put("clientVersion","POS_SaaS_V1");		
		JSONObject jsonObj = new Login(formDate).doing();
		assertEquals("000",jsonObj.getString("code"));
		assertNotNull(jsonObj.getJSONObject("data"));
		JSONArray jsonArr = jsonObj.getJSONObject("data").getJSONArray("records");
		for(Object object : jsonArr){
			JSONObject jsonRecords = (JSONObject)object;
			String empToken = jsonRecords.getString("empToken");
		//	assert
			System.out.println("empKey ==> " + empToken);
		}
	}
}
