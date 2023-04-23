package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class KnowledgeUnit {

	private String id;
	private int projectPosition;
	private StageAdvance capsuleStage; 
	private String description;
	private Type type;
	private String learnedLessons;
	private Status status;
	private Calendar approvationDate;
	private String url;

	private DateFormat formatter;
    public int length;
	public Object htmlBuilder;

	public KnowledgeUnit(String id, int projectPosition, StageAdvance capsuleStage, String description, Type type, String learnedLessons, Calendar approvationDate) {


		this.formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		this.id = id;
		this.projectPosition = projectPosition;
		this.capsuleStage = capsuleStage;
		this.description = description;
		this.type = type;
		this.learnedLessons = learnedLessons;
		this.status = Status.UNDEFINED;
		this.approvationDate = approvationDate;

	}

	public String getId() {
		return id;
	}

	public int getProjectPosition(){
		return projectPosition;
	}

	public StageAdvance getCapsuleStage(){
		return capsuleStage;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Calendar getApprovationDate(){
		return approvationDate;
	}

	public void setApprovationDate(Calendar approvationDate){
		this.approvationDate = approvationDate;
	}

	public String getApprovationDateFormated() {
		return formatter.format(this.approvationDate.getTime());
	}		

	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}

	public String approve(){
		
		String msg= "";

		if(status != Status.UNDEFINED){
			msg = "\nId: " + id + "\nProject position: " + projectPosition + "\nCapsule stage: " + capsuleStage + "\nDescription: " + description + "\nType: " + type 
			+ "\nLearned lessons: " + learnedLessons + "\nStatus: " + status + "\nApprovation date: " + getApprovationDateFormated();
		}

		return msg;	
	}

	public String notApprove(){

		String msg= "";
		if(status == Status.UNDEFINED){
			msg = "\nId: " + id + "\nProject position: " + projectPosition + "\nCapsule stage: " + capsuleStage + "\nDescription: " + description + "\nType: " + type 
			+ "\nLearned lessons: " + learnedLessons + "\nStatus: " + status;

		}

		return msg;	
	}


}


