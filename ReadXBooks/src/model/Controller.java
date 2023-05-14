package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private ArrayList<Product> products;
	private ArrayList<User> users;
	private ArrayList<Transaction> transactions;
	

	public Controller() {

		this.products = new ArrayList<Product>();
		this.users = new ArrayList<User>();
		this.transactions = new ArrayList<Transaction>();
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
		users.get(0).addProduct(products.get(1));
		users.get(0).addProduct(products.get(2));


		
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

	public boolean sellBook(int userPosition, int election, int productPosition) {

		if(election == 1){

			Calendar soldDate = Calendar.getInstance();
			double purchaseValue = ((Book)(products).get(productPosition)).getPrice();
			String bookName = ((Book)(products).get(productPosition)).getName();
	
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
	
			transactions.add(new Transaction(soldDate, purchaseValue, bookName));

			return true;

		} else if (election == 2){

			Calendar soldDate = Calendar.getInstance();
			double purchaseValue = ((Magazine)(products).get(productPosition)).getSubscriptionValue();
			String bookName = ((Magazine)(products).get(productPosition)).getName();
	
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
	
			transactions.add(new Transaction(soldDate, purchaseValue, bookName));

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

	public String readingSimulation(String simulationOption, int pagesReaded, String simulationAction){

		String msg = "";
		
		for (int i = 0; i < products.size(); i++){
			if(products.get(i).getId().equals(simulationOption)){
				if (pagesReaded <= products.get(i).getNumberOfPages()){
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

	public String library(int ubication, int userPosition){

		String msg = "";

		if(users.get(userPosition) instanceof Regular){
			msg += "\n" + showPublicity(userPosition);
		}
	
		int ubicationMax = (ubication * 15) - 1;

		if (ubicationMax < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 9) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 8) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 7) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 6) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-5)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 4) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 3) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 2) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 1) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax);
		} else if (ubicationMax-1 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 9) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 8) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 7) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 6) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-5)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 4) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 3) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 2) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 1) + "|\t___ " ;
		} else if (ubicationMax-2 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 9) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 8) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 7) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 6) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-5)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 4) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 3) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 2) + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-3 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 9) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 8) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 7) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 6) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-5)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 4) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 3) + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-4 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 9) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 8) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 7) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 6) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-5)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 4) + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-5 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 9) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 8) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 7) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 6) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-5)
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-6 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 9) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 8) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 7) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 6) + "|\t___" 
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-7 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 9) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 8) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 7) + "|\t___" + "|\t___" 
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-8 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 9) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 8) + "|\t___"  + "|\t___" + "|\t___" 
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-9 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax - 9) + "|\t___" + "|\t___"  + "|\t___" + "|\t___" 
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-10 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t" +	users.get(userPosition).getProductsCollectionCode(ubicationMax - 10)
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___"  + "|\t___" + "|\t___" 
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-11 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName()+ "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-11) + "|\t___"
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___"  + "|\t___" + "|\t___" 
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-12 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-12) + "|\t___"  + "|\t___"
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___"  + "|\t___" + "|\t___" 
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-13 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-13) + "|\t___" + "|\t___"  + "|\t___"
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___"  + "|\t___" + "|\t___" 
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else if (ubicationMax-14 < users.get(userPosition).getProductCollection().size()){
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t" + users.get(userPosition).getProductsCollectionCode(ubicationMax-14) + "|\t___" + "|\t___" + "|\t___"  + "|\t___"
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___"  + "|\t___" + "|\t___" 
			 + "\n1  |" + "\t___" + "|\t___" + "|\t___" + "|\t___" + "|\t___ " ;
		} else {
			msg += "\n" + "Library of " + users.get(userPosition).getName() + "\n";
			msg += "\n" + "\t 0 | \t 1 | \t 2 | \t 3 | \t 4 ";
			msg += "\n0  |" + "\t___|\t___|\t___|\t___|\t___ "
			 + "\n1  |" + "\t___|\t___|\t___|\t___|\t___ "
			 + "\n2  |" + "\t___|\t___|\t___|\t___|\t___ ";
		}

		return msg;

    }

		
    public String showPublicity(int election){
    
        return  (((Regular)((users).get(election))).getShowPublicity());
        
    }



}
