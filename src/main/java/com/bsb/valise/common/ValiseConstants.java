package com.bsb.valise.common;

public class ValiseConstants {

	public static final String VALISE_CONTENT_TYPE_JSON = "application/json";
	
	public static final String VALISE_DB_HOST = "localhost";
	
	public static final String VALISE_DB = "valise";
	public static final String USERS_COLLECTION = "users";
	public static final String PRODUCTS_COLLECTION = "products";
	
	public static final String REDIS_VALISE_KEY_FORMAT = "cc_msisdn:%s";

	public static final int REDIS_EXPIRY_DURATION_6_HOURS = 6 * 60 * 60; // 6
																			// hours
	public static final int VALISE_CONNECTION_TO_MILLIS = 1 * 1000;
	public static final int VALISE_SOCKET_TO_MILLIS = 5 * 1000;

	public static final int GLOBAL_REDIS_EXPIRY_DURATION_24_HOURS = 24 * 60 * 60; // 6
}
