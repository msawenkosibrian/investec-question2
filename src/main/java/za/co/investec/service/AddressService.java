package za.co.investec.service;

import java.util.List;
import java.util.Map;

import za.co.investec.vo.Address;
import za.co.investec.vo.AddressType;

public interface AddressService {

	public String prettyPrintAddress(Address address);
	public List<String> prettyPrintAddress(List<Address> address);
	public List<String> prettyPrintAddress(List<Address> address, AddressType type);
	public List<Error> validateAddress(Address address);
	public Map<Address, List<Error>> validateAddress(List<Address> address);
}
