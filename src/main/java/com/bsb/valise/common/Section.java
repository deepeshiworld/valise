package com.bsb.valise.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

public enum Section {

	ALL("All"), MALE("Male"), FEMALE("Female"), KIDS("Kids"), OTHERS("Others");

	private static final Map<Section, String> stringToEnum = new HashMap<>();
	private static final Map<String, Section> nameToEnum = new HashMap<>();

	public static Map<String, Section> getLangIdByName() {
		return nameToEnum;
	}

	static {
		for (Section section : Section.values()) {
			stringToEnum.put(section, section.getName());
			nameToEnum.put(section.getName(), section);
		}
	}

	private String name;

	private Section(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public static Section getSectionById(String id) {
		if (StringUtils.isEmpty(id)) {
			return Section.OTHERS;
		}
		Section section = nameToEnum.get(id);
		if (null == section) {
			section = Section.OTHERS;
		}
		return section;
	}

	public static Set<String> getAllSectionNames() {
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
