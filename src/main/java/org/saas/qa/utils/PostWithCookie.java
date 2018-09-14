package org.saas.qa.utils;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PostWithCookie {
	public static JSONObject doPost(String url,Map<String,String> formDate){
		HttpClientUtil http = HttpClientUtil.getInstance();
		//获取cookie的信息
		String cookie = new PropertiesUtil().getProperty("emkKey");
		//System.out.println("获取到的cookie值为：" + cookie);
		String response = http.sendHttpPost(url,formDate,cookie);
		//System.out.println(response);
		return JSON.parseObject(response);
	}
}
