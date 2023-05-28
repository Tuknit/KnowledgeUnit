package model;

import java.util.Calendar;

public class Book extends Product {

	private String review;
	private GenreType genre;
	private double price;
	private int unitsSold;

	public Book(String id, String name, int numberOfPages, Calendar publicationDate, String review, GenreType genre, double price){
		super(id, name, numberOfPages, publicationDate);
		this.review = review;
		this.genre = genre;
		this.price = price;
		this.unitsSold = 0;
	}

	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public GenreType getGenre() {
		return genre;
	}

	public void setGenre(GenreType genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

	@Override
	public String toString() {
		return  "\n" + "\nBook id: " + this.getId() + "\nBook name: " + this.getName() + "\nNumber of pages: " + this.getNumberOfPages() +  "\nPublication date: " + this.getPublicationDateFormated() +  "\nURL: " + this.getUrl() +  "\nNumber of pages read: " + this.getNumberOfPagesRead() + "\nReview: " + review + "\nGenre: " + genre + "\nPrice: " + price + "\nUnits sold: " + unitsSold;
	}
	

	

	

}
