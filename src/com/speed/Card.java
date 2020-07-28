package com.speed;

public class Card {
	
	private final String color;
	private final String type;
	private final String val;
	
	public Card(String color, String type, String val) {
//		super();
		this.color = color;
		this.type = type;
		this.val = val;
	}

	
	  public String getColor() { return color; }
	  
//	  public void setColor(String color) { this.color = color; }
	  
	  public String getType() { return type; }
	  
//	  public void setType(String type) { this.type = type; }
	  
	  public String getVal() { return val; }
	  
//	  public void setVal(String val) { this.val = val; }
	 

	@Override
	public String toString() {
		return "Card [color=" + color + ", type=" + type + ", val=" + val + "]";
	}
	
	
	
	
	
	
	

}
