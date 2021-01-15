package view;

import manager.TeamManager;
import model.Player;
import model.PlayerNameCompare;
import model.PlayerSalaryCompare;

import java.util.Scanner;

import static view.Main.showMenu;

public class SubMain {
    public static Scanner sc = new Scanner(System.in);
    public static TeamManager teamManager;

    public static void setTeamManager(TeamManager teamManager) {
        SubMain.teamManager = teamManager;
    }

    public static PlayerNameCompare playerNameCompare = new PlayerNameCompare();
    public static PlayerSalaryCompare playerSalaryCompare = new PlayerSalaryCompare();

    public Player addNewPlayer() {
        System.out.println("Enter player's name:");
        String name = sc.nextLine();
        System.out.println("Enter player's birth:");
        String dateOfBirth = sc.nextLine();
        System.out.println("Enter player's country:");
        String country = sc.nextLine();
        System.out.println("Enter player's position:");
        String position = sc.nextLine();
        System.out.println("Enter player's salary:");
        int salary = Integer.parseInt(sc.nextLine());
        Player player = new Player(name, dateOfBirth, country, position, salary);
        return player;
    }

    public Player editPlayer() {
        Player editPlayer = addNewPlayer();
        return editPlayer;
    }

    public void findPlayer() {
        int choice;
        do {
            System.out.println("1.Find by name?");
            System.out.println("2.Find by salary?");
            System.out.println("3.Back to menu?");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter player's name you wanna find:");
                    String name = sc.nextLine();
                    teamManager.searchingByName(name);
                    break;
                case 2:
                    System.out.println("Enter player's salary you wanna find:");
                    int salary = Integer.parseInt(sc.nextLine());
                    teamManager.searchingBySalary(salary);
                    break;
                case 3:
                    showMenu();
                    break;
                default:
                    System.out.println("Oops...Let's try again.");
                    sc.nextLine();
                    showMenu();
            }
        } while (choice != 0);
    }

    public static void sortMenu() {
        int choose;
        do {
            System.out.println("1.Sort by name?");
            System.out.println("2.Sort by salary?");
            System.out.println("3.Back menu?");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    sortNamePlayer();
                    break;
                case 2:
                    sortSalaryPlayer();
                    break;
                case 3:
                    showMenu();
                    break;
                default:
                    System.out.println("Oops...Let's try again.");
                    sc.nextLine();
                    showMenu();
            }
        } while (choose != 0);
    }

    public static void sortNamePlayer() {
        int option;
        do {
            System.out.println("1.Sort Up");
            System.out.println("2.Sort Down");
            System.out.println("3. Back sort menu");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    teamManager.sort(playerNameCompare, 1);
                    break;
                case 2:
                    teamManager.sort(playerNameCompare, 2);
                    break;
                case 3:
                    sortMenu();
                    break;
                default:
                    System.out.println("Oops...Let's try again.");
                    sc.nextLine();
                    sortMenu();
            }
        } while (option != 0);
    }

    public static void sortSalaryPlayer() {
        int choice;
        do {
            System.out.println("1.Sort Up");
            System.out.println("2.Sort Down");
            System.out.println("3. Back sort menu");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    teamManager.sort(playerSalaryCompare, 1);
                    break;
                case 2:
                    teamManager.sort(playerSalaryCompare, 2);
                    break;
                case 3:
                    sortMenu();
                    break;
                default:
                    System.out.println("Oops...Let's try again.");
                    sc.nextLine();
                    sortMenu();
            }
        } while (choice != 0);
    }
}
