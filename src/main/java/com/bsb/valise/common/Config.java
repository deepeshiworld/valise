package com.bsb.valise.common;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class Config {

	public static <T> void writeJSON(HttpServletResponse res, T t) throws IOException {
		res.setContentType("application/x-javascript");

		Gson gson = new Gson();

		// JSONObject jsonObject = JSONObject.fromObject(map);

		StringBuffer sb = new StringBuffer();
		if (t != null) {
			String jsonObject = gson.toJson(t);
			if (jsonObject.toString() != null && !jsonObject.toString().equals("null")) {
				sb.append(jsonObject.toString());
			}

		} else {
			sb.append("{\"error\" : \"No data found\"}");
		}
		OutputStream os = res.getOutputStream();
		os.write(sb.toString().getBytes());
		os.close();
	}

	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
		return sdf.format(date);

	}

}