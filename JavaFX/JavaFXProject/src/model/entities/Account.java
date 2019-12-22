package model.entities;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String type;

	public Account(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}




}
