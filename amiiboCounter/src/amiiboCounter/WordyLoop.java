package amiiboCounter;

public class WordyLoop extends Loop {
	public WordyLoop(){
		super();
		commands = new String[]{"add [amiibo-type]: adds an amiibo to the stack"
				+ "\n	(from the unused array of amiibos or from the freed list if there are none in the unused list)"
				+ "\n	(guardian, epona, fish, neslink, ootlink, zelda, other)",
				"show [list-name]: shows the contents of a given list"
				+ "\n	(unused, stack, or freed, all/everything, if none of these, then all will be shown)",
				"reset: resets all values "
				+ "\n	(new empty arrays for stack and freed lists and prompts for new amiibo values for the unused list and new stack size)",
				"commands: returns a list of commands"
				+ "\n	(this list)"};
	}
	
	protected void doLoop(){
		System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();
        System.out.println("");
        try{
        	switch(command.split(" ")[0]){
        		case "add":
        			System.out.print("Adding: ");
        			add(command.split(" ")[1]);
        			break;
        		case "show":
        			System.out.print("Showing: ");
        			String arg = "";
        			if(command.split(" ").length > 1){
        				arg = command.split(" ")[1];
        			}
        			show(arg);
        			break;
        		case "reset":
        			System.out.println("resetting...");
        			System.out.println("Would you like to use the presets? (Y/N)");
        			String answer = keyboard.nextLine().toLowerCase();
        			if(answer.equals("y")){
        				fillUnused(amiiboDefaults[0],amiiboDefaults[1],amiiboDefaults[2],amiiboDefaults[3],amiiboDefaults[4],amiiboDefaults[5],amiiboDefaults[6]);
        				stackMemory = MEMORY;
        			}
        			else{
        				System.out.println("Would you like to use last time's amiibo values? (Y/N)");
        				answer = keyboard.nextLine().toLowerCase();
        				if(answer.equals("y")){
        					fillUnused(lastAmiibos[0],lastAmiibos[1],lastAmiibos[2],lastAmiibos[3],lastAmiibos[4],lastAmiibos[5],lastAmiibos[6]);
        				}
        				else{
        					System.out.println("Please set up the initial values.");
        					lastAmiibos = setup();
        					fillUnused(lastAmiibos[0],lastAmiibos[1],lastAmiibos[2],lastAmiibos[3],lastAmiibos[4],lastAmiibos[5],lastAmiibos[6]);
        				}
        				System.out.println("Would you like to use last time's stack size (" + stackMemory + ")? (Y/N)");
        				answer = keyboard.nextLine().toLowerCase();
        				if(!answer.equals("y")){
        					System.out.println("Please indicate a stack size");
        					stackMemory = Integer.parseInt(keyboard.nextLine().toLowerCase());
        				}
        			}
        			startLoop();
        			break;
        		case "commands":
        			System.out.println("The commands are:");
        			listcommands();
        			break;
        		default:
        			System.out.println("Hello; this is the default response... perhaps you should learn to use commands better? (Y/N)");
        			answer = keyboard.nextLine().toLowerCase();
        			if(answer.equals("y")){
        				listcommands();
        			}
        		}
        	System.out.println("");
        }
        catch(NullPointerException e){
        	System.out.println("There seems to have been an issue");
        }
        
		sendLoop();
	}
}
