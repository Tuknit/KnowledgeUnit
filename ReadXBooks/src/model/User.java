package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class User {

    private String name;
    private String certificate;
    private Calendar dateOfVinculation;
    private ArrayList<Product> productCollection;

    private DateFormat formatter;


    public User(String name, String certificate) {

        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        this.name = name;
        this.certificate = certificate;
        this.dateOfVinculation = Calendar.getInstance();
        this.productCollection = new ArrayList<Product>();
        

    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getCertificate() {
        return certificate;
    }


    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Calendar getDateOfVinculation() {
        return dateOfVinculation;
    }

    public void setDateOfVinculation(Calendar dateOfVinculation) {
        this.dateOfVinculation = dateOfVinculation;
    }

    public String getDateOfVinculationFormated() {
		return formatter.format(this.dateOfVinculation.getTime());
	}


    public ArrayList<Product> getProductCollection() {
        return productCollection;
    }

    public String getProductsCollectionName(){
        String msg="";
        for(int i=0;i<productCollection.size();i++){
            msg += "\n" + productCollection.get(i).getName();
        }
        return msg;
    }

    public String getProductsCollectionCode(int position){
        String msg="";
   
        msg += productCollection.get(position).getId();

        return msg;
    }

    public void setProductCollection(ArrayList<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public boolean addProduct(Product product){

        return productCollection.add(product); 

    }

    public boolean deleteSuscription(int productPosition) {

        productCollection.remove(productPosition);
		

		return false;
	}
    

    
    
}
