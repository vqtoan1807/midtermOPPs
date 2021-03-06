package Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class DataFile {
	public void exportCustomer(ArrayList<Customer> dataCustomers) {
		StringBuilder builder=new StringBuilder();
		for (Customer customer :dataCustomers) {
			builder.append(customer.getXMLStringofCustomer());
		}
		String bodyString= builder.toString();
		String xmlString ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<CustomerList>\r\n"
					+bodyString
				+ "\n</CustomerList>";
		FileOutputStream fos= null;
		try {
			fos = new FileOutputStream("D:\\Customer.xml");
			byte[] data = xmlString.getBytes();
			fos.write(data);
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (fos!=null) {
			try {
				fos.close();
			}catch (IOException ex) {
				// TODO: handle exception
			}
			}
		}
		}	
	public ArrayList<Customer> importCustomer() {
		ArrayList<Customer> dataCustomers = new ArrayList<>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\Customer.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser =factory.newSAXParser();
			CustomerHandler handler = new CustomerHandler();
			
			parser.parse(fis, handler);
			dataCustomers= handler.getCustomerList();
			
		}catch (FileNotFoundException ex) {
			// TODO: handle exception
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException ex) {
				// TODO: handle exception
			}
		}
		return dataCustomers;
	}
	public void exportRoom(ArrayList<Room> dataRooms) {
		StringBuilder builder=new StringBuilder();
		for (Room rom :dataRooms) {
			builder.append(rom.getXMLStringofRoom());
		}
		String bodyString= builder.toString();
		String xmlString ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<RoomList>\r\n"
					+bodyString
				+ "\n</RoomList>";
		FileOutputStream fos= null;
		try {
			fos = new FileOutputStream("D:\\Room1.xml");
			byte[] data = xmlString.getBytes();
			fos.write(data);
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (fos!=null) {
			try {
				fos.close();
			}catch (IOException ex) {
				// TODO: handle exception
			}
			}
		}
		}
	public ArrayList<Room> importRoom() {
		ArrayList<Room> dataRooms= new ArrayList<>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:\\Room.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser =factory.newSAXParser();
			RoomHandler handler = new RoomHandler();
			
			parser.parse(fis, handler);
			dataRooms= handler.getRoomlList();
			
		}catch (FileNotFoundException ex) {
			// TODO: handle exception
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException ex) {
				// TODO: handle exception
			}
		}
		return dataRooms;
	}
}

