package com.bsb.valise.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

public enum Categories {

	TOPWEAR("Topwear", Section.MALE), BOTTOMWEAR("Bottomwear", Section.MALE), SPORTSWEAR("Sportswear", Section.MALE),

	INDIANWEAR("Indianwear", Section.FEMALE), WESTERNWEAR("Westernwear",
			Section.FEMALE), LINGERIE_SLEEPWARE("Lingerie_Sleepware", Section.FEMALE),

	FOOTWEAR("Footwear", Section.ALL),

	UNKNOWN("Unknown", null);

	private static final Map<String, Categories> nameToEnum = new HashMap<>();
	private static final Map<Categories, String> enumToName = new HashMap<>();

	static {
		for (Categories category : Categories.values()) {
			enumToName.put(category, category.getName());
			nameToEnum.put(category.getName(), category);
		}
	}

	private String name;
	private Section section;

	private Categories(String name, Section section) {
		this.name = name;
		this.section = section;
	}

	public String getName() {
		return name;
	}

	public Section getSection() {
		return section;
	}

	@Override
	public String toString() {
		return getName();
	}

	public static Categories getCategoriesByName(String name) {
		if (StringUtils.isEmpty(name)) {
			return Categories.UNKNOWN;
		}
		Categories category = nameToEnum.get(name);
		if (null == category) {
			category = Categories.UNKNOWN;
		}
		return category;
	}

	public static Set<String> getAllCategoriesNames() {
		return nameToEnum.keySet();
	}

	public String toJson() {
		JSONObject obj = toJsonObject();
		return obj.toJSONString();
	}

	@SuppressWarnings("unchecked")
	public JSONObject toJsonObject() {
		JSONObject obj = new JSONObject();
		obj.put("section", getSection());
		obj.put("name", getName());
		return obj;
	}
}
