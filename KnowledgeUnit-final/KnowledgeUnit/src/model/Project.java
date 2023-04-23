package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Project{
	
	private String idProject;
	private String projectName;
	private String clientName;
	private ProjectType projectType;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
	private String companyManager;
	private String companyManagerPhone;
	private String clientManager;
	private String clientManagerPhone;
	private MonthDuration duration;
	private Stage[] stages = new Stage[6];
	private DateFormat formatter;

	public Project(String idProject, String projectName, String clientName, ProjectType projectType, Calendar initialDate, Calendar finalDate, double budget, String companyManager, String companyManagerPhone, String clientManager, String clientManagerPhone, MonthDuration duration){
		
		this.formatter = new SimpleDateFormat("dd/MM/yyyy");

		this.idProject = idProject;
		this.projectName = projectName;	
		this.clientName = clientName;
		this.projectType = projectType;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
		this.companyManager = companyManager;
		this.companyManagerPhone = companyManagerPhone;
		this.clientManager = clientManager;
		this.clientManagerPhone = clientManagerPhone;
		this.duration = duration;
		plannedDates();

	}
	
	public Stage[] getStages(){
		return stages;
	}

	public MonthDuration getDuration(int beginningMonthDuration, int analysisMonthDuration, int designMonthDuration, int executionMonthDuration, int closureMonthDuration, int followingAndControlMonthDuration){
		return duration;
	}

	public void plannedDates(){

		Calendar nullDate = new GregorianCalendar(1900,1,1);
		Calendar nextDateBeg = Calendar.getInstance();
		Calendar nextDateAna = Calendar.getInstance();
		Calendar nextDateDes = Calendar.getInstance();
		Calendar nextDateExe = Calendar.getInstance();
		Calendar nextDateClo = Calendar.getInstance();
		Calendar nextDateFol = Calendar.getInstance();
		
		int year = initialDate.get(Calendar.YEAR);
		int month = initialDate.get(Calendar.MONTH);
		int day = initialDate.get(Calendar.DAY_OF_MONTH);

		nextDateBeg.set(year, month+duration.getBeginningMonthDuration(), day);
		nextDateAna.set(year, month+duration.getBeginningMonthDuration()+duration.getAnalysisMonthDuration() , day);
		nextDateDes.set(year, month+duration.getBeginningMonthDuration()+duration.getAnalysisMonthDuration()+duration.getDesignMonthDuration() , day);
		nextDateExe.set(year, month+duration.getBeginningMonthDuration()+duration.getAnalysisMonthDuration()+duration.getDesignMonthDuration()+duration.getExecutionMonthDuration() , day);
		nextDateClo.set(year, month+duration.getBeginningMonthDuration()+duration.getAnalysisMonthDuration()+duration.getDesignMonthDuration()+duration.getExecutionMonthDuration()+duration.getClosureMonthDuration() , day);
		nextDateFol.set(year, month+duration.getBeginningMonthDuration()+duration.getAnalysisMonthDuration()+duration.getDesignMonthDuration()+duration.getExecutionMonthDuration()+duration.getClosureMonthDuration()+duration.getFollowingAndControlMonthDuration() , day);
		
		//Beginning stage
		stages[0] = new Stage(initialDate, initialDate , nextDateBeg, nullDate);
		//Analysis stage
		stages[1] = new Stage(nextDateBeg, nullDate , nextDateAna, nullDate);
		//Design stage
		stages[2] = new Stage(nextDateAna, nullDate , nextDateDes, nullDate);
		//Execution stage
		stages[3] = new Stage(nextDateDes, nullDate , nextDateExe, nullDate);
		//Closure stage
		stages[4] = new Stage(nextDateExe, nullDate , nextDateClo, nullDate);
		//Following and control stage
		stages[5] = new Stage(nextDateClo, nullDate , nextDateFol, nullDate);

	}

	public void approveActiveStage(Calendar approvationDate){

		boolean update = false;
			
			int i = 0;

			while(!update){

				if (stages[i].getStateStage() == Status.NOT_APPROVE){
					update = true;
					stages[i].setStateStage(Status.APPROVE);
					stages[i].setRealFinishDate(approvationDate);

					if( i!=5 ){
						stages[i+1].setRealBeginDate(approvationDate);
					}
				} 

				i += 1;
			}

	}

	public String getIdProject(){
		return idProject;
	}

	public String getProjectName(){
		return projectName;
	}
	
	public String getClientName(){
		return clientName;
	}

	public ProjectType getProjectType(){
		return projectType;
	}

	public Calendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated() {
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated() {
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;
	}

	public String getCompanyManager(){
		return companyManager;
	}

	public String getCompanyManagerPhone(){
		return companyManagerPhone;
	}

	public String getClientManager(){
		return clientManager;
	}

	public String getClientManagerPhone(){
		return clientManagerPhone;
	}

	public String getProjectInfo() {
		String msg = "\nProject id: " + idProject + "\nProject name: " + projectName + "\nClient: " + clientName + "\nProject type: " + projectType + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + "\nGreenSQA manager: " + companyManager + "\nPhone of GreenSQA manager: " + companyManagerPhone + 
		"\nClient manager: " + clientManager + "\nPhone of client manager: " + clientManagerPhone + "\nMonth duration: " + duration.getTotalDuration() + "\nStage: " +  ".\n";
		
		msg += "Stage\t Planned begin date\t Planned finish date\t Real begin date\t Real finish date \t Status"; 

		String title = "";

		for (int i = 0;i < stages.length; i++){
			switch(i){

				case 0:
				title = "Beginning stage\t\t";
				break;
				case 1:
				title = "Analysis stage\t\t";
				break;
				case 2:
				title = "Design stage\t\t";
				break;
				case 3:
				title = "Execution stage\t\t";
				break;
				case 4:
				title = "Closure stage\t\t";
				break;
				case 5:
				title = "Following and control stage";
				break;
			}
			msg += "\n" + title + "\t\t" + stages[i].getPlannedBeginDateFormated() + "\t" + stages[i].getPlannedFinishDateFormated()  + "\t" +  stages[i].getRealBeginDateFormated() + "\t" +  stages[i].getRealFinishDateFormated() + "\t" + stages[i].getStateStage();
		}
	
		return msg;
	}

	public void stageCapsule(KnowledgeUnit capsules, int capsuleInformation){
		this.stages[capsuleInformation].setCapsules(capsules);
	}

	
	public String getStageCapsuleApprove(int capsuleInformation){
		return this.stages[capsuleInformation].getCapsulesApprove(capsuleInformation);
	}

	public String getStageCapsuleNotApprove(int capsuleInformation){
		return this.stages[capsuleInformation].getCapsulesNotApprove(capsuleInformation);
	}


}
