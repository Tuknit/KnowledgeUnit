package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private ArrayList<Product> products;
	private ArrayList<User> users;
	private ArrayList<String[][]> stringMatrixes;
	

	public Controller() {

		this.products = new ArrayList<Product>();
		this.users = new ArrayList<User>();
		stringMatrixes = new ArrayList<String[][]>();
		testCases();

	}

	public void testCases() {

		products.add(new Book("A1F", "A Game of Thrones", 12, new GregorianCalendar(2023, Calendar.OCTOBER, 18), "This is a review", GenreType.FANTASY, 295));
		products.add(new Book("A1A", "Dune", 10, new GregorianCalendar(1989, Calendar.FEBRUARY, 25), "This is a review", GenreType.SCIENCE_FICTION, 158));
		products.add(new Magazine("Z1T", "Vogue", 40, new GregorianCalendar(2021, Calendar.JUNE, 01), CategoryType.VARIETY, 4.99, PeriodicityOfEmision.MENSUAL));
		users.add(new Regular("Juan Camilo", "30777189234"));
		users.add(new Premium("Laurence Daniel", "310924578"));
		users.add(new Premium("Jhon Esteban", "3174702309"));
		users.get(0).addProduct(products.get(0));
		((Book)(products).get(0)).setUnitsSold(1);
		users.get(0).addProduct(products.get(1));
		((Book)(products).get(1)).setUnitsSold(1);
		users.get(0).addProduct(products.get(2));
		((Magazine)(products).get(2)).setActiveSubscriptions(1);;

	}

	public boolean registerProduct(int election, String id, String name, int numberOfPages, int dayOfPublication, int monthOfPublication, int yearOfPublication, int categorization, double value, String specialValue) {

		Calendar publicationDate = new GregorianCalendar(yearOfPublication, monthOfPublication-1, dayOfPublication);

		if (election == 1){

			GenreType assignType = null;

			if (categorization == 1){
				assignType = GenreType.SCIENCE_FICTION;
			} else if (categorization == 2){
				assignType = GenreType.FANTASY;
			} else {
				assignType = GenreType.HISTORIC_NOVELS;
			}

			products.add(new Book(id, name, numberOfPages, publicationDate, specialValue, assignType, value));
			return true;

		} if (election == 2){

			CategoryType assignCategory = null;

			if (categorization == 1){
				assignCategory = CategoryType.DESIGN;
			} else if (categorization == 2){
				assignCategory = CategoryType.VARIETY;
			} else {
				assignCategory = CategoryType.SCIENTIFIC;
			}

			PeriodicityOfEmision assignPeriodicity = null;

			switch(specialValue){
				case "W":
					assignPeriodicity = PeriodicityOfEmision.WEEKLY;
					break;
				case "M":
					assignPeriodicity = PeriodicityOfEmision.MENSUAL;
					break;
				case "A":
					assignPeriodicity = PeriodicityOfEmision.ANNUAL;
					break;
			}

			products.add(new Magazine(id, name, numberOfPages, publicationDate, assignCategory, value, assignPeriodicity));
			return true;
		}

		return false;

	}
	
	public String getSimilarId(String id){

		String msg = "";

		for(int i = 0; i < products.size(); i++){
			
			if(products.get(i).getId().equals(id)){
				msg += "\n" +"\nThe product is already registered in the position number " + i + " and its name is: " + (products).get(i).getName();
			}
			
		}

		return msg;

    }

	public String getAllProducts(){

		String msg = "";

		for(int i = 0; i < products.size(); i++){
			
			msg += "\n" +"\nProduct position: " + i + (products).get(i).toString();
			
		}

		return msg;

    }

	
	public String getAllBooks(){

		String msg = "";

		for(int i = 0; i < products.size(); i++){
			if(products.get(i) instanceof Book){
			msg += "\n" +"\nBook position: " + i + ((Book)(products).get(i)).toString();
			}
		}

		return msg;

    }

	public String getAllMagazines(){

		String msg = "";

		for(int i = 0; i < products.size(); i++){
			if(products.get(i) instanceof Magazine){
				msg += "\n" +"\nMagazine position: " + i + ((Magazine)(products).get(i)).toString();
			}
		}

		return msg;

    }

	public boolean modifyProduct(int productPosition, int election, String newId, String newName, int newNumberOfPages, int dayOfPublication, int monthOfPublication, int yearOfPublication, int newCategorization, double newValue, String newSpecialValue) {
		
		Calendar newPublicationDate = new GregorianCalendar(yearOfPublication, monthOfPublication-1, dayOfPublication);

		if ((election == 1)){

			GenreType newAssignType = null;

			if (newCategorization == 1){
				newAssignType = GenreType.SCIENCE_FICTION;
			} else if (newCategorization == 2){
				newAssignType = GenreType.FANTASY;
			} else {
				newAssignType = GenreType.HISTORIC_NOVELS;
			}

			products.set(productPosition , new Book(newId, newName, newNumberOfPages, newPublicationDate, newSpecialValue, newAssignType, newValue));
			return true;

		} if ((election == 2)){

			CategoryType newAssignCategory = null;

			if (newCategorization == 1){
				newAssignCategory = CategoryType.DESIGN;
			} else if (newCategorization == 2){
				newAssignCategory = CategoryType.VARIETY;
			} else {
				newAssignCategory = CategoryType.SCIENTIFIC;
			}

			PeriodicityOfEmision assignPeriodicity = null;

			switch(newSpecialValue){
				case "W":
					assignPeriodicity = PeriodicityOfEmision.WEEKLY;
					break;
				case "M":
					assignPeriodicity = PeriodicityOfEmision.MENSUAL;
					break;
				case "A":
					assignPeriodicity = PeriodicityOfEmision.ANNUAL;
					break;
			}

			products.set(productPosition , new Magazine(newId, newName, newNumberOfPages, newPublicationDate, newAssignCategory, newValue, assignPeriodicity));
			return true;
		}

        return false;

    }

	public boolean deleteProduct(int productPosition) {

		if(products.get(productPosition) != null){
			products.remove(productPosition);
			return true;
		}
		
		return false;
	}

	public boolean registerUser(String name, String certificate, int importanceOfUser) {

		if (importanceOfUser == 1){

			users.add(new Regular(name, certificate));
			return true;

		} if (importanceOfUser == 2){

			users.add(new Premium(name, certificate));
			return true;

		}	

		return false;

	}


	public String getAllUsers(){

		String msg = "";

		for(int i = 0; i < users.size(); i++){
			
			msg += "\n" +"\nUser position: " + i  + (users.get(i).toString());
			
		}

		return msg;

    }

	public String getAllUsersSuscriptions(int userPosition){

		String msg = "";

		if(users.get(userPosition) instanceof Regular){
			msg += "\n" + showPublicity(userPosition);
		}

		for(int i = 0; i < users.get(userPosition).getProductCollection().size(); i++){
			if(users.get(userPosition).getProductCollection().get(i) instanceof Magazine){
				msg += "\n" +"\nMagazine position: " + i + ((Magazine)users.get(userPosition).getProductCollection().get(i));
			}
		}

		return msg;

    }

	public boolean editUser(int userPosition, String newName) {

		if(users.get(userPosition) != null){
			users.get(userPosition).setName(newName);
			return true;
		}
		
		return false;
	}

	public boolean deleteUser(int userPosition) {

		if(users.get(userPosition) != null){
			users.remove(userPosition);
			return true;
		}
		

		return false;
	}

	public boolean sellProduct(int userPosition, int election, int productPosition) {

		if(election == 1){
	
			if (users.get(userPosition) instanceof Regular){
				if (users.get(userPosition).getProductCollection().size() <= 5){
					users.get(userPosition).addProduct(products.get(productPosition));
				} else {
					return false;
				}
			} else if (users.get(userPosition) instanceof Premium){
				users.get(userPosition).addProduct(products.get(productPosition));
			}

			((Book)(products).get(productPosition)).setUnitsSold(((Book)((products).get(productPosition))).getUnitsSold()+1);

			return true;

		} else if (election == 2){
	
			if (users.get(userPosition) instanceof Regular){
				if (users.get(userPosition).getProductCollection().size() <= 2){
					users.get(userPosition).addProduct(products.get(productPosition));
				} else {
					return false;
				}
			} else if (users.get(userPosition) instanceof Premium){
				users.get(userPosition).addProduct(products.get(productPosition));
			}

			((Magazine)(products).get(productPosition)).setActiveSubscriptions(((Magazine)((products).get(productPosition))).getActiveSubscriptions()+1);

			return true;

		}

		return false;
		
	}

	public boolean deleteSuscription(int userPosition, int productPosition) {

		for (int i = 0; i < products.size(); i++){

			if( (products.get(i)) instanceof Magazine && (users.get(userPosition).getProductCollection().get(productPosition) == products.get(i)) ){
				users.get(userPosition).getProductCollection().remove(userPosition);
				((Magazine)(products).get(i)).setActiveSubscriptions(((Magazine)((products).get(i))).getActiveSubscriptions()-1);
				return true;
			}
	
		}

		return false;
	}

	public String readingSimulation(String simulationOption, int pagesReaded, String simulationAction, int userPosition){

		String msg = "";

		for (int i = 0; i < products.size(); i++){
			if(products.get(i).getId().equals(simulationOption)){
				if (pagesReaded <= products.get(i).getNumberOfPages()){
					if(users.get(userPosition) instanceof Regular){
						msg += "\n" + showPublicity(userPosition);
					}
					msg += "\nReading session in progress";
					msg += "\nYou are reading: " + products.get(i).getName();
					msg += "\n" + "reading the page " + pagesReaded + " of " + products.get(i).getNumberOfPages();
					if (simulationAction != null && simulationAction.equals("S")){
						products.get(i).setNumberOfPagesRead(products.get(i).getNumberOfPagesRead()+1);
					}
				}
			} 
		}

		return msg;

    }

	public void sortListDescending() {

		for (int i = 0; i < products.size(); i++){

			for (int j = 0; j < products.size(); j++){

				int value = products.get(i).compareTo(products.get(j));
				if (value == -1){
					Product temp1 = products.get(j);
					Product temp2 = products.get(i);
					products.set(i, temp1);
					products.set(j, temp2);
				}
				if (value == 1){
					Product temp1 = products.get(j);
					Product temp2 = products.get(i);
					products.set(i, temp2);
					products.set(j, temp1);
				}
				
			}
		}

	}

	public String[] libraryOfUser(int userPosition){

		sortListDescending();

		String[] productsOfUser = new String[10000];

		int j = 0;

		for (int k = 0; k < products.size(); k++){
			for (int g = 0; g < users.get(userPosition).getProductCollection().size(); g++){
				if (users.get(userPosition).getProductCollection().get(g) == products.get(k)){
					productsOfUser[j] = products.get(k).getId();
					j++;
				}
			}
		}
	
		return productsOfUser;

    }

	public String[][] userScreen(String[] productsOfUser, int ubication){

		String[][] library = new String[5][5];

		int j = 0;

		int max = ubication * 25;
		int min =  max - 25;

		if (min < productsOfUser.length){
			for (int k = min; k < productsOfUser.length; k++){
				if (j < 25){
					addProductToMatrixOfUser(productsOfUser[k], library);
					j++;
				} else {
					return library;
				}
			}
	
		} else {
			return library;
		}

		return library;
	}

	public boolean addProductToMatrixOfUser(String p, String[][] library){

		for (int i = 0; i < library.length; i++) {
			for (int j = 0; j < library[0].length; j++) {

				if (library[i][j] == null){
					library[i][j] = p;
					return true;
				}

			}
		}

		return false;
	}

	public String showMatrixOfUser(String[][] library) {

		String print = "";
		for (int i = 0; i < library.length; i++) {
			for (int j = 0; j < library[0].length; j++) {

				if (library[i][j] == null) {

					print += " | " + "___";

				} else {

					print += " | " + library[i][j];

				}

			}
			print += "\n";
		}

		addNullToMatrix(library);

		return print;
	}



	public boolean addNullToMatrix(String[][] library){

		for (int i = 0; i < library.length; i++) {
			for (int j = 0; j < library[0].length; j++) {

				if (library[i][j] != null){
					library[i][j] = null;
					return true;
				}

			}
		}

		return false;
	}



    public String showPublicity(int election){
    
        return  (((Regular)((users).get(election))).getShowPublicity());
        
    }


	public String getRelevantSystemInformation(){

		String msg = "";

		int pagesReadOfBooks = 0;
		int pagesReadOfMagazines = 0;

		int pagesReadOfDesignCategory = 0;
		int pagesReadOfVarietyCategory = 0;
		int pagesReadOfScientificCategory = 0;

		int pagesReadOfHistoricNovelsGenre = 0;
		int pagesReadOfFantasyGenre = 0;
		int pagesReadOfScienceFictionGenre = 0;

		int copiesSoldOfDesignCategory = 0;
		double valueOfSoldsOfDesignCategory = 0;

		int copiesSoldOfVarietyCategory = 0;
		double valueOfSoldsOfVarietyCategory = 0;

		int copiesSoldOfScientificCategory = 0;
		double valueOfSoldsOfScientificCategory = 0;

		int copiesSoldOfHistoricNovelsGenre = 0;
		double valueOfSoldsOfHistoricNovelsGenre = 0;

		int copiesSoldOfFantasyGenre = 0;
		double valueOfSoldsOfFantasyGenre = 0;

		int copiesSoldOfScienceFictionGenre = 0;
		double valueOfSoldsOfScienceFictionGenre = 0;


		for(int i = 0; i < products.size(); i++){
			if(products.get(i) instanceof Book){

				pagesReadOfBooks += products.get(i).getNumberOfPagesRead();

				if (((Book)(products).get(i)).getGenre() == GenreType.HISTORIC_NOVELS){

					pagesReadOfHistoricNovelsGenre = products.get(i).getNumberOfPagesRead();
					copiesSoldOfHistoricNovelsGenre = ((Book)(products).get(i)).getUnitsSold();
					valueOfSoldsOfHistoricNovelsGenre = ((Book)(products).get(i)).getUnitsSold() * ((Book)(products).get(i)).getPrice();

				} else if (((Book)(products).get(i)).getGenre() == GenreType.FANTASY){

					pagesReadOfFantasyGenre = products.get(i).getNumberOfPagesRead();
					copiesSoldOfFantasyGenre = ((Book)(products).get(i)).getUnitsSold();
					valueOfSoldsOfFantasyGenre = ((Book)(products).get(i)).getUnitsSold() * ((Book)(products).get(i)).getPrice();

				} else if (((Book)(products).get(i)).getGenre() == GenreType.SCIENCE_FICTION){

					pagesReadOfScienceFictionGenre = products.get(i).getNumberOfPagesRead();
					copiesSoldOfScienceFictionGenre = ((Book)(products).get(i)).getUnitsSold();
					valueOfSoldsOfScienceFictionGenre = ((Book)(products).get(i)).getUnitsSold() * ((Book)(products).get(i)).getPrice();

				}
			} 
			if(products.get(i) instanceof Magazine){

				pagesReadOfMagazines += products.get(i).getNumberOfPagesRead();

				if (((Magazine)(products).get(i)).getCategory() == CategoryType.DESIGN){

					pagesReadOfDesignCategory = products.get(i).getNumberOfPagesRead();
					copiesSoldOfDesignCategory = ((Magazine)(products).get(i)).getActiveSubscriptions();
					valueOfSoldsOfDesignCategory = ((Magazine)(products).get(i)).getActiveSubscriptions() * ((Magazine)(products).get(i)).getSubscriptionValue();

				} else if (((Magazine)(products).get(i)).getCategory() == CategoryType.VARIETY){

					pagesReadOfVarietyCategory = products.get(i).getNumberOfPagesRead();
					copiesSoldOfVarietyCategory = ((Magazine)(products).get(i)).getActiveSubscriptions();
					valueOfSoldsOfVarietyCategory = ((Magazine)(products).get(i)).getActiveSubscriptions() * ((Magazine)(products).get(i)).getSubscriptionValue();

				} else if (((Magazine)(products).get(i)).getCategory() == CategoryType.SCIENTIFIC){

					pagesReadOfScientificCategory = products.get(i).getNumberOfPagesRead();
					copiesSoldOfScientificCategory = ((Magazine)(products).get(i)).getActiveSubscriptions();
					valueOfSoldsOfScientificCategory = ((Magazine)(products).get(i)).getActiveSubscriptions() * ((Magazine)(products).get(i)).getSubscriptionValue();
					
				}
			} 
		}

		if (pagesReadOfDesignCategory < pagesReadOfVarietyCategory && pagesReadOfScientificCategory < pagesReadOfVarietyCategory){
			msg += "\nThe most read category on the platform is the variety category, the total number of pages read is: " + pagesReadOfVarietyCategory;
		} else if (pagesReadOfDesignCategory > pagesReadOfVarietyCategory && pagesReadOfDesignCategory > pagesReadOfScientificCategory){
			msg += "\nThe most read category on the platform is the design category, the total number of pages read is: " + pagesReadOfDesignCategory;
		} else if (pagesReadOfDesignCategory < pagesReadOfScientificCategory && pagesReadOfVarietyCategory < pagesReadOfScientificCategory){
			msg += "\nThe most read category on the platform is the scientific category, the total number of pages read is: " + pagesReadOfScientificCategory;
		} else {
			msg += "\nThere are no records of a category with more readings performed ";
		}

		if (pagesReadOfHistoricNovelsGenre < pagesReadOfFantasyGenre && pagesReadOfScienceFictionGenre < pagesReadOfFantasyGenre){
			msg += "\nThe most read genre on the platform is the fantasy genre, the total number of pages read is:: " + pagesReadOfFantasyGenre;
		} else if (pagesReadOfHistoricNovelsGenre > pagesReadOfFantasyGenre && pagesReadOfHistoricNovelsGenre > pagesReadOfScienceFictionGenre){
			msg += "\nThe most read genre on the platform is the historic novels genre, the total number of pages read is:: " + pagesReadOfHistoricNovelsGenre;
		} else if (pagesReadOfFantasyGenre < pagesReadOfScienceFictionGenre && pagesReadOfHistoricNovelsGenre < pagesReadOfScienceFictionGenre){
			msg += "\nThe most read genre on the platform is the science fiction genre, the total number of pages read is:: " + pagesReadOfScienceFictionGenre;
		} else {
			msg += "\nThere are no records of a genre with more readings performed ";
		}

		msg += "\nThe total number of book pages read is " + pagesReadOfBooks;
		msg += "\nThe total number of magazine pages read is " + pagesReadOfMagazines;

		msg += "\nThe total number of copies sold of historical novels genre is of: " + copiesSoldOfHistoricNovelsGenre + " and the total sales value is of: " + valueOfSoldsOfHistoricNovelsGenre;
		msg += "\nThe total number of copies sold of fantasy genre is of: " + copiesSoldOfFantasyGenre + " and the total sales value is of: " + valueOfSoldsOfFantasyGenre;
		msg += "\nThe total number of copies sold of science fiction genre is of: " + copiesSoldOfScienceFictionGenre + " and the total sales value is of: " + valueOfSoldsOfScienceFictionGenre;

		msg += "\nThe total number of active subscriptions of design category is of: " + copiesSoldOfDesignCategory + " and the total value paid for subscriptions is of: " + valueOfSoldsOfDesignCategory;
		msg += "\nThe total number of active subscriptions of variety category is of: " + copiesSoldOfVarietyCategory + " and the total value paid for subscriptions is of: " + valueOfSoldsOfVarietyCategory;
		msg += "\nThe total number of active subscriptions of scientific category is of: " + copiesSoldOfScientificCategory + " and the total value paid for subscriptions is of: " + valueOfSoldsOfScientificCategory;

		return msg;

    }



}
