package model;

public class Regular extends User implements Publicity {

    public Regular(String name, String certificate) {
        super(name, certificate);
        
    }

    @Override
    public String toString() {
        return "\n"+ "\nRegular user name: " + this.getName() + "\nCertificate: " + this.getCertificate() + "\nDate of vinculation: " + this.getDateOfVinculationFormated()  + "\nProduct collection: " + this.getProductsCollectionName();
    }

    @Override
    public String getShowPublicity() {
        
        String msg = "";

        int randomAd = (int)(Math.random() * 3 + 1);

        if(randomAd == 1){
            msg += FIRSTAD;
        } else if (randomAd == 2){
            msg += SECONDAD;
        } else if (randomAd == 3){
            msg += THIRDAD;
        } else {
            msg += FIRSTAD;
        }

        return msg;
    }
    
    
}

