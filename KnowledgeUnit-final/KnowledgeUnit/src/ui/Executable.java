package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller controller;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Executable exe = new Executable();
		exe.menu();

	}

	public void menu() {

		System.out.println("Welcome to KnowledgeUnit");

		boolean condition = false;

		while (!condition) {

			System.out.println("1. Create project");
			System.out.println("2. Consult a project");
			System.out.println("3. Register capsules");
			System.out.println("4. Approve capsules");
			System.out.println("5. Consult the information of the capsules");
			System.out.println("6. Approve stage");
			System.out.println("7. Publicate capsule");
			System.out.println("8. Exit");
			int option = reader.nextInt();

			switch (option) {

				case 1:
					createAProject();
					break;

				case 2:
					showAllCreatedProjects();
					break;

				case 3:
					registerKnowledgeUnit();
					break;

				case 4:
					approveKnowledgeUnit();
					break;

				case 5:
					showAllKnowledgeUnits();
					break;

				case 6:
					approveStage();
					break;

				case 7:
					publicateCapsules();
					break;

				case 8:
					condition = true;
					break;

			}

		}

	}

	public void createAProject() {

		System.out.println("Enter the information necesary for create a project");

		reader.nextLine();

		System.out.println("Please type the project id");
		String idProject = reader.nextLine();

		System.out.println("Please type the project name");
		String projectName = reader.nextLine();

		System.out.println("Please type the client name");
		String clientName = reader.nextLine();

		System.out.println("Please type the project type \n1. Development \n2. Mantenance \n3. Deployment");
		int projectType = reader.nextInt();

		System.out.println("Please type the day of the initial date");
		int initialDateDay = reader.nextInt();

		System.out.println("Please type the month of the initial date");
		int initialDateMonth = reader.nextInt();

		System.out.println("Please type the year of the initial date");
		int initialDateYear = reader.nextInt();

		System.out.println("Please type the project budget");
		double budget = reader.nextDouble();

		reader.nextLine();

		System.out.println("Please type the name of the GreenSQL manager");
		String companyManager = reader.nextLine();

		System.out.println("Please type the phone number of the GreenSQL manager");
		String companyManagerPhone = reader.nextLine();

		System.out.println("Please type the name of the client manager");
		String clientManager = reader.nextLine();

		System.out.println("Please type the phone number of the client manager");
		String clientManagerPhone = reader.nextLine();

		System.out.println("Please type the month of the beginning stage");
		int beginningMonthDuration = reader.nextInt();

		System.out.println("Please type the month of the analysis stage");
		int analysisMonthDuration = reader.nextInt();

		System.out.println("Please type the month of the design stage");
		int designMonthDuration = reader.nextInt();

		System.out.println("Please type the month of the execution stage");
		int executionMonthDuration = reader.nextInt();

		System.out.println("Please type the month of the closure stage");
		int closureMonthDuration = reader.nextInt();

		System.out.println("Please type the month of the following and control stage");
		int followingAndControlMonthDuration = reader.nextInt();

		System.out.println("Please type the day of the final date");

		if (controller.createAProject(idProject, projectName, clientName, projectType, initialDateDay, initialDateMonth,
				initialDateYear, budget, companyManager, companyManagerPhone, clientManager, clientManagerPhone,
				beginningMonthDuration, analysisMonthDuration, designMonthDuration, executionMonthDuration,
				closureMonthDuration, followingAndControlMonthDuration)) {

			System.out.println("The project is been create correctly");

		} else {

			System.out.println("The memory is full, the project is not been created");
		}

	}

	public void showAllCreatedProjects() {

		System.out.println("Is necessary a date for search the project");

		System.out.println("Please type the day of the date");
		int searchDateDay = reader.nextInt();

		System.out.println("Please type the month of the date");
		int searchDateMonth = reader.nextInt();

		System.out.println("Please type the year of the date");
		int searchDateYear = reader.nextInt();

		System.out.println("Now, type what projects you want to search ");
		System.out.println("1. Consult projects that end before a date");
		System.out.println("2. Consult projects starting after a date");
		int searchOption = reader.nextInt();

		String consult = "";

		if (searchOption == 1) {
			consult = controller.searchProjectsBeforeDate(searchDateDay, searchDateMonth, searchDateYear);
		} else {
			consult = controller.searchProjectsAfterDate(searchDateDay, searchDateMonth, searchDateYear);
		}

		if (consult.equals("")) {

			System.out.println("Its not registred capsules");
		} else {
			System.out.println(consult);
		}

	}

	private void approveKnowledgeUnit() {

		String consult = controller.consultRegistratedCapsules();

		if (consult.equals("")) {

			System.out.println("No found capsules registrated");
		} else {

			System.out.println("This are the capsules registrated in the sistem");

			System.out.println(consult);

			System.out.println("Choose the position of the capsule for modificate their state");
			int position = reader.nextInt();

			System.out.println("Please enter the state of the capsule \n1. APPROVE \n2. NOT_APPROVE");
			int state = reader.nextInt();

			controller.approveKnowledgeUnit(position - 1, state);
		}

		System.out.println("The operation are succesfull");
	}

	public void registerKnowledgeUnit() {

		String registredProyects = controller.getProjectList();

		if (registredProyects.equals("")) {

			System.out.println("No registered projects found ");

		} else {
			
			System.out.println("\nThese are the projects registered in the system");

			System.out.println(registredProyects);

			System.out.println("\nPlease type the project position");
			int projectPosition = reader.nextInt();

			if (controller.searchSpecificProject(projectPosition)) {

				System.out.println("Enter the information necesary for register a capsule");

				reader.nextLine();

				System.out.println("Please type the id of the capsule");
				String id = reader.nextLine();

				System.out.println(
						"Please type the stage of the capsule \n1. Beginning \n2. Analysis \n3. Design \n4. Execution \n5. Closure \n6. Following and control");
				int capsuleInformation = reader.nextInt();

				reader.nextLine();

				System.out.println("Please type the description of the capsule");
				String description = reader.nextLine();

				System.out.println(
						"Please type the kind of the capsule \n1. Technical \n2. Management \n3. Domain \n4. Experiences");
				int type = reader.nextInt();

				reader.nextLine();

				System.out.println("Please type the learned lessons of the capsule");
				String learnedLessons = reader.nextLine();

				if (controller.countCapsulesForStage(capsuleInformation) <= 50) {

					if (controller.registerKnowledgeUnit(projectPosition, id, capsuleInformation, description, type,
							learnedLessons)) {

						System.out.println("The capsule are registrated correctly");
					} else {

						System.out.println("The memory is full, the capsule are no registrated");
					}
				} else {
					System.out.println("The maximum number of capsules per stage has already been reached");
				}

			} else {
				System.out.println("The choseen project is not registred in the program");
			}

		}

	}

	public void showAllKnowledgeUnits() {

		System.out.println("This are the capsules registrated in the system ");

		String consult = controller.consultRegistratedCapsules();

		if (consult.equals("")) {

			System.out.println("Its not registred capsules");
		} else {
			System.out.println(consult);
		}
	}

	public void approveStage() {

		String consult = controller.searchAllProjects();

		if (consult.equals("")) {

			System.out.println("Its not registred project");
		} else {
			System.out.println(consult);

			System.out.println("Choose the project position for change the approvation");
			int projectPosition = reader.nextInt();

			System.out.println("Please type the day of the approvation date");
			int approvationStageDay = reader.nextInt();

			System.out.println("Please type the month of the approvation date");
			int approvationStageMonth = reader.nextInt();

			System.out.println("Please type the year of the approvation date");
			int approvationStageYear = reader.nextInt();

			controller.approveStage(projectPosition, approvationStageDay, approvationStageMonth - 1,
					approvationStageYear);

			System.out.println("Your stage as been modificated");

		}
	}

		public void publicateCapsules(){

		String consult = controller.capsulePublication();

		System.out.println(consult);
		//System.out.println(controller.capsulePublication());

	}

}