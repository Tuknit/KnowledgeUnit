package model;

public class Premium extends User {

    public Premium(String name, String certificate) {
        super(name, certificate);
    }

    @Override
    public String toString() {
        return "\n"+ "\npremium user name: " + this.getName() + "\nCertificate: " + this.getCertificate() + "\nDate of vinculation: " + this.getDateOfVinculationFormated() + "\nProduct collection: " + this.getProductsCollectionName();
    }
    
    
}
