package controller;

import gui.Category;
import gui.FormEvent;
import model.AgeCategory;
import model.DataBase;
import model.EmploymentCategory;
import model.GenderCategory;
import model.Person;

public class Controller {
	DataBase db = new DataBase();
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
		if(emp.equals("Employed")) {
			empCat = EmploymentCategory.employed;
		}
		else if(emp.equals("Self-Employed")) {
			empCat = EmploymentCategory.selfemployed;
		}
		else if(emp.equals("Unemployed")) {
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
		
		Person person = new Person(name, occupation, ageCat, empCat, taxID, isUS, genderCat);
		db.addPerson(person);
		
	}
}
