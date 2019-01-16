package fr.insat.om2m.tp2.test;

import org.eclipse.om2m.commons.resource.AE;

import fr.insat.om2m.tp2.mapper.Mapper;
import fr.insat.om2m.tp2.mapper.MapperInterface;

public class MapperTest {

	public static void main(String[] args) {
		MapperInterface mapper = new Mapper();

		// example to test marshal operation
		AE ae = new AE();
		ae.setRequestReachability(false); 
		System.out.println(mapper.marshal(ae));
		
		
		// get the XML representation, parse it with unmarshal operation
		Object unmarshaled = new Object();
		unmarshaled = mapper.unmarshal("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + 
				"<m2m:ae xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" + 
				"    <rr>false</rr>\n" + 
				"</m2m:ae>");
		System.out.println(unmarshaled);
	}
	
}
