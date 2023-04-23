package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stage {

    private Status stateStage;    
    private Calendar plannedBeginDate;
	private Calendar realBeginDate;
    private Calendar plannedFinishDate;
    private Calendar realFinishDate;
    private KnowledgeUnit[] capsules = new KnowledgeUnit[50];

    private DateFormat formatter;

    public Stage(Calendar plannedBeginDate, Calendar realBeginDate, Calendar plannedFinishDate, Calendar realFinishDate){

        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        this.stateStage = Status.NOT_APPROVE;
        this.plannedBeginDate = plannedBeginDate;
        this.realBeginDate = realBeginDate;
        this.plannedFinishDate = plannedFinishDate;
        this.realFinishDate = realFinishDate;
        this.capsules = new KnowledgeUnit[50];
        
    }

    

    public String getCapsulesApprove(int capsuleInformation) {

        String msg = "";

        if (capsules[capsuleInformation] != null){
            return capsules[capsuleInformation].approve();
        } else {
            if (capsuleInformation == 1){
                msg = "No capsules registered at the beginning stage";
            } else if  (capsuleInformation == 2) {
                msg = "No capsules registered at the analysis stage";
            } else if (capsuleInformation == 3){
                msg = "No capsules registered at the design stage";
            } else if (capsuleInformation == 4){
                msg = "No capsules registered at the execution stage";
            } else if (capsuleInformation == 5) {
                msg = "No capsules registered at the closure stage";
            } else {
                msg = "No capsules registered at the following and control stage";
            }
        }

        return msg;
    }

    public String getCapsulesNotApprove(int capsuleInformation) {

        String msg = "";

        if (capsules[capsuleInformation] != null){
            return capsules[capsuleInformation].notApprove();
        } else {
            if (capsuleInformation == 1){
                msg = "No capsules registered at the beginning stage";
            } else if  (capsuleInformation == 2) {
                msg = "No capsules registered at the analysis stage";
            } else if (capsuleInformation == 3){
                msg = "No capsules registered at the design stage";
            } else if (capsuleInformation == 4){
                msg = "No capsules registered at the execution stage";
            } else if (capsuleInformation == 5) {
                msg = "No capsules registered at the closure stage";
            } else {
                msg = "No capsules registered at the following and control stage";
            }
        }

        return msg;
    }

    public void setCapsules(KnowledgeUnit capsule) {

        for(int i = 0; i<capsules.length ;i++){

			if(capsules[i]==null){
				this.capsules[i] = capsule;
			}

		}
    }
    
    public Status getStateStage(){
        return stateStage;
    } 

    public void setStateStage(Status stateStage){
        this.stateStage = stateStage;
    }

    public Calendar getPlannedBeginDate(){
		return plannedBeginDate;
	}

    public String getPlannedBeginDateFormated(){
		return formatter.format(this.plannedBeginDate.getTime());
	}

    public Calendar getRealBeginDate(){
    return realBeginDate;
	}

    public String getRealBeginDateFormated(){
		return formatter.format(this.realBeginDate.getTime());
	}

    public void setRealBeginDate(Calendar realBeginDate){
        this.realBeginDate = realBeginDate;
    }

    public Calendar getPlannedFinishDate(){
		return plannedFinishDate;
	}

    public String getPlannedFinishDateFormated(){
		return formatter.format(this.plannedFinishDate.getTime());
	}

    public Calendar getRealFinishDate(){
		return realFinishDate;
	}

    public void setRealFinishDate(Calendar realFinishDate){
        this.realFinishDate = realFinishDate;
    }

    public String getRealFinishDateFormated(){
		return formatter.format(this.realFinishDate.getTime());
	}


    
}
