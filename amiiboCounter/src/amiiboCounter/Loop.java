package amiiboCounter;

import java.util.Scanner;

public abstract class Loop {

	protected final int MEMORY = 100;
	protected int stackMemory = MEMORY;
	private boolean stop = true;
	protected Scanner keyboard = new Scanner(System.in);
	protected Amiibo unused[];
	protected Amiibo stack[];
	protected Amiibo freed[];
	protected int pointer;
	protected int amiiboDefaults[] = new int[]{80,25,5,5,15,0,0};
	protected int lastAmiibos[] = new int[]{80,25,5,5,15,0,0};
	
	protected String commands[];

	public Loop() {
		System.out.println("The initial values have not been set. Would you like to use the amiibo presets? (Y/N)");
		String answer = keyboard.nextLine().toLowerCase();
		if(answer.equals("y")){
			fillUnused(amiiboDefaults[0],amiiboDefaults[1],amiiboDefaults[2],amiiboDefaults[3],amiiboDefaults[4],amiiboDefaults[5],amiiboDefaults[6]);
		}
		else{
			System.out.println("Please set up the initial values.");
			lastAmiibos = setup();
			fillUnused(lastAmiibos[0],lastAmiibos[1],lastAmiibos[2],lastAmiibos[3],lastAmiibos[4],lastAmiibos[5],lastAmiibos[6]);
		}
		System.out.println("Would you like to use the preset stack size (100)? (Y/N)");
		answer = keyboard.nextLine().toLowerCase();
		if(!answer.equals("y")){
			System.out.println("Please indicate a stack size");
			stackMemory = Integer.parseInt(keyboard.nextLine().toLowerCase());
		}
	}

	protected int[] setup() {
		int amiiboNums[] = new int[7];
		
		System.out.println("How many Guardian Amiibos do you have?");
		amiiboNums[0] = Integer.parseInt(keyboard.nextLine().toLowerCase());
		System.out.println("How many Epona Amiibos do you have?");
		amiiboNums[1] = Integer.parseInt(keyboard.nextLine().toLowerCase());
		System.out.println("How many Fish Amiibos do you have?");
		amiiboNums[2] = Integer.parseInt(keyboard.nextLine().toLowerCase());
		System.out.println("How many NESLink Amiibos do you have?");
		amiiboNums[3] = Integer.parseInt(keyboard.nextLine().toLowerCase());
		System.out.println("How many OOTLink Amiibos do you have?");
		amiiboNums[4] = Integer.parseInt(keyboard.nextLine().toLowerCase());
		System.out.println("How many Zelda Amiibos do you have?");
		amiiboNums[5] = Integer.parseInt(keyboard.nextLine().toLowerCase());
		System.out.println("How many other Amiibos do you have?");
		amiiboNums[6] = Integer.parseInt(keyboard.nextLine().toLowerCase());
		
		return amiiboNums;
	}

	protected void fillUnused(int g, int e, int f, int n, int o, int z,
			int r) {
				unused = new Amiibo[g+e+f+n+o+z+r];
				System.out.println("Creating " + (g+e+f+n+o+z+r) + " Amiibo");
				for(int i=0; i<g; i++){
					unused[i] = new Guardian();
				}
				for(int i=0; i<e; i++){
					unused[i+g] = new Epona();
				}
				for(int i=0; i<f; i++){
					unused[i+g+e] = new Fish();
				}
				for(int i=0; i<n; i++){
					unused[i+g+e+f] = new NESLink();
				}
				for(int i=0; i<o; i++){
					unused[i+g+e+f+n] = new OOTLink();
				}
				for(int i=0; i<z; i++){
					unused[i+g+e+f+n+o] = new Zelda();
				}
				for(int i=0; i<r; i++){
					unused[i+g+e+f+n+o+z] = new Amiibo("Unknown");
				}
			}

	public void startLoop() {
		stack = new Amiibo[stackMemory];
		freed = new Amiibo[Math.max(0,unused.length - stack.length)];
		pointer = 0;
		stop = false;
		System.out.println("\nThe Commands are:");
		listcommands();
		System.out.println("");
		sendLoop();
	}

	protected void sendLoop() {
		boolean checks = true;
		
		checks = !stop;
		if(checks){
			doLoop();
		}
	}
	
	protected abstract void doLoop();

	public void stopLoop() {
		stop = true;
	}

	protected boolean take(Amiibo[] array, Amiibo amiibo) {
		for(int i=0; i < array.length; i++){
			if(array[i] != null && array[i].getType().equals(amiibo.getType())){
				array[i] = null;
				return true;
			}
		}
		return false;
	}

	protected void show(String toShow) {
	if(toShow.equals("stack")){
		System.out.print("STACK:");
		print(stack,pointer);
	}
	else if(toShow.equals("freed")){
		System.out.print("FREED:");
		print(freed,0);
	}
	else if (toShow.equals("unused")){
		System.out.print("UNUSED:");
		print(unused,0);
	}
	else{
		if(!(toShow.equals("all") || toShow.equals("everything"))){
			System.out.print("Error: Showing ");
		}
		System.out.print("Everything");
		System.out.print("UNUSED:");
		print(unused,0);
		System.out.print("\nSTACK:");
		print(stack,pointer);
		System.out.print("\nFREED:");
		print(freed,0);
		}
	}

	protected void listcommands() {
		for(int i=0; i < commands.length; i++){
			System.out.println(commands[i]);
		}
	}

	private void print(Amiibo[] array, int start) {
		int written = 0;
		String toPrint = "";
		for(int i = 0; i < array.length; i++){
			if(array[(i + start)%array.length] != null){
				toPrint += array[(i + start)%array.length].getType() + "		|	";
				written ++;
				if (written%5 == 0){
					toPrint += "\n";
				}
			}
		}
		System.out.println("(" + written + " items)");
		System.out.print(toPrint);
		
	}

	protected void add(String type) {
		Amiibo toAdd;
		switch(type){
		case "guardian":
			toAdd = new Guardian();
			break;
		case "epona":
			toAdd = new Epona();
			break;
		case "fish":
			toAdd = new Fish();
			break;
		case "neslink":
			toAdd = new NESLink();
			break;
		case "ootlink":
			toAdd = new OOTLink();
			break;
		case "zelda":
			toAdd = new Zelda();
			break;
		default:
			toAdd = new Amiibo(type);
		}
		if(!take(unused,toAdd)){
			System.out.println("\nThe specified Amiibo could not be found in the unused collection.");
			System.out.println("Would you like to check the freed collection? (Y/N)");
			String answer = keyboard.nextLine().toLowerCase();
			if(answer.equals("y")){
				if(!take(freed,toAdd)){
					System.out.println("\nThe specified Amiibo could not be found in the freed collection.");
					System.out.println("Would you like to add an unspecified Amiibo? (Y/N)");
					answer = keyboard.nextLine().toLowerCase();
					if(!answer.equals("y")){
						return;
					}
				}
			}
			else{
				System.out.println("Would you like to add an unspecified Amiibo? (Y/N)");
				answer = keyboard.nextLine().toLowerCase();
				if(!answer.equals("y")){
					return;
				}
			}
		}
	
		String extra = "";
		if(pointer >= stack.length){
			int i = 0;
			while (freed[i] != null && i < freed.length){
				i ++;
				if(i >= freed.length){
					System.out.println("\nThere seems to have been an error freeing an amiibo");
				}
			}
			freed[i] = stack[pointer%stack.length];
			extra = "\n" + stack[pointer%stack.length].getType() + " was freed from stack";
			
		}
		
		stack[pointer%stack.length] = toAdd;
		System.out.println(toAdd.getType() + " (" + pointer + ")" + extra);
		pointer ++;
		
	
	}

}