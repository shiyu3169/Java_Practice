import java.util.Random;
import java.util.Scanner;

public class star {
	
	public static void main(String[] args) { 
		//initialize variables
		int user = 999;
		Random rand = new Random();
		String keep = "";
		//scan user input
		System.out.println("The answer is a random number from 1 to 100");
		System.out.println("please guess and input the number. (enter '0' to quit the game");
		Scanner scan = new Scanner(System.in);
		//start game
		while (true) {
			//random number
			int randomNum = rand.nextInt(100) + 1;			
			//counter
			int c = 0;
			while(true) {
				//user input
				if (scan.hasNextInt()) {
					user = scan.nextInt();
				}
				else {
					System.out.println("Invalid input. Game Over!");
					System.out.println("");
					scan.next();
					break;
				}
				
				//repeat guessing
				if (user == 0) {
					System.out.println("Thank you for playing.");
					System.exit(0);
				}
				if (user < randomNum) {
					System.out.println(user +" is smaller than the correct answer, try it again");
					c++;
				}
				if (user > randomNum) {
					System.out.println(user +" is greater than the correct answer, try it again");
					c++;
				}
				if (user == randomNum) {
					System.out.println("Congratuations! "+ user + " is the right answer.");
					System.out.println("Total number of guessing: " + c);
					break;
				}
			}
			System.out.println("Do you want to play it again? Enter 'quit' to leave the game, anything else to try it again");
			keep = scan.next();
			if (keep.equals("quit")){
				System.out.println("Thank you for playing.");
				System.exit(0);
			}
			System.out.println("please guess and input the number. (enter '0' to quit the game, other inputs won't work)");
		}	
	}
}