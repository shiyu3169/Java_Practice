import java.util.Random;
import java.util.Scanner;

public class star {
	
	public static void main(String[] args) { 
		//initialize variables
		int user = 999;
		Random rand = new Random();
		int randomNum = rand.nextInt(10) + 1;		
		int input = 0;
		//scan user input
		System.out.println("Please input " + randomNum + " values.");
		System.out.println("one value at each time");
		Scanner scan = new Scanner(System.in);
		
		//initialize array
		int[] anArray;
		anArray = new int[randomNum];
		
		while (input < randomNum) {
			anArray[input] = scan.nextInt();
			input++;
		}
		scan.close();
		//print array out
		System.out.println("The inputed values are listed below");
		int i = 0;
		while (i < randomNum){
			System.out.println(anArray[i]);
			i++;
		}
		//reverse the array
		int j = 0;
		int store = 0;
		while (j < randomNum /2) {
			store = anArray[j];
			anArray[j] = anArray[randomNum - 1 - j];
			anArray[randomNum - 1 - j] = store;
			j++;
		}
		//print reversed array
		System.out.println("The reversed list is showing here");
		int k = 0;
		while (k < randomNum){
			System.out.println(anArray[k]);
			k++;
		}
	}
}