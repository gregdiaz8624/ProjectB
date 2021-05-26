package app;

import models.Room;

public class RoomManager {
	
	private Room startingRoom;
	
	private Room[] house;
	
	public RoomManager(int houseSize) {
		house = new Room[houseSize];
	}
	
	
	
	public void init() {
		Room foyer = new Room(
				"Foyer",
				"Small Room entrance",
				"A room where upon entry, has closets to hang coats \nand little tables to put your keys down");
		
		this.house[0] = foyer; 
		
		this.startingRoom = foyer;
		
		Room atrium = new Room(
				"Atrium",
				"Open area with a garden area",
				"An open-roofed entrance hall or central court in an ancient Roman house. \n" +
				"In this center room we have access to lounge areas were we can appreicate the fresh air \n"
				+ "and birds who visit the open space and fill the area with songs" );
		
		this.house[1] = atrium;
		
		Room livingroom = new Room(
				"Living Room", 
				"A typical entertaining room",
				"Here we find a huge comfy couch and a massive flatscreen 4K TV. \n"
				+ "between the couch and tv is a beautiful handman redwood coffeetable.");
		this.house[2] = livingroom; 
		
		Room office = new Room(
				"Office",
				"A room where one handles business",
				"Where does one get all this wood to make all the bookcases and furniture in this room, you ask? \n"
				+ "Well, there's no skimping out on the price of excellence. You need the best to be the best. \n"
				+ "Obviously, there are bronze sculptures of bulls and Frederic Remington paintings decorating this room ");
		this.house[3] = office; 
		
		Room guestroom = new Room(
				"Guest Room",
				"A room for when you have a guest over",
				"Here you'll find a bed, closet and end table. Everything for the guest of the hourse to feel comfortable in \n"
				+ "their extended stay at this house.");
		this.house[4] = guestroom;
		
		Room bathroom = new Room(
				"Bathroom",
				"You might need to shower sometime",
				"Welcome to the bathroom, I always wanted a giant tub to take bubble baths, behold this giant tub made of pure marble.\n"
				+ "The mirror spans the whole wall. Perhaps too much mirror.");
		
		this.house[5] = office;
		
		Room masterbedroom = new Room(
				"Master Bedroom ",
				"As the Owner, you need to feel like royalty",
				"Massive kind sized bed and walk in closet, need I say more? This is the bedroom to beat all bedrooms");

		
		this.house[6] = masterbedroom;
		
		Room dinningroom = new Room(
				"Dinning room ",
				"Got to eat sometime",
				"This dinning room is full of luxury, custom solid wood table, Herman Miller chairs, lights to keep the dinner guests \n"
				+ "feeling beautiful and well fed.");
		
		this.house[7] = dinningroom;
		
		Room kitchen = new Room(
				"Kitchen",
				"Behold, you new favorite room",
				"You'll be looking for reasons to host parties given how spec'd out the kitchen appliances are. There are two sinks! \n"
				+ "A fridge to feed a football team. Can we talk about the island ? Just beautiful. Please enjoy the industrial stove, you can \n"
				+ "finally use that wok you never use.");
		
		this.house[8] = kitchen;
		
		//setting up our room exits
		
		Room[] room1Exits = {atrium, office, null, guestroom};
		foyer.setExits(room1Exits);
		
		Room[] room2Exits = {dinningroom, livingroom, foyer, bathroom};
		atrium.setExits(room2Exits);
		
		Room[] room3Exits = {null, null, office, atrium};
		livingroom.setExits(room3Exits);
		
		Room[] room4Exits = {livingroom, null, null, foyer};
		office.setExits(room4Exits);
		
		Room[] room5Exits = {bathroom, foyer, null, null};
		guestroom.setExits(room5Exits);
		
		Room[] room6Exits = {masterbedroom, atrium, guestroom, null};
		bathroom.setExits(room6Exits);
		
		Room[] room7Exits = {null, dinningroom, bathroom, null};
		masterbedroom.setExits(room7Exits);
		
		Room[] room8Exits = {null, kitchen, atrium, masterbedroom};
		dinningroom.setExits(room8Exits);
		
		Room[] room9Exits = {null, null, livingroom, dinningroom};
		kitchen.setExits(room9Exits);
		
		
	}
	
	public Room getRoom(int index) {
		if (index < 0) {
			System.out.println("I did not recognize that");
			return null;
		}
		return house[index];
	}
	
	public Room getRoom(String roomName) {
		int index = -1;
		for (int i = 0; i < house.length; i++) {
			if (roomName.toLowerCase() == house[i].getName().toLowerCase()) {
				index = i;
			}
		}
		
		return getRoom(index);
	}

	public Room getStartingRoom() {
		return startingRoom;
	}

	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}

	public Room[] getHouse() {
		return house;
	}

	public void setHouse(Room[] house) {
		this.house = house;
	}
} 