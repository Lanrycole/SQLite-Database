package com.example.tutorialtests.Model;
public class Contact {
	private int id;
	private String name;
	private String phoneNum;

	public Contact() {}

	public int getId() {
		return id;
	}

	public Contact(int id,String name,String phoneNum) {
		this.id = id;
		this.name = name;
		this.phoneNum = phoneNum;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNum;
	}

	public void setPhoneNumber(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"id=" + getId() +
				", name='" + getName() + '\'' +
				", phoneNum='" + getPhoneNumber() + '\'' +
				'}';
	}


}
