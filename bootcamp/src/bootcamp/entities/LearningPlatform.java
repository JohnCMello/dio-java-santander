package bootcamp.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exceptions.DuplicateEntryException;
import exceptions.InvalidMenuOptionException;

public class LearningPlatform {

	private static List<Bootcamp> bootcamps = new ArrayList<>();
	private static List<Dev> devs = new ArrayList<>();
	private static List<Course> courses = new ArrayList<>();
	private static List<Mentorship> mentorships = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void run() {
		Locale.setDefault(Locale.US);
		boolean isRunning = true;
		boolean isFirstLoad = true;

		do {
			if (isFirstLoad) {
				isFirstLoad = false;
				clearScreen();
			}
			try {

				displayGeneralMenu();

				int generalMenuOptions = getGeneralMenuOption(sc, "general");

				switch (generalMenuOptions) {
				case 1:
					simulatePlatformAction();
					break;
				case 2:
					simulateDevAction();
					break;
				case 0:
					isRunning = false;
					System.out.println("Saindo da plataforma...");
					break;
				default:
					throw new InvalidMenuOptionException("Opcao invalida. Tente novamente.");
				}

			} catch (InvalidMenuOptionException | DuplicateEntryException e) {
				System.out.println(e.getMessage());
			}
		} while (isRunning);

		sc.close();
	}

	private static void displayGeneralMenu() {
		System.out.println("################################################");
		System.out.println(" *** Bem vindo a nossa plataforma de ensino *** ");
		System.out.println("################################################");
		System.out.println("\nDigite uma opcao para simular uma acao:");
		System.out.println("1 - Simular ação Plataforma (criar Bootcamp/Curso/Mentoria)");
		System.out.println("2 - Simular ação Dev (inscrever em Bootcamp/Curso/Mentoria)");
		System.out.println("0 - Sair");
		System.out.println("\n################################################");
	}

	private static int getGeneralMenuOption(Scanner sc, String context) throws InvalidMenuOptionException {
		System.out.println("\nDigite uma opcao");

		try {
			String generalMenuInput = sc.nextLine();
			int selectedOption = Integer.parseInt(generalMenuInput);

			switch (context) {
			case "general":
				if (selectedOption >= 0 && selectedOption <= 2) {
					return selectedOption;
				}
				break;
			case "platform":
				if (selectedOption >= 0 && selectedOption <= 6) {
					return selectedOption;
				}
				break;
			case "dev":
				if (selectedOption >= 0 && selectedOption <= 4) {
					return selectedOption;
				}
				break;
			case "bootcamp":
				if (selectedOption >= 0 && selectedOption <= 3) {
					return selectedOption;
				}
			}

			throw new InvalidMenuOptionException("Opção inválida.");
		} catch (NumberFormatException e) {
			throw new InvalidMenuOptionException("Entrada inválida. Por favor, digite um número.");
		}
	}

	private static void simulatePlatformAction() throws InvalidMenuOptionException, DuplicateEntryException {
		clearScreen();
		System.out.println("\nSimulando acoes da plataforma...");

		boolean isPlatformRunning = true;
		boolean returnToMainMenu = false;
		do {
			System.out.println("\nMenu Plataforma:\n");
			System.out.println("1 - Criar Bootcamp");
			System.out.println("2 - Criar Curso");
			System.out.println("3 - Criar Mentoria");
			System.out.println("4 - Listar Bootcamps");
			System.out.println("5 - Listar Cursos");
			System.out.println("6 - Listar Mentorship");
			System.out.println("0 - Voltar ao menu principal");
			System.out.println("\n################################################");

			int platformMenuOption = getGeneralMenuOption(sc, "platform");

			switch (platformMenuOption) {
			case 1:
				createBootcamp();
				break;
			case 2:
				createCourse();
				break;
			case 3:
				createMentorship();
				break;
			case 4:
				listBootcamps();
				returnToMainMenu = askToReturnToMainMenu(sc);
				if (returnToMainMenu) {
					clearScreen();
				}
				returnToMainMenu = false;
				break;
			case 5:
				listCourses();
				returnToMainMenu = askToReturnToMainMenu(sc);
				if (returnToMainMenu) {
					clearScreen();
				}
				returnToMainMenu = false;
				break;
			case 6:
				listMentorships();
				returnToMainMenu = askToReturnToMainMenu(sc);
				if (returnToMainMenu) {
					clearScreen();
				}
				returnToMainMenu = false;
				break;
			case 0:
				isPlatformRunning = false;
				break;
			default:
				throw new InvalidMenuOptionException("Opcao invalida. Tente novamente.");
			}
		} while (isPlatformRunning);
	}

	private static void listBootcamps() {
		System.out.println("\nListando Bootcamps:");
		for (Bootcamp bootcamp : bootcamps) {
			System.out.println("- " + bootcamp.getTitle());
		}

	}

	private static void listCourses() {
		System.out.println("\nListando Cursos:");
		for (Course course : courses) {
			System.out.println("- " + course.getTitle());
		}
	}

	private static void listMentorships() {
		System.out.println("\nListando Mentorship:");
		for (Mentorship mentorship : mentorships) {
			System.out.println("- " + mentorship.getTitle());
		}

	}

	private static void createBootcamp() throws DuplicateEntryException, InvalidMenuOptionException {
		clearScreen();
		System.out.println("\nCriando um Bootcamp...");

		String startDateStr = getLocalDateInput("Digite a data de inicio (dd/MM/yyyy): ");
		String finishDateStr = getLocalDateInput("Digite a data de termino (dd/MM/yyyy): ");
		String title = getStringInput("Digite o titulo do Bootcamp: ");
		String description = getStringInput("Digite a descricao do Bootcamp: ");

		for (Bootcamp bootcamp : bootcamps) {
			if (bootcamp.getTitle().equalsIgnoreCase(title)) {
				throw new DuplicateEntryException("Bootcamp com este nome ja existe.");
			}

		}

		Bootcamp bootcamp = new Bootcamp(startDateStr, finishDateStr, title, description);
		bootcamps.add(bootcamp);

		System.out.println("\nBootcamp criado com sucesso!");
		System.out.println(bootcamp);

		boolean addNewCourseMontorship = true;

		while (addNewCourseMontorship) {
			System.out.println("\nDeseja adicionar um curso ou mentoria ao Bootcamp recém-criado?");
			System.out.println("1 - Criar Curso");
			System.out.println("2 - Criar Mentoria");
			System.out.println("3 - Adicionar a partir da lista");
			System.out.println("0 - Voltar ao menu principal");
			System.out.println("\n################################################");
			int addOption = getGeneralMenuOption(sc, "bootcamp");
			switch (addOption) {
			case 1:
				createCourse();
				break;
			case 2:
				createMentorship();
				break;
			case 3:
				addExistingCourseMentorship(bootcamp);
			case 0:
				addNewCourseMontorship = false;
				break;
			default:
				System.out.println("Opção inválida. Voltando ao menu principal.");
			}
		}

		boolean returnToMainMenu = askToReturnToMainMenu(sc);
		if (returnToMainMenu) {
			clearScreen();
		}
	}

	private static void addExistingCourseMentorship(Bootcamp bootcamp) throws InvalidMenuOptionException {
		clearScreen();
		System.out.println("\nAdicionando da lista existente de Curso ou Mentoria:");

		System.out.println("\nCursos Disponíveis:");
		listCourses();

		System.out.println("\nMentorias Disponíveis:");
		listMentorships();

		boolean validSelection = false;
		while (!validSelection) {
			System.out.println("\nDigite o numero do Curso ou Mentoria que deseja adicionar (0 para cancelar): ");
			int selection = getIntInput("Digite o numero: ");

			if (selection == 0) {
				return;
			} else if (selection > 0 && selection <= (courses.size() + mentorships.size())) {
				if (selection <= courses.size()) {
					Course selectedCourse = courses.get(selection - 1);
					bootcamp.addCourse(selectedCourse);
					System.out.println("Curso '" + selectedCourse.getTitle() + "' adicionado ao Bootcamp '"
							+ bootcamp.getTitle() + "'.");
				} else {
					Mentorship selectedMentorship = mentorships.get(selection - courses.size() - 1);
					bootcamp.addMentorship(selectedMentorship);
					System.out.println("Mentoria '" + selectedMentorship.getTitle() + "' adicionada ao Bootcamp '"
							+ bootcamp.getTitle() + "'.");
				}
				validSelection = true;
			} else {
				throw new InvalidMenuOptionException("Opção inválida. Por favor, digite um número válido.");
			}
		}
	}

	private static void createCourse() throws DuplicateEntryException {
		clearScreen();
		System.out.println("\nCriando um Curso...");

		String title = getStringInput("Digite o titulo do Curso: ");
		String description = getStringInput("Digite a descricao do Curso: ");
		int xpValue = getIntInput("Digite o valor de XP do Curso: ");
		int totalHours = getIntInput("Digite a carga horaria total do Curso (horas): ");
		sc.nextLine();
		String courseDateStr = getLocalDateInput("Digite a data do Curso (dd/MM/yyyy): ");

		for (Course course : courses) {
			if (course.getTitle().equalsIgnoreCase(title)) {
				throw new DuplicateEntryException("Curso com este título ja existe.");
			}
		}

		Course course = new Course(title, description, xpValue, courseDateStr, totalHours);
		courses.add(course);

		System.out.println("Curso criado com sucesso!");

		boolean returnToMainMenu = false;

		returnToMainMenu = askToReturnToMainMenu(sc);
		if (returnToMainMenu) {
			clearScreen();
		}
	}

	private static void createMentorship() throws DuplicateEntryException {
		clearScreen();
		System.out.println("\nCriando uma Mentoria...");

		String title = getStringInput("Digite o titulo da Mentoria: ");
		String description = getStringInput("Digite a descricao da Mentoria: ");
		int xpValue = getIntInput("Digite o valor de XP da Mentoria: ");
		sc.nextLine();
		String mentorshipDateStr = getLocalDateInput("Digite a data da Mentoria (dd/MM/yyyy): ");
		for (Mentorship mentorship : mentorships) {
			if (mentorship.getTitle().equalsIgnoreCase(title)) {
				throw new DuplicateEntryException("Mentoria com este titulo ja existe.");
			}
		}

		Mentorship mentorship = new Mentorship(title, description, mentorshipDateStr, xpValue);
		mentorships.add(mentorship);

		System.out.println("Mentoria criada com sucesso!");

		boolean returnToMainMenu = false;

		returnToMainMenu = askToReturnToMainMenu(sc);
		if (returnToMainMenu) {
			clearScreen();
		}
	}

	private static void simulateDevAction() throws InvalidMenuOptionException, DuplicateEntryException {
		clearScreen();
		System.out.println("\nSimulando acoes de um Dev...");

		String email = getStringInput("Digite o seu email: ");
		Dev currentDev = findDevByEmail(email);

		if (currentDev == null) {
			System.out.println("Dev nao registrado. E necessario se registrar para realizar acoes como Dev.");
			currentDev = registerDev();
		} else {
			System.out.println("Login realizado com sucesso!");
		}

		boolean isDevRunning = true;
		do {
			System.out.println("\nMenu Dev:");
			System.out.println("1 - Inscrever em Bootcamp");
			System.out.println("2 - Inscrever em Curso");
			System.out.println("3 - Inscrever em Mentoria");
			System.out.println("4 - Ver meus dados e inscricoes");
			System.out.println("0 - Voltar ao menu principal");
			System.out.println("################################################");

			int devMenuOption = getGeneralMenuOption(sc, "dev");

			switch (devMenuOption) {
			case 1:
				enrollDevInBootcamp(currentDev);
				break;
			case 2:
				enrollDevInCourse(currentDev);
				break;
			case 3:
				enrollDevInMentorship(currentDev);
				break;
			case 4:
				showDevInfo(currentDev);
				break;
			case 0:
				isDevRunning = false;
				break;
			default:
				throw new InvalidMenuOptionException("Opcao invalida. Tente novamente.");
			}
		} while (isDevRunning);
	}

	private static Dev findDevByEmail(String email) {
		for (Dev dev : devs) {
			if (dev.getEmail().equalsIgnoreCase(email)) {
				return dev;
			}
		}
		return null;
	}

	private static Dev registerDev() throws DuplicateEntryException {
		System.out.println("\nE necessario se registrar para realizar acoes como Dev.");

		String name = getStringInput("Digite o seu nome: ");
		String email = getStringInput("Digite o seu email: ");

		for (Dev dev : devs) {
			if (dev.getEmail().equalsIgnoreCase(email)) {
				throw new DuplicateEntryException("Dev ja registrado com este email.");
			}
		}

		Dev dev = new Dev(name, email);
		devs.add(dev);
		System.out.println("Dev registrado com sucesso!");
		boolean returnToMainMenu = false;

		returnToMainMenu = askToReturnToMainMenu(sc);
		if (returnToMainMenu) {
			clearScreen();
		}
		return dev;

	}

	private static void enrollDevInBootcamp(Dev dev) throws InvalidMenuOptionException {
		clearScreen();
		System.out.println("\nListando Bootcamps disponíveis:");
		List<Bootcamp> availableBootcamps = findAvailableBootcamps(dev);

		if (availableBootcamps.isEmpty()) {
			System.out.println("Nao ha Bootcamps disponiveis no momento.");
			return;
		}

		for (int i = 0; i < availableBootcamps.size(); i++) {
			Bootcamp bootcamp = availableBootcamps.get(i);
			System.out.println((i + 1) + " - " + bootcamp.getTitle());
		}

		int chosenBootcamp = getIntInput("Digite o numero do Bootcamp que deseja se inscrever (0 para cancelar): ");
		if (chosenBootcamp > 0 && chosenBootcamp <= availableBootcamps.size()) {
			Bootcamp bootcamp = availableBootcamps.get(chosenBootcamp - 1);
			bootcamp.addParticipant(dev);
			System.out.println("Inscricao no Bootcamp '" + bootcamp.getTitle() + "' realizada com sucesso!");

		} else if (chosenBootcamp == 0) {
			System.out.println("Inscrição cancelada.");
		} else {
			throw new InvalidMenuOptionException("Opcao invalida. Tente novamente.");
		}

		boolean returnToMainMenu = false;

		returnToMainMenu = askToReturnToMainMenu(sc);
		if (returnToMainMenu) {
			clearScreen();
		}
	}

	private static void enrollDevInCourse(Dev dev) throws InvalidMenuOptionException {
		clearScreen();
		System.out.println("\nListando Cursos disponíveis:");

		List<Course> availableCourses = findAvailableCourses(dev);

		if (availableCourses.isEmpty()) {
			System.out.println("Nao ha Cursos disponíveis no momento.");
			return;
		}

		for (int i = 0; i < availableCourses.size(); i++) {
			Course course = availableCourses.get(i);
			System.out.println((i + 1) + " - " + course.getTitle());
		}

		int chosenCourse = getIntInput("Digite o numero do Curso que deseja se inscrever (0 para cancelar): ");
		if (chosenCourse > 0 && chosenCourse <= availableCourses.size()) {
			Course course = availableCourses.get(chosenCourse - 1);
			dev.enrollCourse(course);
			System.out.println("Inscricao no Curso '" + course.getTitle() + "' realizada com sucesso!");
		} else if (chosenCourse == 0) {
			System.out.println("Inscricao cancelada.");
		} else {
			throw new InvalidMenuOptionException("Opcao invalida. Tente novamente.");
		}

		boolean returnToMainMenu = false;

		returnToMainMenu = askToReturnToMainMenu(sc);
		if (returnToMainMenu) {
			clearScreen();
		}
	}

	private static void enrollDevInMentorship(Dev dev) throws InvalidMenuOptionException {
		clearScreen();
		System.out.println("\nListando Mentorias disponíveis:");

		List<Mentorship> availableMentorships = findAvailableMentorships(dev);

		if (availableMentorships.isEmpty()) {
			System.out.println("Nao ha Mentorias disponiveis no momento.");
			return;
		}

		for (int i = 0; i < availableMentorships.size(); i++) {
			Mentorship mentorship = availableMentorships.get(i);
			System.out.println((i + 1) + " - " + mentorship.getTitle());
		}

		int chosenMentorship = getIntInput("Digite o numero da Mentoria que deseja se inscrever (0 para cancelar): ");
		if (chosenMentorship > 0 && chosenMentorship <= availableMentorships.size()) {
			Mentorship mentorship = availableMentorships.get(chosenMentorship - 1);
			dev.enrollMentorship(mentorship);
			System.out.println("Inscricao na Mentoria '" + mentorship.getTitle() + "' realizada com sucesso!");
		} else if (chosenMentorship == 0) {
			System.out.println("Inscricao cancelada.");
		} else {
			throw new InvalidMenuOptionException("Opcao invalida. Tente novamente.");
		}
		boolean returnToMainMenu = false;

		returnToMainMenu = askToReturnToMainMenu(sc);
		if (returnToMainMenu) {
			clearScreen();
		}
	}

	private static List<Bootcamp> findAvailableBootcamps(Dev dev) {
		List<Bootcamp> availableBootcamps = new ArrayList<>();
		for (Bootcamp bootcamp : bootcamps) {
			if (!bootcamp.getParticipants().contains(dev)) {
				availableBootcamps.add(bootcamp);
			}
		}
		return availableBootcamps;
	}

	private static List<Course> findAvailableCourses(Dev dev) {
		List<Course> availableCourses = new ArrayList<>();
		for (Course course : courses) {
			if (!dev.getEnrolledCourses().contains(course)) {
				availableCourses.add(course);
			}
		}
		return availableCourses;
	}

	private static List<Mentorship> findAvailableMentorships(Dev dev) {
		List<Mentorship> availableMentorships = new ArrayList<>();
		for (Mentorship mentorship : mentorships) {
			if (!dev.getEnrolledMentorships().contains(mentorship)) {
				availableMentorships.add(mentorship);
			}
		}
		return availableMentorships;
	}

	private static void showDevInfo(Dev dev) {
		clearScreen();
		System.out.println("\nInformacoes do Dev:");
		System.out.println("Nome: " + dev.getName());
		System.out.println("Email: " + dev.getEmail());
		System.out.println("XP Total: " + dev.calculateTotalXp());
		System.out.println("Cursos Inscritos: ");
		for (Course course : dev.getEnrolledCourses()) {
			System.out.println("- " + course.getTitle());
		}
		System.out.println("Mentorias Inscritas: ");
		for (Mentorship mentorship : dev.getEnrolledMentorships()) {
			System.out.println("- " + mentorship.getTitle());
		}

		boolean returnToMainMenu = false;

		returnToMainMenu = askToReturnToMainMenu(sc);
		if (returnToMainMenu) {
			clearScreen();
		}
	}

	private static String getStringInput(String prompt) {
		System.out.println(prompt);
		return sc.nextLine();
	}

	private static int getIntInput(String prompt) {
		System.out.println(prompt);
		while (!sc.hasNextInt()) {
			System.out.println("Por favor, digite um numero inteiro.");
			sc.next();
		}
		return sc.nextInt();
	}

	private static String getLocalDateInput(String prompt) {
		System.out.println(prompt);
		String dateStr = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate.parse(dateStr, formatter); // Validate date format
		return dateStr;
	}

	static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private static boolean askToReturnToMainMenu(Scanner sc) {
		System.out.println("\nPressione Enter para retornar ao menu principal...");
		sc.nextLine();
		return true;
	}

	public static void main(String[] args) throws DuplicateEntryException {
		run();
	}
}
