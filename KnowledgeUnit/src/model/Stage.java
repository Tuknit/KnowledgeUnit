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

    private DateFormat formatter;

    public Stage(Calendar plannedBeginDate, Calendar realBeginDate, Calendar plannedFinishDate, Calendar realFinishDate){

        this.formatter = new SimpleDateFormat("dd/MM/yyyy");

        this.stateStage = Status.NOT_APPROVE;
        this.plannedBeginDate = plannedBeginDate;
        this.realBeginDate = realBeginDate;
        this.plannedFinishDate = plannedFinishDate;
        this.realFinishDate = realFinishDate;
        
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
