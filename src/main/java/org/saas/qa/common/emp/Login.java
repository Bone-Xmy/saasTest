package org.saas.qa.common.emp;

import org.saas.qa.utils.HttpClientUtil;
import org.saas.qa.utils.PropertiesUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.*;

public class Login {
	private String url = "/saas/emp/Login.ajax";
	private Map<String,String> formDate;
	
	public Login(Map<String,String> formDate){
		this.formDate = formDate;
	}
	
	public JSONObject doing(){
		HttpClientUtil http = HttpClientUtil.getInstance();
		String response = http.sendHttpPost(url,formDate);
		//System.out.println(response);
		JSONObject jsonObj = JSON.parseObject(response);
		JSONArray jsonArr = jsonObj.getJSONObject("data").getJSONArray("records");
		for(Object object : jsonArr){
			JSONObject jsonRecords = (JSONObject)object;
			String empToken = jsonRecords.getString("empToken");
			//System.out.println("empKey ==> " + empToken);
			new PropertiesUtil().setProperty("emkKey",empToken);
		}
		return jsonObj;
	}
}
