package gui;

public class Category {
	private int id;
	private String text;
	
	public Category(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public String toString() {
		return text;
	}
	
	public int getID() {
		return id;
	}
}