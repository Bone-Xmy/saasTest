package org.test.saas.common.impl.emp;

import org.test.saas.common.*;
import org.test.saas.utils.HttpClientUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.*;

public class Login{
	
	

	public JSONObject doing(){

		HttpClientUtil http = HttpClientUtil.getInstance();
		String url = "/saas/emp/Login.ajax";
		Map<String,String> formDate = new HashMap<>();
		formDate.put("shopName","凯德测试");
		formDate.put("empCode","001");
		formDate.put("empPWD","8888");
		formDate.put("clientType","PC_Web");
		formDate.put("clientVersion","POS_SaaS_V1");
		
		String response = http.sendHttpPost(url,formDate);
		System.out.println(response);
		JSONObject jsonObj = JSON.parseObject(response);
		return jsonObj;
	}
}
