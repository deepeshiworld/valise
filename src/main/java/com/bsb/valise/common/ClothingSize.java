package com.bsb.valise.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

public enum ClothingSize{

	SMALL("small","S"),
	MEDIUM("medium","M"),
	LARGE("large","L"),
	EXTRALARGE("extralarge","XL");

	private static final Map<ClothingSize, String> stringToEnum = new HashMap<>();
	private static final Map<String, ClothingSize> nameToEnum = new HashMap<>();

	static {
		for (ClothingSize size : ClothingSize.values()) {
			stringToEnum.put(size, size.getName());
			nameToEnum.put(size.getName(), size);
		}
	}

	private String name;
	private String size;

	private ClothingSize(String name,String size) {
		this.name = name;
		this.size=size;
	}

	public String getName() {
		return name;
	}
	
	public String getSize() {
		return size;
	}

	@Override
	public String toString() {
		return getSize();
	}

	public static ClothingSize getSizeByName(String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		ClothingSize size = nameToEnum.get(name);
		return size;
	}

	public static Set<String> getAllSizes() {
		return nameToEnum.keySet();
	}

	public String toJson() {
		JSONObject obj = toJsonObject();
		return obj.toJSONString();
	}

	@SuppressWarnings("unchecked")
	public JSONObject toJsonObject() {
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		return obj;
	}
}
