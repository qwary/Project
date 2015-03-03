package lt.ktu.client.first.dao;

import lt.ktu.client.first.model.Person;

public interface PersonDao {
	Person registerPerson(Person person);
	Person getPerson(Long id);
}
