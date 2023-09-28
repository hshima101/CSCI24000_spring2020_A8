//import java.util.Scanner;
//import java.io.Serializable;

//set up class to be serializable
//public class Turtle extends Pet implements java.io.Serializable{
public class Turtle extends Pet implements java.io.Serializable{
	
	String Name = null;
	int hunger = 90;
	int happiness = 90;

//	Scanner input = new Scanner(System.in);
	
	public Turtle(){
		this.Name = null;
		this.hunger = 0;
		this.happiness = 0;
	}

	public Turtle(String Name, int hunger, int happiness){
		this.Name = Name;
		this.happiness = happiness;
		this.hunger = hunger;
	}

	public void name(){
		System.out.println("Your Turtles name is " + Name);
	}
//tell the pet hunger levels
	public void eat(){
		System.out.println("You fed " + getName());
		hunger = hunger + 10;
		setHunger(hunger);
		System.out.println("Hunger:" + getHunger());
	}

	public void play(){
		System.out.println("You played with " + getName());
		happiness = happiness + 10;
		setHappiness(happiness);
		System.out.println("Happiness:" + getHappiness());
	}

	public void sleep(){
		System.out.println(getName() + " is sleeping");
		happiness = happiness - 10;
		hunger = hunger - 10;
		setHunger(hunger);
		setHappiness(happiness);
		System.out.println("Hunger:" + getHunger());
		System.out.println("Happiness:" + getHappiness());
	
	}	

	public void setName(String Name){
		this.Name = Name;
		}

	public String getName(){
		return Name;
		}
	
	public void setHunger(int hunger){
		this.hunger = hunger;
		}

	public int getHunger(){
		return hunger;
		}
	
	public void setHappiness(int happiness){
		this.happiness = happiness;
		}

	public int  getHappiness(){
		return happiness;
		}		
}//end class
