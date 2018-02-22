package view;

import java.util.List;
import java.util.Scanner;
import controller.ArtGalleryItemHelper;
import model.ArtGalleryItem;

public class ArtGalleryStartProgram {

		static Scanner in = new Scanner(System.in);
		static ArtGalleryItemHelper agh = new ArtGalleryItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Please enter in a title: ");
			String title = in.nextLine();
			System.out.print("Please enter in an artist last name: ");
			String artist = in.nextLine();
			System.out.print("Please enter in media: ");
			String media = in.nextLine();
			System.out.println("Please enter in the year: ");
			String year = in.nextLine();
			System.out.println("Please enter in the value: ");
			double value = in.nextDouble();
			
			ArtGalleryItem toAdd = new ArtGalleryItem(title, artist, media, year, value);
			agh.insertItem(toAdd);
			
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Please enter the title to delete: ");
			String title = in.nextLine();
			System.out.print("Please enter the artist last name to delete: ");
			String artist = in.nextLine();
			System.out.print("Please enter the year to delete: ");
			String year = in.nextLine();
			
			ArtGalleryItem toDelete = new ArtGalleryItem(title, artist, year);
			agh.deleteItem(toDelete);

		}
		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to look up a piece of art? ");
			System.out.println("1 : Search by Title");
			System.out.println("2 : Search by Artist");
			
			int searchBy = in.nextInt();
			in.nextLine();
			List<ArtGalleryItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the title: ");
				String titleName = in.nextLine();
				foundItems = agh.searchForTitleName(titleName);
				
			} else {
				System.out.print("Enter the artist: ");
				String artistName = in.nextLine();
				foundItems = agh.searchForItemsByArtist(artistName);
			
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ArtGalleryItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ArtGalleryItem toEdit = agh.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getTitle() + " from " + toEdit.getTitle());
				System.out.println("1 : Update Title");
				System.out.println("2 : Update Artist");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Title: ");
					String newTitle = in.nextLine();
					toEdit.setTitle(newTitle);
				} else if (update == 2) {
					System.out.print("New Artist: ");
					String newArtist = in.nextLine();
					toEdit.setArtist(newArtist);
				}

				agh.updateTitle(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to this pricey art gallery! ---");
			while (goAgain) {
				System.out.println("*  Select a work of art:");
				System.out.println("*  1 -- Add a piece of art");
				System.out.println("*  2 -- Edit a piece of art");
				System.out.println("*  3 -- Delete a piece of art");
				System.out.println("*  4 -- View a piece of art");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ArtGalleryItem> allItems = agh.showAllItems();
			for (ArtGalleryItem li: allItems) {
				System.out.println(li);
			}
			

		}

	}