package fr.insat.om2m.tp2.test;

import java.io.IOException;

import org.eclipse.om2m.commons.resource.AE;

import fr.insat.om2m.tp2.client.*;
import fr.insat.om2m.tp2.mapper.Mapper;
import fr.insat.om2m.tp2.mapper.MapperInterface;
import fr.insat.om2m.tp2.util.RequestLoader;
import obix.io.ObixEncoder;


public class Main {

	public static void main(String[] args) {
		
		Client client = new Client();
		Response response = new Response();
		MapperInterface mapper = new Mapper();
		
		try {
			
			
			
			/*******************************************************************************************************************************
			// Project ressource tree creation
			********************************************************************************************************************************/
			
			
			// Creation Room 1
			AE ae_room1 = new AE();
			//ae_room1.setAppName("AE_Room1");
			ae_room1.setAppID("AE_Room1");
			ae_room1.setName("AE_Room1");
			ae_room1.setRequestReachability(true);
			response=client.create("http://127.0.0.1:8080/~/mn-cse", mapper.marshal(ae_room1), "admin:admin","ty=2");
			System.out.println(response.getRepresentation());
			
			
			// Creation Lamp 
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room1", RequestLoader.getRequestFromFile("create_cnt_lamp.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			// Creation Temp
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room1", RequestLoader.getRequestFromFile("create_cnt_temp.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			// Creation Lum
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room1", RequestLoader.getRequestFromFile("create_cnt_lum.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			// Creation Heater
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room1", RequestLoader.getRequestFromFile("create_cnt_heater.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			// Creation Window
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room1", RequestLoader.getRequestFromFile("create_cnt_window.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			// Creation Presence
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room1", RequestLoader.getRequestFromFile("create_cnt_presence.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			
			
			// Creation Room 2
			AE ae_room2 = new AE();
			//ae_room1.setAppName("AE_Room1");
			ae_room2.setAppID("AE_Room2");
			ae_room2.setName("AE_Room2");
			ae_room2.setRequestReachability(true);
			response=client.create("http://127.0.0.1:8080/~/mn-cse", mapper.marshal(ae_room2), "admin:admin","ty=2");
			System.out.println(response.getRepresentation());
			
			
			// Creation Lamp 
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room2", RequestLoader.getRequestFromFile("create_cnt_lamp.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			// Creation Temp
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room2", RequestLoader.getRequestFromFile("create_cnt_temp.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			// Creation Lum
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room2", RequestLoader.getRequestFromFile("create_cnt_lum.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			// Creation Heater
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room2", RequestLoader.getRequestFromFile("create_cnt_heater.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			// Creation Window
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room2", RequestLoader.getRequestFromFile("create_cnt_window.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			// Creation Presence
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room2", RequestLoader.getRequestFromFile("create_cnt_presence.xml"), "admin:admin", "ty=3");
			System.out.println(response.getRepresentation());
			
			
			
			/*******************************************************************************************************************************
			// Update
			********************************************************************************************************************************/
			// Initialization Presence
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room1/Presence", RequestLoader.getRequestFromFile("initialization_presence.xml"), "admin:admin", "ty=4");
			System.out.println(response.getRepresentation());
			
			// Initialization Temperature
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room1/Temperature", RequestLoader.getRequestFromFile("initialization_temperature.xml"), "admin:admin", "ty=4");
			System.out.println(response.getRepresentation());
			
			// Initialization Temperature
			response=client.create("http://127.0.0.1:8080/~/mn-cse/mn-name/AE_Room1/Luminosity", RequestLoader.getRequestFromFile("initialization_luminosity.xml"), "admin:admin", "ty=4");
			System.out.println(response.getRepresentation());
			
			/*// Creation Salle 1
			AE ae_salle101 = new AE();
			ae_salle101.setName("AE-Salle101");
			ae_salle101.setAppID("AE-Salle101");
			ae_salle101.setRequestReachability(true);
			response=client.create("http://127.0.0.1:8080/~/mn-cse/CAE93161735", mapper.marshal(ae_salle101), "admin:admin","ty=3");
			System.out.println(response.getRepresentation());*/
			
			
			
			
			
		
		} catch(IOException e1)	{
			e1.printStackTrace();
		}
		
	}
}