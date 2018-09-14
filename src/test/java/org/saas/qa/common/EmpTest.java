package org.saas.qa.common;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.saas.qa.utils.HttpClientUtil;
import org.saas.qa.utils.PostWithCookie;
import org.saas.qa.utils.PropertiesUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class EmpTest{
	String login = "/saas/emp/Login.ajax";

	@Test
	public void loginTest(){
		Map<String,String> formDate = new HashMap<>();
		formDate.put("shopName","凯德测试");
		formDate.put("empCode","001");
		formDate.put("empPWD","8888");
		formDate.put("clientType","PC_Web");
		formDate.put("clientVersion","POS_SaaS_V1");
		HttpClientUtil http = HttpClientUtil.getInstance();
		String response = http.sendHttpPost(login,formDate);
		JSONObject jsonObj = JSON.parseObject(response);
		assertEquals("000",jsonObj.getString("code"));
		assertNotNull(jsonObj.getJSONObject("data"));
		JSONArray jsonArr = jsonObj.getJSONObject("data").getJSONArray("records");
		for(Object object : jsonArr){
			JSONObject jsonRecords = (JSONObject)object;
			String empToken = jsonRecords.getString("empToken");
			//System.out.println("empKey ==> " + empToken);
			new PropertiesUtil().setProperty("emkKey",empToken);
		}
	}
}