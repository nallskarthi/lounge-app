package com.qantas.lounge.model;

public class Airport {
	private String code;
    private String name;

    public Airport()
    {
    	
    }
    public Airport(String code, String name) {
        this.code = code;
        this.name = name;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String id) {
		this.code = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
