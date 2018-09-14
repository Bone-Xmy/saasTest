package org.saas.qa.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.saas.qa.utils.MyUUID;
import org.saas.qa.utils.PostWithCookie;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class OrderTest{
    //点单结账
    String getTableStatusLst = "/saas/order/getTableStatusLst.ajax";          //获取桌台列表	
    String querytablelocked = "/saas/order/querytablelocked.ajax";          //获取锁台信息	
    String getDeliveryAreaInfo = "/saas/base/getDeliveryAreaInfo.ajax";          //获取配送地址信息	
    String saveCallInCustomerInfo = "/saas/tel/saveCallInCustomerInfo.ajax";          //保存用户电话信息	
    String tableOperation = "/saas/order/tableOperation.ajax";          //桌台操作	
    String tablelocked = "/saas/order/tablelocked.ajax";          //锁台	
    String canceltablelocked = "/saas/order/canceltablelocked.ajax";          //解锁	
    String getOrderByOrderKey = "/saas/order/getOrderByOrderKey.ajax";          //获取订单详情	
    String getSoldOutFoodLst = "/saas/base/getSoldOutFoodLst.ajax";          //获取估清列表	
    String foodOperation = "/saas/order/foodOperation.ajax";          //菜品操作	
    String orderOtherOperation = "/saas/order/orderOtherOperation.ajax";          //账单其它操作	
    String checkRight = "/saas/checkRight.ajax";          //权限校验	
    String dinnerSetFood = "/saas/order/dinnerSetFood.ajax";          //宴会配菜	
    String cancelDinnerSetFood = "/saas/order/cancelDinnerSetFood.ajax";          //取消宴会配菜	
    String submitOrder = "/saas/order/submitOrder.ajax";          //账单提交	
    String getPayTypeLst = "/saas/base/getPayTypeLst.ajax";          //获取三方支付信息	
    String getPaySubjectLst = "/saas/base/getPaySubjectLst.ajax";          //获取支付列表	
    String getDiscountRuleLst = "/saas/base/getDiscountRuleLst.ajax";          //获取折扣信息	
    String orderPaySet = "/saas/order/orderPaySet.ajax";          //支付科目预设	
    String updateOrderHead = "/saas/order/updateOrderHead.ajax";          //修改单头信息	
    String orderDiscountSet = "/saas/order/orderDiscountSet.ajax";          //设置折扣	
    String deductMoney = "/crm/card/deductMoney.ajax";          //会员消费
    String transRevoke = "/crm/card/transRevoke.ajax";          //会员撤销
    String getOrderCheckoutQRCode = "/saas/order/getOrderCheckoutQRCode.ajax";          //主扫、被扫	
    String queryOrderPayStatusResult = "/saas/order/queryOrderPayStatusResult.ajax";          //检查订单状态
    
    @Test
    public void getTableStatusLstTest(){
    	//请求参数
    	Map<String,String> formDate = new HashMap<>();
		formDate.put("areaName","");
		formDate.put("tableName","");
		JSONObject jsonObj = PostWithCookie.doPost(getTableStatusLst,formDate);
		assertEquals("000",jsonObj.getString("code"));
		assertNotNull(jsonObj.getJSONObject("data"));
		/*
		JSONArray jsonArr = jsonObj.getJSONObject("data").getJSONArray("records");
		for(Object object : jsonArr){
			JSONObject jsonRecords = (JSONObject)object;
			String tableName = jsonRecords.getString("tableName");
		//	assert
			System.out.println("tableName ==> " + tableName);
		}*/
    }

    @Test
    public void tableOperationTest(){
    	Map<String,String> formDate = new HashMap<>();
		formDate.put("actionType","KT");
		formDate.put("person","4");
		formDate.put("saasOrderRemark","");
		formDate.put("fromTableName","5");
		formDate.put("empCode","");
		formDate.put("orderSubType","0");
		formDate.put("channelKey","200_meituan");
		formDate.put("channelName","美团外卖");
		formDate.put("userSex","2");
		JSONObject jsonObj = PostWithCookie.doPost(tableOperation,formDate);
		assertEquals("000",jsonObj.getString("code"));
		assertNotNull(jsonObj.getJSONObject("data"));
    }
    
    @Test
    public void submitOrderTest(){
    	Map<String,String> formDate = new HashMap<>();
		formDate.put("actionType","LD");
		formDate.put("submitBatchNo",MyUUID.getUUID());
		formDate.put("hisFlag","0");
		formDate.put("orderJson","5");
    }
}