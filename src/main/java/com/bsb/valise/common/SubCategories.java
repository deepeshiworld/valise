package com.bsb.valise.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

public enum SubCategories {

	TOPWEAR("Topwear", Section.MEN),
	BOTTOMWEAR("Bottomwear", Section.MEN),
	SPORTSWEAR("Sportswear", Section.MEN),
	INDIANWEAR("Indianwear", Section.WOMEN),
	WESTERNWEAR("Westernwear",Section.WOMEN),
	LINGERIE_SLEEPWARE("Lingerie_Sleepware", Section.WOMEN),

	FOOTWEAR("Footwear", Section.ALL),

	UNKNOWN("Unknown", null);

	private static final Map<String, SubCategories> nameToEnum = new HashMap<>();
	private static final Map<SubCategories, String> enumToName = new HashMap<>();

	static {
		for (SubCategories category : SubCategories.values()) {
			enumToName.put(category, category.getName());
			nameToEnum.put(category.getName(), category);
		}
	}

	private String name;
	private Section section;

	private SubCategories(String name, Section section) {
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

	public static SubCategories getSubCategoriesByName(String name) {
		if (StringUtils.isEmpty(name)) {
			return SubCategories.UNKNOWN;
		}
		SubCategories category = nameToEnum.get(name);
		if (null == category) {
			category = SubCategories.UNKNOWN;
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
