package amiiboCounter;

public class SimpleLoop extends Loop {

	public SimpleLoop(){
		super();
		commands = new String[]{"g:	adds a guardian to the stack","e:	adds an epona to the stack","f:	adds a fish to the stack",
				"n:	adds an 8-bit/neslink to the stack","o:	adds an ootlink to the stack","z:	adds a zelda to the stack",
				"x:	adds a generic amiibo to the stack","sa:	shows all lists (unused, stack, and freed)","ss:	shows the stack",
				"su:	shows the unused list","sf:	shows the freed list","r:	resets all values (stack, freed, and promtps concerning unused)",
				"c:	lists the commands (this list)"};
	}
	
	public void doLoop(){
		System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();
        System.out.println("");
        try{
        	switch(command){
        		case "g":
        			System.out.print("Adding: ");
        			add("guardian");
        			break;
        		case "e":
        			System.out.print("Adding: ");
        			add("epona");
        			break;
        		case "f":
        			System.out.print("Adding: ");
        			add("fish");
        			break;
        		case "n":
        			System.out.print("Adding: ");
        			add("neslink");
        			break;
        		case "o":
        			System.out.print("Adding: ");
        			add("ootlink");
        			break;
        		case "z":
        			System.out.print("Adding: ");
        			add("zelda");
        			break;
        		case "x":
        			System.out.print("Adding: ");
        			add("generic");
        			break;
        		case "sa":
        			System.out.print("Showing: ");
        			show("all");
        			break;
        		case "ss":
        			System.out.print("Showing: ");
        			show("stack");
        			break;
        		case "su":
        			System.out.print("Showing: ");
        			show("unused");
        			break;
        		case "sf":
        			System.out.print("Showing: ");
        			show("freed");
        			break;
        		case "r":
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
        		case "c":
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
