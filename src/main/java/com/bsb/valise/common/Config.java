package com.bsb.valise.common;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


public class Config {
	
	public static void writeJSON(HttpServletResponse res, Map<String, ?> map) throws IOException {
		res.setContentType("application/x-javascript");

//		JSONObject jsonObject = JSONObject.fromObject(map);
		String jsonObject=JSONObject.toJSONString(map);
		StringBuffer sb = new StringBuffer();
		if (jsonObject.toString() != null
				&& !jsonObject.toString().equals("null")) {
			sb.append(jsonObject.toString());
		} else {
			sb.append("{\"error\" : \"No data found\"}");
		}
		OutputStream os = res.getOutputStream();
		os.write(sb.toString().getBytes());
		os.close();
	}
	
	public static String formatDate(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("MMMM dd HH:mm:ss zzzz yyyy",Locale.ENGLISH);
		return sdf.format(date);
		
	}
}