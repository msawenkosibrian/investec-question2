package za.co.investec.vo;

public enum AddressType {

	PHYSICAL_ADDRESS("Physical Address"),
	POSTAL_ADDRESS("Postal Address"),
	BUSINESS_ADDRESS("Business Address");
	
	private String type;
	
	private AddressType(String type) {
		
		this.type = type;	
	}

	public String getType() {
		
		return type;
	}

	public void setType(String type) {
		
		this.type = type;
	}
}
