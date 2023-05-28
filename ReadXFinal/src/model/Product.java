package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Product implements Comparable<Product> {
 
    private String id;
    private String name;
    private int numberOfPages;
    private Calendar publicationDate;
    private String url;
    private int numberOfPagesRead;

    private DateFormat formatter;

    public Product(String id, String name, int numberOfPages, Calendar publicationDate) {

        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        this.id = id;
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.publicationDate = publicationDate;
        this.url = "trucoteca.com";
        this.numberOfPagesRead = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public String getPublicationDateFormated() {
		return formatter.format(this.publicationDate.getTime());
	}	

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumberOfPagesRead() {
        return numberOfPagesRead;
    }

    public void setNumberOfPagesRead(int numberOfPagesRead) {
        this.numberOfPagesRead = numberOfPagesRead;
    }

    @Override
	public int compareTo(Product o) {
		if (this.getPublicationDate().after(o.getPublicationDate())) {

			return 1;

		} else if (this.getPublicationDate().before(o.getPublicationDate())) {

			return -1;
		}

		return 0;
	}

	public int compareToPages(Product o) {
		if (this.getNumberOfPagesRead() > o.getNumberOfPagesRead()) {

			return 1;

		} else if (this.getNumberOfPagesRead() < o.getNumberOfPagesRead()) {

			return -1;
		}

		return 0;
	}

}


