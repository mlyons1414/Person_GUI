package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public void saveToFile(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Person[] p = people.toArray(new Person[people.size()]);
		
		oos.writeObject(p);
		
		oos.close();
	}
	
	public void loadFromFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		
		try {
			Person[] p = (Person[]) ois.readObject();
			
			people.clear();
			
			people.addAll(Arrays.asList(p));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ois.close();
	}
}
