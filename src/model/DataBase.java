package model;

import java.util.List;
import java.util.ArrayList;

public class DataBase {
	private ArrayList<Person> people;
	public DataBase() {
		people = new ArrayList<Person>();
	}
	
	public void addPerson(Person person) {
		people.add(person);
	}
	
	public List<Person> getPeople() {
		return people;
	}
}
