package za.co.investec.service.impl;

import java.util.ArrayList;
import java.util.List;

import za.co.investec.service.AddressService;
import za.co.investec.util.NumberUtils;
import za.co.investec.util.StringUtils;
import za.co.investec.vo.Address;
import za.co.investec.vo.AddressType;
import za.co.investec.vo.Error;

public class AddressServiceImpl implements AddressService {
	
	private static final String ERROR_POSTAL_CODE = "Please provide postal code";
	private static final String ERROR_INVALID_POSTAL_CODE = "Invalid postal code";
	private static final String ERROR_INVALID_COUNTRY = "Please provide country";
	private static final String ERROR_INVALID_COUNTRY_CODE = "Invalid country code";
	private static final String ERROR_INVALID_COUNTRY_NAME = "Invalid country name";
	private static final String ERROR_INVALID_LINE_ADDRESS = "Please provide atleast one line address";
	private static final String ERROR_INVALID_POSTAL_ADDRESS = "Please provide postal address";
	private static final String ERROR_INVALID_POSTAL_ADDRESS_CODE = "Invalid postal address code";
	private static final String ERROR_INVALID_POSTAL_ADDRESS_NAME = "Invalid postal address name";
	

	public String prettyPrintAddress(Address address) {
		
		assert (address != null);
		return address.toString();
	}

	public void prettyPrintAddress(List<Address> addresses) {
		
		for (Address address: addresses) {
			System.out.println(prettyPrintAddress(address));
		}
	}

	public void prettyPrintAddress(List<Address> addresses, AddressType type) {
		
		for (Address address: addresses) {
			if (address.getType().equals(type.getType())) {
				System.out.println(prettyPrintAddress(address));
			}
		}
	}

	public List<Error> validateAddress(Address address) {
		
		List<Error> errors = new ArrayList<Error>();
		
		// Postal code
		if (StringUtils.isEmpty(address.getPostalCode())) {
			Error error = new Error();
			error.setMessage(ERROR_POSTAL_CODE);
			errors.add(error);
		}
		else if (!NumberUtils.isNumeric(address.getPostalCode())) {
			Error error = new Error();
			error.setMessage(ERROR_INVALID_POSTAL_CODE);
			errors.add(error);
		}
		// Country
		if (address.getCountry() == null) {
			Error error = new Error();
			error.setMessage(ERROR_INVALID_COUNTRY);
			errors.add(error);
		}
		else if (NumberUtils.isNumeric(address.getCountry().getCode())) {
			Error error = new Error();
			error.setMessage(ERROR_INVALID_COUNTRY_CODE);
			errors.add(error);
		}
		else if (StringUtils.isEmpty(address.getCountry().getName())) {
			Error error = new Error();
			error.setMessage(ERROR_INVALID_COUNTRY_NAME);
			errors.add(error);
		}
		// Line Address
		if (address.getAddressLineDetail() == null && StringUtils.isEmpty(address.getAddressLineDetail().getLine1()) && StringUtils.isEmpty(address.getAddressLineDetail().getLine1())) {
			Error error = new Error();
			error.setMessage(ERROR_INVALID_LINE_ADDRESS);
			errors.add(error);
			
		}
		// ZA 
		if (address.getCountry() != null && address.getCountry().getCode().equalsIgnoreCase("ZA")) {
			if (address.getProvinceOrState() == null) {
				Error error = new Error();
				error.setMessage(ERROR_INVALID_POSTAL_ADDRESS);
				errors.add(error);
			}
			else if (NumberUtils.isNumeric(address.getProvinceOrState().getCode())) {
				Error error = new Error();
				error.setMessage(ERROR_INVALID_POSTAL_ADDRESS_CODE);
				errors.add(error);
			}
			else if (StringUtils.isEmpty(address.getProvinceOrState().getName())) {
				Error error = new Error();
				error.setMessage(ERROR_INVALID_POSTAL_ADDRESS_NAME);
				errors.add(error);
			}
		}
		return errors;
	}
}
