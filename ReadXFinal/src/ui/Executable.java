package ui;

import java.util.Scanner;

import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller shop;

	public Executable() {

		reader = new Scanner(System.in);
		shop = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	public void menu() {

		System.out.println("Bienvenido a ReaderX!");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMAIN MENU");
			System.out.println("\n1. Register a book or a magazine");
			System.out.println("2. Show all the products");
			System.out.println("3. Modify a book or a magazine");
			System.out.println("4. Delete a product");
			System.out.println("5. Register a premium user or a regular user");
			System.out.println("6. Show all the users ");
			System.out.println("7. Modify the user name");
			System.out.println("8. Delete a user");
			System.out.println("9. Sell product");
			System.out.println("10. Delete a suscription");
			System.out.println("11. Consult a user library");
			System.out.println("12. Consult informs of data");
			System.out.println("0. Exit");
			int option = reader.nextInt();

			switch (option) {

				case 1:
					registerBookOrMagazine();
					break;

				case 2:
					showAllProductsInfo();
					break;

				case 3:
					modifyProduct();
					break;

				case 4:
					deleteProduct();
					break;

				case 5:
					registerRegularOrPremium();
					break;

				case 6:
					showAllUserInfo();
					break;

				case 7:
					modifyUser();
					break;

				case 8:
					deleteUser();
					break;

				case 9:
				 	sellProduct();;
					break;

				case 10:
					deleteSuscription();
					break;

				case 11:
					userLibrary();
					break;

				case 12:
					showAllRelevantInfo();
					break;

				case 0:
					flag = true;
					break;

			}

		}

	}

	public void registerBookOrMagazine() {

		System.out.println("Please, choose the product that you want register \n1. Book \n2. Magazine");
		int election = reader.nextInt();

		if (election == 1) {

			reader.nextLine();

			System.out.println("Type the hexadecimal identificator. Ex.: A1F");
			String id = reader.nextLine();

			String comprobation = shop.getSimilarId(id);

			if(comprobation.equals("")){

				System.out.println("Type the name of the book");
				String name = reader.nextLine();
	
				System.out.println("Type the number of pages");
				int numberOfPages = reader.nextInt();
	
				System.out.println("Type the day of the publication of the book");
				int dayOfPublication = reader.nextInt();
	
				System.out.println("Type the month of the publication of the book");
				int monthOfPublication = reader.nextInt();
	
				System.out.println("Type the year of the publication of the book");
				int yearOfPublication = reader.nextInt();
	
				System.out.println("Type the genre of the book \n1. Science fiction \n2. Fantasy \n3. Historic Novels ");
				int categorization = reader.nextInt();
	
				System.out.println("Write the value for sale ");
				double value = reader.nextDouble();
	
				reader.nextLine();
	
				System.out.println("Type the review of the book");
				String specialValue = reader.nextLine();
	
				if (shop.registerProduct(election, id, name, numberOfPages, dayOfPublication, monthOfPublication,
						yearOfPublication, categorization, value, specialValue)) {
	
					System.out.println("Book registred with success");
	
				} else {
	
					System.out.println("Memory full, the book has not been registered");
				}

			} else {

				boolean differentId = false;

				while(!differentId){

					System.out.println(comprobation);

					System.out.println("Type the hexadecimal identificator. Ex.: A1F");
					String idCorrection = reader.nextLine();

					comprobation = shop.getSimilarId(idCorrection);

					if(comprobation.equals("")){

						System.out.println("Type the name of the book");
						String name = reader.nextLine();
			
						System.out.println("Type the number of pages");
						int numberOfPages = reader.nextInt();
			
						System.out.println("Type the day of the publication of the book");
						int dayOfPublication = reader.nextInt();
			
						System.out.println("Type the month of the publication of the book");
						int monthOfPublication = reader.nextInt();
			
						System.out.println("Type the year of the publication of the book");
						int yearOfPublication = reader.nextInt();
			
						System.out.println("Type the genre of the book \n1. Science fiction \n2. Fantasy \n3. Historic Novels ");
						int categorization = reader.nextInt();
			
						System.out.println("Write the value for sale ");
						double value = reader.nextDouble();
			
						reader.nextLine();
			
						System.out.println("Type the review of the book");
						String specialValue = reader.nextLine();
			
						if (shop.registerProduct(election, idCorrection, name, numberOfPages, dayOfPublication, monthOfPublication,
								yearOfPublication, categorization, value, specialValue)) {
			
							System.out.println("Book registred with success");
			
						} else {
			
							System.out.println("Memory full, the book has not been registered");
						}

						differentId = true;

					} 

				}
			}

		} else if (election == 2) {

			reader.nextLine();

			System.out.println("Type the alphanumeric identification. Ej.: Z1T");
			String id = reader.nextLine();

			String comprobation = shop.getSimilarId(id);

			if(comprobation.equals("")){

				System.out.println("Type the name of the magazine");
				String name = reader.nextLine();
	
				System.out.println("Type the number of pages");
				int numberOfPages = reader.nextInt();
	
				System.out.println("Type the day of the publication of the magazine");
				int dayOfPublication = reader.nextInt();
	
				System.out.println("Type the month of the publication of the magazine");
				int monthOfPublication = reader.nextInt();
	
				System.out.println("Type the year of the publication of the magazine");
				int yearOfPublication = reader.nextInt();
	
				System.out.println("Type the category of the magazine \n1. Design \n2. Variety \n3. Scientific ");
				int categorization = reader.nextInt();
	
				System.out.println("Type the value of the suscription");
				double value = reader.nextDouble();
	
				reader.nextLine();
	
				System.out.println("Type the periodicty of emision (W = Weekly, M = Mensual, A = Annual))");
				String specialValue = reader.nextLine();
	
				if (shop.registerProduct(election, id, name, numberOfPages, dayOfPublication, monthOfPublication,
						yearOfPublication, categorization, value, specialValue)) {
	
					System.out.println("Magazine registred with success");
	
				} else {
	
					System.out.println("Memory full, the magazine has not been registered");
				}

			} else {

				boolean differentId = false;

				while(!differentId){

					System.out.println(comprobation);

					System.out.println("Type the alphanumeric identification. Ej.: Z1T");
					String idCorrection = reader.nextLine();

					comprobation = shop.getSimilarId(idCorrection);

					if(comprobation.equals("")){

					System.out.println("Type the name of the magazine");
					String name = reader.nextLine();
		
					System.out.println("Type the number of pages");
					int numberOfPages = reader.nextInt();
		
					System.out.println("Type the day of the publication of the magazine");
					int dayOfPublication = reader.nextInt();
		
					System.out.println("Type the month of the publication of the magazine");
					int monthOfPublication = reader.nextInt();
		
					System.out.println("Type the year of the publication of the magazine");
					int yearOfPublication = reader.nextInt();
		
					System.out.println("Type the category of the magazine \n1. Design \n2. Variety \n3. Scientific ");
					int categorization = reader.nextInt();
		
					System.out.println("Type the value of the suscription");
					double value = reader.nextDouble();
		
					reader.nextLine();
		
					System.out.println("Type the periodicty of emision (W = Weekly, M = Mensual, A = Annual))");
					String specialValue = reader.nextLine();
		
					if (shop.registerProduct(election, idCorrection, name, numberOfPages, dayOfPublication, monthOfPublication,
							yearOfPublication, categorization, value, specialValue)) {
		
						System.out.println("Magazine registred with success");
		
					} else {
		
						System.out.println("Memory full, the magazine has not been registered");
					}

						differentId = true;

					} 

				}
			}

		} else {

			System.out.println("You have chosen an invalid option ");

		}

	}

	public void showAllProductsInfo() {

		System.out.println("This is the information registered in the system");

		String query = shop.getAllProducts();

		if (query.equals("")) {

			System.out.println("There are no bibliographic products registered");
		} else {
			System.out.println(query);
		}

	}

	

	public void modifyProduct(){

		System.out.println("Please, choose the product that you want register \n1. Book \n2. Magazine");
		int election = reader.nextInt();

		if (election == 1) {

			String books = shop.getAllBooks();

			if (books.equals("")) {

				System.out.println("No books registered");

			} else {

				System.out.println(books);

				System.out.println("Write the position of the book to be able to modify it");
				int bookPosition = reader.nextInt();

				reader.nextLine();

				System.out.println("Type the hexadecimal identificator. Ex.: A1F");
				String newId = reader.nextLine();

				String comprobation = shop.getSimilarId(newId);

				if(comprobation.equals("")){
	
					System.out.println("Type the name of the book");
					String newName = reader.nextLine();
		
					System.out.println("Type the number of pages");
					int newNumberOfPages = reader.nextInt();
		
					System.out.println("Type the day of the publication of the book");
					int dayOfPublication = reader.nextInt();
		
					System.out.println("Type the month of the publication of the book");
					int monthOfPublication = reader.nextInt();
		
					System.out.println("Type the year of the publication of the book");
					int yearOfPublication = reader.nextInt();
		
					System.out.println("Type the genre of the book \n1. Science fiction \n2. Fantasy \n3. Historic Novels ");
					int newCategorization = reader.nextInt();
		
					System.out.println("Write the value for sale ");
					double newValue = reader.nextDouble();
		
					reader.nextLine();
		
					System.out.println("Type the review of the book");
					String newSpecialValue = reader.nextLine();
		
					if (shop.modifyProduct(bookPosition, election, newId, newName, newNumberOfPages, dayOfPublication, monthOfPublication, yearOfPublication, newCategorization, newValue, newSpecialValue)) {
		
						System.out.println("Book registred with success");
		
					} else {
		
						System.out.println("Memory full, the book has not been registered");
					}
	
				} else {
	
					boolean differentId = false;
	
					while(!differentId){
	
						System.out.println(comprobation);
	
						System.out.println("Type the hexadecimal identificator. Ex.: A1F");
						String idCorrection = reader.nextLine();
	
						comprobation = shop.getSimilarId(idCorrection);
	
						if(comprobation.equals("")){
	
							System.out.println("Type the name of the book");
							String newName = reader.nextLine();
				
							System.out.println("Type the number of pages");
							int newNumberOfPages = reader.nextInt();
				
							System.out.println("Type the day of the publication of the book");
							int dayOfPublication = reader.nextInt();
				
							System.out.println("Type the month of the publication of the book");
							int monthOfPublication = reader.nextInt();
				
							System.out.println("Type the year of the publication of the book");
							int yearOfPublication = reader.nextInt();
				
							System.out.println("Type the genre of the book \n1. Science fiction \n2. Fantasy \n3. Historic Novels ");
							int newCategorization = reader.nextInt();
				
							System.out.println("Write the value for sale ");
							double newValue = reader.nextDouble();
				
							reader.nextLine();
				
							System.out.println("Type the review of the book");
							String newSpecialValue = reader.nextLine();
				
							if (shop.modifyProduct(bookPosition, election, idCorrection , newName, newNumberOfPages, dayOfPublication, monthOfPublication, yearOfPublication, newCategorization, newValue, newSpecialValue)) {
				
								System.out.println("Book registred with success");
				
							} else {
				
								System.out.println("Memory full, the book has not been registered");
							}
	
							differentId = true;
	
						} 
	
					}
				}

			}


		} else if (election == 2) {

			String magazines = shop.getAllMagazines();

			
			if (magazines.equals("")) {

				System.out.println("No magazines registered");

			} else {

				System.out.println(magazines);

				System.out.println("Write the position of the magazine to be able to modify it");
				int magazinePosition = reader.nextInt();

				reader.nextLine();

				System.out.println("Type the alphanumeric identification. Ej.: Z1T");
				String newId = reader.nextLine();
	
				String comprobation = shop.getSimilarId(newId);

				if(comprobation.equals("")){
	
					System.out.println("Type the name of the magazine");
					String newName = reader.nextLine();
		
					System.out.println("Type the number of pages");
					int newNumberOfPages = reader.nextInt();
		
					System.out.println("Type the day of the publication of the magazine");
					int dayOfPublication = reader.nextInt();
		
					System.out.println("Type the month of the publication of the magazine");
					int monthOfPublication = reader.nextInt();
		
					System.out.println("Type the year of the publication of the magazine");
					int yearOfPublication = reader.nextInt();
		
					System.out.println("Type the category of the magazine \n1. Design \n2. Variety \n3. Scientific ");
					int newCategorization = reader.nextInt();
		
					System.out.println("Type the value of the suscription");
					double newValue = reader.nextDouble();
		
					reader.nextLine();
		
					System.out.println("Type the periodicty of emision (W = Weekly, M = Mensual, A = Annual))");
					String newSpecialValue = reader.nextLine();
		
					if (shop.modifyProduct(magazinePosition, election, newId, newName, newNumberOfPages, dayOfPublication, monthOfPublication, yearOfPublication, newCategorization, newValue, newSpecialValue)) {
		
						System.out.println("Magazine registred with success");
		
					} else {
		
						System.out.println("Memory full, the magazine has not been registered");
					}
	
				} else {
	
					boolean differentId = false;
	
					while(!differentId){

						System.out.println(comprobation);
	
						System.out.println("Type the alphanumeric identification. Ej.: Z1T");
						String idCorrection = reader.nextLine();
	
						comprobation = shop.getSimilarId(idCorrection);
	
						if(comprobation.equals("")){
	
							System.out.println("Type the name of the magazine");
							String newName = reader.nextLine();
				
							System.out.println("Type the number of pages");
							int newNumberOfPages = reader.nextInt();
				
							System.out.println("Type the day of the publication of the magazine");
							int dayOfPublication = reader.nextInt();
				
							System.out.println("Type the month of the publication of the magazine");
							int monthOfPublication = reader.nextInt();
				
							System.out.println("Type the year of the publication of the magazine");
							int yearOfPublication = reader.nextInt();
				
							System.out.println("Type the category of the magazine \n1. Design \n2. Variety \n3. Scientific ");
							int newCategorization = reader.nextInt();
				
							System.out.println("Type the value of the suscription");
							double newValue = reader.nextDouble();
				
							reader.nextLine();
				
							System.out.println("Type the periodicty of emision (W = Weekly, M = Mensual, A = Annual))");
							String newSpecialValue = reader.nextLine();
				
							if (shop.modifyProduct(magazinePosition, election, idCorrection, newName, newNumberOfPages, dayOfPublication, monthOfPublication, yearOfPublication, newCategorization, newValue, newSpecialValue)) {
				
								System.out.println("Magazine registred with success");
				
							} else {
				
								System.out.println("Memory full, the magazine has not been registered");
							}
								differentId = true;
	
						} 
	
					}
				}
			}

		} else {

			System.out.println("You have chosen an invalid option ");

		}



	}

	private void deleteProduct() {

		String query = shop.getAllProducts();

		if (query.equals("")) {

			System.out.println("No bibliographic products registered in the system");
		} else {

			System.out.println("\nThis is the list of bibliographic products registered in the system");

			System.out.println(query);

			System.out.println("\nSelect the bibliographic product to delete");

			int productPosition = reader.nextInt();

			if (shop.deleteProduct(productPosition)) {

				System.out.println("\nBibliographic product successfully deleted");

			} else {

				System.out.println("\nError, bibliographic product could not be deleted");
			}

		}

	}

	

	public void registerRegularOrPremium() {

		reader.nextLine();

		System.out.println("Please, choose the type of user that you want register \n1. Regular \n2. Premium");
		int importanceOfUser = reader.nextInt();

		if (importanceOfUser == 1) {

			reader.nextLine();

			System.out.println("Type your name");
			String name = reader.nextLine();

			System.out.println("Type your certificate");
			String certificate = reader.nextLine();

			if (shop.registerUser(name, certificate, importanceOfUser)) {

				System.out.println("Regular user registred with success");

			} else {

				System.out.println("Memory full, the user has not been registered");
			}

		} else if (importanceOfUser == 2) {

			reader.nextLine();

			System.out.println("Type your name");
			String name = reader.nextLine();

			System.out.println("Type your certificate");
			String certificate = reader.nextLine();

			if (shop.registerUser(name, certificate, importanceOfUser)) {

				System.out.println("Premium user registred with success");

			} else {

				System.out.println("Memory full, the user has not been registered");
			}

		} else {

			System.out.println("You have chosen an invalid option ");

		}

	}

	private void showAllUserInfo() {

		System.out.println("This is the information registered in the system");

		String query = shop.getAllUsers();

		if (query.equals("")) {

			System.out.println("There are no registered users");
		} else {
			System.out.println(query);
		}

	}

	private void modifyUser() {

		String query = shop.getAllUsers();

		if (query.equals("")) {

			System.out.println("There are no registered users");
			
		} else {

			System.out.println("\nThis is the list of registered users in the system");

			System.out.println(query);

			System.out.println("\nSelect the user to edit");

			int option = reader.nextInt();

			reader.nextLine();

			System.out.println("\nType the new name: ");

			String newName = reader.nextLine();

			if (shop.editUser(option, newName)) {

				System.out.println("\nUser successfully edited");

			} else {

				System.out.println("\nError, user could not be edited");
			}

		}

	}

	private void deleteUser() {

		String query = shop.getAllUsers();

		if (query.equals("")) {

			System.out.println("There are no registered users");
		} else {

			System.out.println("\nThis is the list of registered users in the system");

			System.out.println(query);

			System.out.println("\nSelect the user to delete");

			int option = reader.nextInt();

			if (shop.deleteUser(option)) {

				System.out.println("\nUser successfully deleted");

			} else {

				System.out.println("\nError, user could not be deleted");
			}

		}

	}

	public void sellProduct(){

		String users = shop.getAllUsers();

		if (users.equals("")){

			System.out.println("No users registered");

		} else {

			System.out.println(users);

			System.out.println("Please type the user position ");
			int userPosition = reader.nextInt();

			System.out.println("Please, choose the product that you want sell \n1. Book \n2. Magazine");
			int election = reader.nextInt();

			if (election == 1) {

				String books = shop.getAllBooks();

				if (books.equals("")) {

					System.out.println("No books registered");

				} else {

					System.out.println(books);

					System.out.println("Write the position of the book to be able to sell it");
					int bookPosition = reader.nextInt();

					if (shop.sellProduct(userPosition, election, bookPosition)) {

						System.out.println("Book sell with success");

					} else {

						System.out.println("Error, the book has not been sell");
					}

				}


			} else if (election == 2) {

				String magazines = shop.getAllMagazines();

				
				if (magazines.equals("")) {

					System.out.println("No magazines registered");

				} else {

					System.out.println(magazines);

					System.out.println("Write the position of the magazine to be able to sell it");
					int magazinePosition = reader.nextInt();
		
					if (shop.sellProduct(userPosition, election, magazinePosition)) {
		
						System.out.println("Magazine sell with success");
		
					} else {
		
						System.out.println("Error, the magazine has not been sell");
					}
				}

			} else {

				System.out.println("You have chosen an invalid option ");

			}
	    }


	}

	private void deleteSuscription() {

		String query = shop.getAllUsers();

		if (query.equals("")) {

			System.out.println("There are no registered users");
		} else {

			System.out.println("\nThis is the list of registered users in the system");

			System.out.println(query);

			System.out.println("\nSelect the user ");

			int option = reader.nextInt();

			String suscriptions = shop.getAllUsersSuscriptions(option);

			if (suscriptions.equals("")){

				System.out.println("There are no active subscriptions");
				
			} else {

				System.out.println("\nThis is the list of active subscriptions in the system");

				System.out.println(suscriptions);

				System.out.println("\nSelect the subscription ");

				int suscriptionPosition = reader.nextInt();

				if (shop.deleteSuscription(option, suscriptionPosition)) {

					System.out.println("\nSubscription successfully deleted ");
	
				} else {
	
					System.out.println("\nError, the subscription could not be deleted");
				}

			}

		}

	}

	private void userLibrary() {

		String query = shop.getAllUsers();

		if (query.equals("")) {

			System.out.println("There are no registered users");
		} else {

			System.out.println("\nThis is the list of registered users in the system");

			System.out.println(query);

			System.out.println("\nSelect the user ");

			int option = reader.nextInt();
			
			boolean list = false;

			int ubication = 1;

			String action = null;

			String simulationAction = null;

			while(!list){

				int pagesReaded = 1;

				String libraryOfUser[] = shop.libraryOfUser(option);

				String[][] userScreen = shop.userScreen(libraryOfUser, ubication);

				String suscriptions = shop.showMatrixOfUser(userScreen);

				if (suscriptions.equals("")){

					System.out.println("No bibliographic products in the user library");
					list = true;

				} else {

					System.out.println(suscriptions);

					System.out.print("\nType the corresponding code of the bibliographic product to start a reading simulation");
					System.out.println("\nType A to go to previous page");
					System.out.println("\nType S to go to next page");
					System.out.println("\nType E to exit");

					if (action == null){
						reader.nextLine();
					}

					action = reader.nextLine();

					if (action.equals("A")){
						if (ubication > 1){
							ubication -= 1;
						} else {
							System.out.println("\nIt is not possible to go back to a previous page than the first page");
						}
					} else if (action.equals("S")){
						ubication += 1;
					} else if (action.equals("E")){
						list = true;
					} else {
						boolean simulationFlag = false;
						while(!simulationFlag){

							String simulation = shop.readingSimulation(action, pagesReaded, simulationAction, option);

							if (simulation.equals("")){
	
								if(simulationAction != null && simulationAction.equals("S")){
									System.out.println("\nThe pages of the book are finished, you have finished reading");
								} else {
									System.out.println("\nThe code entered does not correspond to any book in the system");
								} 
								simulationFlag = true;

							} else {
								System.out.println(simulation);
	
								System.out.println("\nType A to go to previous page");
								System.out.println("\nType S to go to next page");
								System.out.println("\nType E to exit");
			
								simulationAction = reader.nextLine();

								if (simulationAction.equals("A")){
									if (pagesReaded > 1){
										pagesReaded -= 1;
									} else {
										System.out.println("\nIt is not possible to go back to a previous page than the first page");
									}
								} else if (simulationAction.equals("S")){
									pagesReaded += 1;
								} else if (simulationAction.equals("E")){
									pagesReaded = 1;
									simulationFlag = true;
								}

							}
						}
					}

				}

			}

		}

	}

	private void showAllRelevantInfo() {

		System.out.println("This is the information registered in the system");

		String query = shop.getRelevantSystemInformation();

		if (query.equals("")) {

			System.out.println("There are no relevant information");

		} else {

			System.out.println(query);
		}

	}
	
}