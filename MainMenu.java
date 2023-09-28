import java.io.*;
import java.util.Scanner;

//public class MainMenu implements Serializable{
public class MainMenu {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
//	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String Name = null;
		int hunger = 100;
		int happiness = 100;
		int choice1 = 0;
		int choice2 = 0;

		boolean keepGoing = true;
		
		System.out.println("Welcome User! Would you like to make a new pet or load an existing pet?");
//		System.out.println("Press 1 to Play. Press 2 to Feed. Press 3 to put to Sleep. Press 4 to end");
		System.out.println("Press 1 to make new pet. Press 2 to load existing pet");
		choice1 = input.nextInt();
		Turtle alpha = new Turtle(Name, hunger, happiness);

		if(choice1 == 1){
			System.out.println("Enter your Turtles Name");
			Name = input.next();
			alpha.setName(Name);	
			alpha.name();
			
			while(keepGoing){
				System.out.println("What do you want to do with your pet?");
				System.out.println("Press 1 to Play. Press 2 to Feed. Press 3 to Sleep. Press 4 to end");
				choice2 = input.nextInt();

				if(choice2 == 1){
					alpha.play();
				}
		
				if(choice2 == 2){
					alpha.eat();
				}

				if(choice2 == 3){
					alpha.sleep();
				}

				if(choice2 == 4){
					try{
					FileOutputStream fileOut = new FileOutputStream("save.dat");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(alpha);
					out.close();
					fileOut.close();
					System.out.println("File has been saved to save.dat");
					} catch (IOException i) {
						i.printStackTrace();
						}
					keepGoing = false;
				}//end if
			}//end while
		} else if(choice1 == 2){
			
			Turtle save = null;
			try{
			FileInputStream fileIn = new FileInputStream("save.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			save = (Turtle) in.readObject();
			in.close();
			fileIn.close();
			} catch(IOException e) {
				e.printStackTrace();
			} catch(ClassNotFoundException c){
				System.out.println("Pet class not found");
				c.printStackTrace();
			}
				
			Name = save.Name;
			hunger = save.hunger;
			happiness = save.happiness;

			Turtle beta = new Turtle(Name, hunger, happiness);
			
			while(keepGoing){
				System.out.println("What do you want to do with your Turtle?");
				System.out.println("Press 1 to Play, Press 2 to Feed, Press 3 to Sleep, Press 4 to End");
				System.out.println("Name:" + Name);
				System.out.println("Hunger:" + beta.getHunger());
				System.out.println("Happiness:" + beta.getHappiness());

				choice2 = input.nextInt();
			
				if(choice2 == 1){
					beta.play();
				}

				if(choice2 == 2){
					beta.eat();
				}

				if(choice2 == 3){
					beta.sleep();
				}

				if(choice2 == 4){
					try{
					FileOutputStream fileOut = new FileOutputStream("save.dat");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(beta);
					out.close();
					fileOut.close();
					System.out.println("File has been saved to save.dat");
					} catch (IOException e) {
						e.printStackTrace();
						}
					keepGoing = false;
				}//end if
	
				}//end while
			}//end else if
		input.close();
	}//end main
}//end class
