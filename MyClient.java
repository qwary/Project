package lt.ktu.client.first;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import lt.ktu.client.first.dao.HelloDao;
import lt.ktu.client.first.dao.PersonDao;
import lt.ktu.client.first.dao.impl.RestHelloDao;
import lt.ktu.client.first.dao.impl.RestPersonDao;
import lt.ktu.client.first.model.Person;


public class MyClient {

	private PersonDao personDao;
	private HelloDao helloDao;
	
	private Client client;
	
	public MyClient() {
		// Client creation requires resources and time so don't create a lot of them
		client = ClientBuilder.newClient();
		
		personDao = new RestPersonDao(client);
		helloDao = new RestHelloDao(client);
	}
	
	private void close() {
		client.close();
	}
	
	public static void main(String[] args) {
		MyClient myClient = new MyClient();
		myClient.run();
		// Don't forget to release resources
		myClient.close();
	}
	
	private void run() {
		test1();
//		test2();
//		test3();
	}
	
	private void test1() {
		System.out.println("PLAIN => " + helloDao.getPlainHello());
		System.out.println("XML => " + helloDao.getXmlHello());
		System.out.println("JSON => " + helloDao.getJsonHello());
	}
	
	private void test2() {
		System.out.println(personDao.getPerson(1L));
	}
	
	private void test3() {
		Person person = new Person();
		person.setAge(10);
		person.setFirstName("Test");
		person.setLastName("Testing");
		person.setPersonalCode("TST123");
		
		Person createdPerson = personDao.registerPerson(person);
		System.out.println(createdPerson);
		System.out.println(personDao.getPerson(createdPerson.getId()));
	}

}
