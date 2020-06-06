package com.microservice.objects;

public class UserObject {
	
	private String id ; 
	private String name ;
	private String address;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	public void setid(String id)
	{
		this.id=id;
	}

	public void setname(String name)
	{
		this.name=name;
	}
	

	

}
