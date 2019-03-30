package za.co.investec.vo;

import java.io.Serializable;

public class AddressLineDetail implements Serializable {

	private String code;
	private String name;
	
	public String getCode() {
		
		return code;
	}
	
	public void setCode(String code) {
		
		this.code = code;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}	
}
