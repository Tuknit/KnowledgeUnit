package model;

import java.util.Calendar;

public class Magazine extends Product {

    private CategoryType category;
    private double subscriptionValue; 
    private PeriodicityOfEmision periodicity;
    private int activeSubscriptions;

    public Magazine(String id, String name, int numberOfPages, Calendar publicationDate, CategoryType category, double subscriptionValue, PeriodicityOfEmision periodicity){
        super(id, name, numberOfPages, publicationDate);
        this.category = category;
        this.subscriptionValue = subscriptionValue;
        this.periodicity = periodicity;
        this.activeSubscriptions = 0;

    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public double getSubscriptionValue() {
        return subscriptionValue;
    }

    public void setSubscriptionValue(double subscriptionValue) {
        this.subscriptionValue = subscriptionValue;
    }

    public PeriodicityOfEmision getPeriodicity() {
        return periodicity; 
    }

    public void setPeriodicity(PeriodicityOfEmision periodicity) {
        this.periodicity = periodicity;
    }

    public int getActiveSubscriptions() {
        return activeSubscriptions;
    }

    public void setActiveSubscriptions(int activeSubscriptions) {
        this.activeSubscriptions = activeSubscriptions;
    }

    @Override
	public String toString() {
		return  "\n" + "\nMagazine id: " + this.getId() + "\nMagazine name: " + this.getName() + "\nNumber of pages: " + this.getNumberOfPages() +  "\nPublication date: " + this.getPublicationDateFormated() +  "\nURL: " + this.getUrl() +  "\nNumber of pages read: " + this.getNumberOfPagesRead() + "\nPeriodicity of emision: " + periodicity + "\nCategory: " + category + "\nSubscription value: " + subscriptionValue + "\nActive subscriptions: " + activeSubscriptions;
	}

    

    


    
}
