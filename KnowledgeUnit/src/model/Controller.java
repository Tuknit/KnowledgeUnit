package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private KnowledgeUnit[] units;
	private Project[] projects;

	public Controller() {

		units = new KnowledgeUnit[300];
		projects = new Project[10];

		testCases();

	}
	
	public void testCases() {
		
		units[0] = new KnowledgeUnit("A001", 0, StageAdvance.ANALYSIS, "Gestion de repositorios", Type.TECHNICAL, "GitHub es una herramienta util", new GregorianCalendar(2023, Calendar.FEBRUARY,11));
		units[1] = new KnowledgeUnit("A002", 0, StageAdvance.CLOSURE, "Gestion de equipos", Type.EXPERIENCES, "Es importante definir responsabilidades claras", new GregorianCalendar(2023, Calendar.OCTOBER,18));
		
	}

	public boolean createAProject(String idProject,String projectName, String clientName, int projectType, int initialDateDay, int initialDateMonth, int initialDateYear, double budget, String companyManager, String companyManagerPhone, String clientManager, String clientManagerPhone, int beginningMonthDuration, int analysisMonthDuration, int designMonthDuration, int executionMonthDuration, int closureMonthDuration, int followingAndControlMonthDuration){

		ProjectType assignType = ProjectType.DEVELOPMENT;

		if (projectType == 1){
			assignType = ProjectType.DEVELOPMENT;
		} else if  (projectType == 2) {
			assignType = ProjectType.MANTENANCE;
		} else {
			assignType = ProjectType.DEPLOYMENT;
		}

		Calendar initialDate = new GregorianCalendar(initialDateYear,initialDateMonth-1,initialDateDay);

		int totalDuration = beginningMonthDuration + analysisMonthDuration + designMonthDuration +executionMonthDuration +closureMonthDuration + followingAndControlMonthDuration;

		MonthDuration duration = new MonthDuration(totalDuration, beginningMonthDuration, analysisMonthDuration, designMonthDuration, executionMonthDuration, closureMonthDuration, followingAndControlMonthDuration);

		Calendar finalDate = new GregorianCalendar(initialDateYear,initialDateMonth-1,initialDateDay);

		finalDate.add(Calendar.MONTH, totalDuration);

		Project newProject = new Project(idProject, projectName, clientName, assignType, initialDate, finalDate, budget, companyManager, companyManagerPhone, clientManager, clientManagerPhone, duration);

		for(int i = 0; i<units.length; i++){

			if(projects[i]==null){
				projects[i] = newProject;
				return true;
			}
		}

		return false;



	}

	public String searchProjectsBeforeDate(int searchDateDay, int searchDateMonth, int searchDateYear) {

		String msg = "";

		Calendar searchDate = new GregorianCalendar(searchDateYear, searchDateMonth-1, searchDateDay);

		for(int i=0; i<projects.length; i++){

			if(projects[i]!=null){

				int val = searchDate.compareTo(projects[i].getFinalDate());

				if(val == 1){
					msg += "\n"+projects[i].getProjectInfo();
				}
			} 

		}


		return msg;

	}
	
	public String searchProjectsAfterDate(int searchDateDay, int searchDateMonth, int searchDateYear){

		String msg = "";

		Calendar searchDate = new GregorianCalendar(searchDateYear, searchDateMonth-1, searchDateDay);

		for(int i=0; i<projects.length; i++){

			if(projects[i]!=null){

				int val = searchDate.compareTo(projects[i].getInitialDate());

				if(val == -1){
					msg += "\n"+projects[i].getProjectInfo();
				}
			} 

		}

		return msg;

	}

	public String searchAllProjects(){

		String msg= "";

		for(int i=0; i<projects.length; i++){

			if(projects[i]!=null){

				msg += "\n" + "\nProject position:" + i + "\n"+projects[i].getProjectInfo();

			} 

		}

		return msg;

	}

	public int countAllProjects(){
		return projects.length;
	}

	public boolean searchSpecificProject(int projectPosition){

		if(projects[projectPosition]!=null){
			return true;
		}

		return false;

	}

	public boolean registerKnowledgeUnit(int projectPosition, String id, int capsuleInformation, String description, int type, String learnedLessons) {

		Type typeKnowLedgeUnit = Type.TECHNICAL;

		if (type == 1){
			typeKnowLedgeUnit = Type.TECHNICAL;
		} else if  (type == 2) {
			typeKnowLedgeUnit = Type.MANAGEMENT;
		} else if (type == 3){
			typeKnowLedgeUnit = Type.DOMAIN;
		} else {
			typeKnowLedgeUnit = Type.EXPERIENCES;
		}

		StageAdvance stageKU = StageAdvance.BEGINNING;

		if (capsuleInformation == 1){
			stageKU = StageAdvance.BEGINNING;
		} else if  (capsuleInformation == 2) {
			stageKU = StageAdvance.ANALYSIS;
		} else if (capsuleInformation == 3){
			stageKU = StageAdvance.DESIGN;
		} else if (capsuleInformation == 4){
			stageKU = StageAdvance.EXECUTION;
		} else if (capsuleInformation == 5) {
			stageKU = StageAdvance.CLOSURE;
		} else {
			stageKU = StageAdvance.FOLLOWING_AND_CONTROL;
		}

		KnowledgeUnit newKnowledgeUnit = new KnowledgeUnit(id, projectPosition, stageKU, description, typeKnowLedgeUnit, learnedLessons, new GregorianCalendar(Calendar.YEAR ,Calendar.FEBRUARY,Calendar.DAY_OF_MONTH));

		for(int i = 0; i<units.length;i++){

			if(units[i]==null){
				units[i] = newKnowledgeUnit;
				return true;
			}
		}

		return false;
	}

	public String consultRegistratedCapsules(){

		String msg = "";

		for(int i=0; i<units.length; i++){

			if(units[i]!=null){

				if(units[i].getStatus() == Status.APPROVE){
					msg += "\n"+units[i].approve();
				} else {
					msg += "\n"+units[i].notApprove();
				}
			}

		}

		return msg;

	}

	public int countCapsulesForStage(int capsuleInformation){

		StageAdvance stageKU = StageAdvance.BEGINNING;

		if (capsuleInformation == 1){
			stageKU = StageAdvance.BEGINNING;
		} else if  (capsuleInformation == 2) {
			stageKU = StageAdvance.ANALYSIS;
		} else if (capsuleInformation == 3){
			stageKU = StageAdvance.DESIGN;
		} else if (capsuleInformation == 4){
			stageKU = StageAdvance.EXECUTION;
		} else if (capsuleInformation == 5) {
			stageKU = StageAdvance.CLOSURE;
		} else {
			stageKU = StageAdvance.FOLLOWING_AND_CONTROL;
		}

		int capsuleQuantity = 0;

		/* 
		if (units[0]!=null){
		
			for(int i=0; i<units.length; i++){

				if(units[i].getCapsuleStage() == stageKU){

					capsuleQuantity += 1;

				}

			}
		}
		*/

		return capsuleQuantity;
	}


	public int approveKnowledgeUnit(int position, int state) {
		
		if (state == 1){

			units[position].setStatus(Status.APPROVE);

			units[position].setApprovationDate(new GregorianCalendar());;

		} else {

			units[position].setStatus(Status.NOT_APPROVE);

		}

		return state;
	}

	public String capsulePublication(){


		String msg = "<table>";
	
		for(int i=0; i<units.length; i++){
	
			if(units[i]!=null){
	
				if(units[i].getStatus() == Status.APPROVE){
					msg += "<tr> <td>";
					msg += "\n"+units[i].approve();
					msg += "<\td> <\tr>"; 

					units[i].setUrl("url");
				} 
			}
	
		}

		msg += "<\table>"; 

		return msg;

	}

	public String approveStage(int projectPosition, int approvationStageDay, int approvationStageMonth, int approvationStageYear) {

		String msg = "";

		Calendar approvationDate = new GregorianCalendar(approvationStageYear, approvationStageMonth, approvationStageDay);

		projects[projectPosition].approveActiveStage(approvationDate);

		msg += "\n"+projects[projectPosition].getProjectInfo();

		return msg;


	}

}
