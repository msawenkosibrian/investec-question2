package za.co.investec;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import za.co.investec.service.AddressService;
import za.co.investec.service.impl.AddressServiceImpl;
import za.co.investec.vo.Address;
import za.co.investec.vo.AddressType;
import za.co.investec.vo.Error;


public class Driver {
	
	public static void main(String[] args) {
		
		ClassLoader classLoader = Driver.class.getClassLoader();
		File file = new File(classLoader.getResource("addresses.json").getFile());
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Address> addresses = mapper.readValue(file, new TypeReference<List<Address>>(){});
			AddressService addressService = new AddressServiceImpl();
			// Pretty print all addresses
			addressService.prettyPrintAddress(addresses);
			System.out.println("");
			
			// Pretty print an address of a certain type
			addressService.prettyPrintAddress(addresses, AddressType.BUSINESS_ADDRESS);
			System.out.println("");
			
			// Validate addresses
			for (Address address: addresses) {
				List<Error> errors = addressService.validateAddress(address);
				if (errors.size() > 0) {
					System.out.println(String.format("id: %s", address.getId()));
					for (Error error: errors) {
						System.out.println(error.getMessage());
					}
				}
				System.out.println("---");
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
