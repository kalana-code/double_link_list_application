package com.dll;

import java.util.Scanner;

public class Scheduler {

	private static int getPlacesCount(List<String> Events, Scanner userInputStream) {
		int place;
		while (true) {
			System.out.print("Enter the number of places: ");
			place = userInputStream.nextInt();
			if (place >= Events.getLength()) {
				System.out.println("Sorry that input is invalid!\n");
			} else {
				break;
			}
		}
		return place;
	}

	private static void printCurrentSchedule(List<String> Events) {
		if (Events.isEmpty()) {
			System.out.println("You have no upcoming events! \n");
		} else {
			System.out.println("Your Current Schedule:\n");
			System.out.print(Events.printNumberedList());
		}

	}

	private static void RemoveEvent(List<String> Events, Scanner userInputStream) {
		int eventNumber;
		while (true) {
			System.out.print("Enter the number of the event to remove: ");
			eventNumber = userInputStream.nextInt();
			if (eventNumber > Events.getLength() || eventNumber <= 0) {
				System.out.println("Sorry that input is invalid!\n");
			} else {
				break;
			}
		}

		int index = 1;
		Events.placeIterator();
		while (index < eventNumber) {
			try {
				Events.advanceIterator();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			index++;
		}
		System.out.println("Removing: " + Events.getIterator());
		Events.removeIterator();
	}

	private static void arrangeSchedule(List<String> Events, int count) {
		int i = 0;
		Events.placeIterator();
		while (i < count) {
			try {
				Events.advanceIterator();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			i++;
		}
		Events.addIterator(Events.getFirst());
		Events.removeFirst();
	}

	public static void main(String[] args) {
		List<String> Events = new List<String>();

		Scanner userInputStream = new Scanner(System.in);
		System.out.println("Welcome to the Scheduler App!\n");
		printCurrentSchedule(Events);

		boolean exit = false;
		while (!exit) {
			System.out.println("Select from the following options:\n" + "A: Add an event\n" + "R: Remove an event\n"
					+ "X: Exit \n");
			System.out.print("Enter your choice: ");
			String input = userInputStream.next();
			switch (input) {
			case "A":
				System.out.print("Please enter an event: ");
				String Event = userInputStream.next();
				Events.addFirst(Event);
				if (Events.getLength() > 1) {
					System.out.println("You just added the following event to your schedule: " + Event);
				}
				printCurrentSchedule(Events);
				if (Events.getLength() > 1) {
					System.out.print("Would you like to move this event up in your schedule (Y/N): ");
					String Answer = userInputStream.next();
					switch (Answer) {
					case "Y":
						int placeCount = getPlacesCount(Events, userInputStream);
						arrangeSchedule(Events, placeCount);
						printCurrentSchedule(Events);
						break;
					case "N":
						break;
					default:
						break;

					}
				}

				break;
			case "R":
				RemoveEvent(Events, userInputStream);
				printCurrentSchedule(Events);
				break;
			case "X":
				System.out.println("\nGoodbye!");
				exit = true;
				break;
			default:
				break;
			}
		}

	}

}
