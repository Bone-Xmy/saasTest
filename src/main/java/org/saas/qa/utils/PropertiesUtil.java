package org.saas.qa.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream; 
import java.util.Iterator;
import java.util.Properties; 

public class PropertiesUtil{
	Properties prop = new Properties();
	
	//根据key获取property的值
	public String getProperty(String key){	
		try{
			InputStream in = new BufferedInputStream(new FileInputStream("hllQa.sys"));
			prop.load(in);
			//Iterator<String> it = prop.stringPropertyNames().iterator();
			//while(it.hasNext()){
            //    String key=it.next();
            //    System.out.println(key+":"+prop.getProperty(key));
            //}
			String proValue = prop.getProperty(key);
			in.close();
			return proValue;
		}
		catch(Exception e){
			e.printStackTrace();
			return "getProError";
		}
	}
	
	//保存属性到properties
	public void setProperty(String key,String value){
		try{
			FileOutputStream of = new FileOutputStream("hllQa.sys", false);//true表示追加打开
            prop.setProperty(key, value);
            prop.store(of, "The New properties file");
            of.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}