package gui;
import java.util.EventObject;

public class FormEvent extends EventObject {
	
	private String name;
	private String occupation;
	private Category age;
	private Category emp;
	private String tax;
	private boolean usCitizen;
	private String gender;
	
	
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation, Category age, Category emp, 
			boolean usCitizen, String tax, String gender) {
		super(source);
		this.name = name;
		this.occupation = occupation;
		this.age = age;
		this.emp = emp;
		this.usCitizen = usCitizen;
		this.tax = tax;
		this.gender = gender;
		
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isusCitizen() {
		return usCitizen;
	}

	public void setusCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public void setAge(Category age) {
		this.age = age;
	}

	public void setEmp(Category emp) {
		this.emp = emp;
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
	
	public Category getAge() {
		return age;
	}
	
	public boolean isUsCitizen() {
		return usCitizen;
	}

	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}

	public Category getEmp() {
		return emp;
	}

	
}
