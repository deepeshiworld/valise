package com.bsb.valise.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class CommonUtils {

	private static final Integer MSN_UUV0_SIZE_MAX = Integer.valueOf(17);
	private static final Integer MSN_UUV1_SIZE_MAX = Integer.valueOf(27);
	private static String key;
	public static Map<Integer, List<String>> map = new HashMap<>();

	public static String generateUUID(String msisdn) throws Exception {
		String uuid = null;

		if (!StringUtils.isBlank(msisdn)) {
			msisdn = normalizePhoneNumber(msisdn);
			uuid = String.valueOf(hmacSha1Enc(key, msisdn, MSN_UUV0_SIZE_MAX.intValue())) + "0";
		} else {
			String ip = "x-bsy-ip";
			String keyword = creUuidkeywordV1(ip, Calendar.getInstance());
			if (keyword != null) {
				uuid = String.valueOf(hmacSha1Enc(key, keyword, MSN_UUV1_SIZE_MAX.intValue())) + "1";
			}
		}

		return uuid;

	}

	public static String generateUUIDForChromecastUser(String uuid) throws Exception {
		String newUuid = String.valueOf(hmacSha1Enc(key, uuid, MSN_UUV1_SIZE_MAX.intValue())) + "3";

		return newUuid;
	}

	private static String creUuidkeywordV1(String ip, Calendar calendar) {
		String ua = "android";
		String ips = "";
		List<String> forwardedForHeaderValues = Arrays.asList("172.17.1.23");
		if (forwardedForHeaderValues != null) {
			for (int i = 0; i < forwardedForHeaderValues.size(); i++) {
				String ipObj = forwardedForHeaderValues.get(i);
				ips = String.valueOf(ips) + ipObj;
			}
			ip = String.valueOf(ips) + "," + ip;
		}

		if ((ip == null) || (ua == null) || (calendar == null)) {
			return null;
		}

		int year = calendar.get(1);
		int month = calendar.get(2) + 1;
		int day = calendar.get(5);
		int hour = calendar.get(11);
		int minute = calendar.get(12);
		int second = calendar.get(13);
		return String.valueOf(ua) + ip
				+ String.format("%1$04d%2$02d%3$02d%4$02d%5$02d%6$02d",
						new Object[] { Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day),
								Integer.valueOf(hour), Integer.valueOf(minute), Integer.valueOf(second) });
	}

	private static String hmacSha1Enc(String key, String in, int max) throws Exception {
		if (max > 0) {
			String Base64Data = base64(hmacsha1(key, in));
			String Base64urlencodeData = Base64Data.replace("+", "-").replace("/", "_").replace("=", "");

			if (Base64urlencodeData.length() > max) {
				return Base64urlencodeData.substring(0, max);
			}
			return Base64urlencodeData;
		}

		return "";
	}

	private static byte[] hmacsha1(String key, String in) throws Exception {
		try {
			SecretKeySpec sk = new SecretKeySpec(key.getBytes(), "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(sk);
			return mac.doFinal(in.getBytes());
		} catch (Exception e) {
			throw e;
		}
	}

	private static String base64(byte[] hmacsha1_data) throws Exception {
		String Base64EncodeData = new String(Base64.encodeBase64(hmacsha1_data));

		return Base64EncodeData;
	}

	public static String normalizePhoneNumber(String ph) {
		if (ph == null || ph.isEmpty() || ph.startsWith("+")) {
			return ph;
		}

		try {
			if (containsAlpha(ph)) {
				return ph;
			}
			Phonenumber.PhoneNumber phoneNumber = PhoneNumberUtil.getInstance().parse(ph, "IN");
			return PhoneNumberUtil.getInstance().format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
		} catch (NumberParseException e) {
			// this can also be the case if we use number like "TD-HIKE"
			// fallback to the raw parsing
			if (ph.startsWith("91") && ph.length() == 12) {
				return "+" + ph;
			} else if (ph.length() == 10) {
				return "+91" + ph;
			} else if (ph.length() == 11 && ph.startsWith("0")) // phone number
																// starts with 0
																// e.g.
																// 09811920234
			{
				return "+91" + ph.substring(1, ph.length());
			}
			return ph;
		}

	}

	public static boolean containsAlpha(String str) {
		if (str == null) {
			return false;
		}
		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			if (Character.isLetter(c)) {
				return true;
			}
		}
		return false;
	}

	public static List<String> getSimilarPidList(int index) {
		populateMap();
		return map.get(index);
	}

	public static void populateMap() {
		List<String> list1 = new ArrayList<>();
		// 1
		list1.add("rj15kibpby");
		list1.add("jx3b6ddgf6");
		list1.add("283vxqxthk");
		map.put(1, list1);

		List<String> list2 = new ArrayList<>();
		// 2
		list2.add("rla0k6ts44");
		list2.add("8b1b9gh6lw");
		list2.add("q7vtlgxjjb");
		map.put(2, list2);

		List<String> list3 = new ArrayList<>();
		// 3
		list3.add("yifchtfenc");
		list3.add("2wir20sffy");
		list3.add("xpg3tw8vir");
		map.put(3, list3);

		List<String> list4 = new ArrayList<>();
		// 4
		list4.add("mf71zkwhmf");
		list4.add("zdqlpholf6");
		list4.add("t1piwi83st");
		map.put(4, list4);

		List<String> list5 = new ArrayList<>();

		// 5
		list5.add("ia9j90l52z");
		list5.add("6zy81w52ed");
		list5.add("aznau3v6e1");
		map.put(5, list5);

		List<String> list6 = new ArrayList<>();
		// 6
		list6.add("a653o40h0b");
		list6.add("opkauaywze");
		list6.add("6zy81w52ed");
		map.put(6, list6);

		List<String> list7 = new ArrayList<>();
		// 7
		list7.add("slp1mv02wy");
		list7.add("a0dv68vnbv");
		list7.add("p21sytdewu");
		map.put(7, list7);

		List<String> list8 = new ArrayList<>();
		// 8
		list8.add("ab0vh14o63");
		list8.add("si22hxbv2v");
		list8.add("ovacawb64m");
		map.put(8, list8);

		List<String> list9 = new ArrayList<>();
		// 9
		list9.add("ndwwzhmyro");
		list9.add("rzxrh9vkmd");
		list9.add("ghyt1gs5m3");
		map.put(9, list9);

		List<String> list10 = new ArrayList<>();
		// 10
		list10.add("4d7h5l2egg");
		list10.add("r8ghiah00d");
		list10.add("2vyndwx7bt");
		map.put(10, list10);

	}

	public static int randInt() {

		int min = 0;
		int max = 10;
		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public static int randInt(int min, int max) {

		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public static float randFloat() {
		float minX = 0.0f;
		float maxX = 5.0f;

		Random rand = new Random();

		float finalX = rand.nextFloat() * (maxX - minX) + minX;

		return finalX;
	}
	
	public static String getSizeMapping(String name) {
		Map<String, String> sizeMap = new HashMap<>();
		sizeMap.put("small", "36");
		sizeMap.put("small", "38");
		sizeMap.put("small", "40");
		sizeMap.put("small", "42");

		return sizeMap.get(name);
	}
}
