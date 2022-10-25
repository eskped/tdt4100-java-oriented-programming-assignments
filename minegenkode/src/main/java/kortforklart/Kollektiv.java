package kortforklart;

import java.util.ArrayList;
import java.util.List;

//Hvordan arrays fungerer
//Hvoirdan lister fungerer
public class Kollektiv {
	
	private String[] rooms;
	private String name;
	
	private List<String> guests = new ArrayList<>();
	
	public Kollektiv(String name, int numberOfRooms) {
		this.name = name;
		this.rooms = new String[numberOfRooms];
	}
	
	public void setPersonAtRoomNumber(String person, int roomNumber ) {
		this.rooms[roomNumber] = person;
	}
	
	public String getPersonAtRoomNumber(int roomNumber) {
		return this.rooms[roomNumber];
	}
	
	public void addGuest(String name) {
		//Sjekke at gjesten allerede ikke er der
		if(!this.hasGuest(name)) {
			this.guests.add(name);
		}
	}
	
	public boolean hasGuest(String name) {
		return this.guests.contains(name);
	}
	
	public void removeGuest(String name) {
		this.guests.remove(name);
	}
	
	public static void main(String[] args) {
		Kollektiv javaKollektivet = new Kollektiv("Javakollektivet", 4);
		javaKollektivet.setPersonAtRoomNumber("Vegard", 0);
		javaKollektivet.setPersonAtRoomNumber("Magnus", 1);
		System.out.println(javaKollektivet.getPersonAtRoomNumber(1));
		javaKollektivet.addGuest("Stein");
		System.out.println(javaKollektivet.hasGuest("Stein"));
		System.out.println(javaKollektivet.hasGuest("Vilde"));
		
	}
}
