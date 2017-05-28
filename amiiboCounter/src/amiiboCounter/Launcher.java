package amiiboCounter;

import java.util.Scanner;

public class Launcher {

	private static Loop loop;
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Would you like to use simple commands or wordy commands? (S/W)\n");
        String command = keyboard.nextLine().toLowerCase();
        if(command.equals("s")){
        	loop = new SimpleLoop();
        }
        else if(command.equals("w")){
        	loop = new WordyLoop();
        }
        else {
        	System.out.println("Could not find the type of loop you wanted... Defaulting to WordyLoop...");
        	loop = new WordyLoop();
        }
		loop.startLoop();
	}

}
