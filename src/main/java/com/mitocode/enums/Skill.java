package com.mitocode.enums;

public enum Skill {

	JAVA("Java"), NET("Net"), PYTHON("Python"), JAVASCRIPT("Javascript"), GROOVY("Groovy");

	private final String value;

	private Skill(String value) {
		this.value = value;
	}

	public String getDisplayValue() {
		return value;
	}

}
