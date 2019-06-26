package model;

import gui.Category;

public class Person {
	private static int count = 0;
	private int id;
	private String name;
	private String occupation;
	private AgeCategory age;
	private EmploymentCategory emp;
	private String tax;
	private boolean usCitizen;
	private GenderCategory gender;
	
	
	public Person(int id, String name, String occupation, AgeCategory age, EmploymentCategory emp, String tax,
			boolean usCitizen, GenderCategory gender) {
		super();
		this.id = count;
		count++;
		this.name = name;
		this.occupation = occupation;
		this.age = age;
		this.emp = emp;
		this.tax = tax;
		this.usCitizen = usCitizen;
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public AgeCategory getAge() {
		return age;
	}
	public void setAge(AgeCategory age) {
		this.age = age;
	}
	public EmploymentCategory getEmp() {
		return emp;
	}
	public void setEmp(EmploymentCategory emp) {
		this.emp = emp;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public boolean isUsCitizen() {
		return usCitizen;
	}
	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}
	public GenderCategory getGender() {
		return gender;
	}
	public void setGender(GenderCategory gender) {
		this.gender = gender;
	}
	
	
}
