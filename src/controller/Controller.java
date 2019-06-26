package controller;

import java.util.List;

import gui.Category;
import gui.FormEvent;
import model.AgeCategory;
import model.DataBase;
import model.EmploymentCategory;
import model.GenderCategory;
import model.Person;

public class Controller {
	DataBase db = new DataBase();
	
	public List<Person> getPeople() {
		return db.getPeople();
	}
	
	public void addPerson(FormEvent e) {
		String name = e.getName();
		String occupation = e.getOccupation();
		Category age = e.getAge();
		Category emp = e.getEmp();
		boolean isUS = e.isUsCitizen();
		String taxID = e.getTax();
		String gender = e.getGender();
		
		AgeCategory ageCat = null;
		switch(age.getID()) {
		case 0:
			ageCat = AgeCategory.child;
			break;
		case 1:
			ageCat = AgeCategory.adult;
			break;
		case 2:
			ageCat = AgeCategory.elder;
			break;
		}
		
		EmploymentCategory empCat;
		if(emp.getID() == 0) {
			empCat = EmploymentCategory.employed;
		}
		else if(emp.getID() == 1) {
			empCat = EmploymentCategory.selfemployed;
		}
		else if(emp.getID() == 2) {
			empCat = EmploymentCategory.unemployed;
		}
		else empCat = EmploymentCategory.other;
		
		
		
		GenderCategory genderCat;
		if(gender.equals("Male")) {
			genderCat = GenderCategory.male;
		}
		else {
			genderCat = GenderCategory.female;
		}
		
		Person person = new Person(name, genderCat, occupation, ageCat, empCat, isUS, taxID);
		db.addPerson(person);
		
	}
}
