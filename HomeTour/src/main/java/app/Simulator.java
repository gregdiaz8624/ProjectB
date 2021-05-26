package app;

import java.util.Scanner;

import models.Room;

public class Simulator {
	/* 
	 * We only need one room manager
	 * so we can make it static
	 */
	private static RoomManager manager = new RoomManager(9);

	// Same goes for our player...
	private static Player player = new Player();

	/* 
	 * Boolean used to determine when our game 
	 * is running or not
	 */
	private static boolean running;

	public static void main(String[] args) {
	
		manager.init();

		running = true;

		System.out.println("Home Tour Project B \n"
				+ "The player will start in the foyer. \n" 
				+ "from here, you can explore the house with simple\n"
				+ "'move ______' or 'go_____' commands in the console.  \n" 
				+ "for example: 'move north' will move the player north of the starting room.\n"
				+ "Enjoy exploring the different rooms of the house.\n\n");

		player.setCurrentRoom(manager.getStartingRoom());

		while (running) {
			printRoom();
			String[] input = collectInput();
			parse(input);
		}
		
		System.out.println("Thanks for Visiting!");
	}
	
	private static void printRoom() {
		System.out.println(":::: CURRENT ROOM ::::");
		System.out.println(player.getCurrentRoom());
	}
	
	private static String[] collectInput() {
	
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String[] phrase = input.split(" ");
		return phrase;		

	}
	
	private static void parse(String[] input) {
	
		String command = input[0].toLowerCase().intern();
		String direction = "";
		if (input.length > 1) {
			direction = input[1].toLowerCase().intern();
		}
		
		if (command == "go" || command == "move") {
			System.out.println("Moving: " + direction);
			Room move = player.getCurrentRoom().getExitByDirection(direction);
			player.setCurrentRoom(move);
		} else if (command == "quit" || command == "exit") {
			running = false;
		}
	}
}