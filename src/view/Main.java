package view;

import manager.TeamManager;
import model.Football;
import model.Player;
import java.util.Scanner;

import static view.SubMain.sortMenu;

public class Main {
    public static TeamManager teamManager = new TeamManager();
    public static Scanner sc = new Scanner(System.in);
    public static SubMain subMain = new SubMain();
    public static void main(String[] args) {
         SubMain.setTeamManager(teamManager);
        System.out.println("Welcome back to my football team : LIVERPOOL");
        showMenu();
    }

    public static void showMenu() {
        int choice = 0;
        do {
            System.out.println("1.Add new player.");
            System.out.println("2.Edit player on team.");
            System.out.println("3.Remove player on team.");
            System.out.println("4.Find player.");
            System.out.println("5.Sort player.");
            System.out.println("6.Show my team.");
            System.out.println("7.Exit");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter number of player you wanna add:");
                    int numberOfPlayer = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < numberOfPlayer; i++) {
                        Player newPlayer = subMain.addNewPlayer();
                        teamManager.addNewPlayer(newPlayer);
                    }
                    break;
                case 2:
                    System.out.println("Enter index of player you wanna edit:");
                    int index = Integer.parseInt(sc.nextLine());
                    Player editPlayer = subMain.editPlayer();
                    teamManager.editPlayer(index,editPlayer);
                    break;
                case 3:
                    System.out.println("Enter player's name you wanna remove:");
                    String name = sc.nextLine();
                    teamManager.removePlayerByName(name);
                    break;
                case 4:
                    subMain.findPlayer();
                    break;
                case 5:
                    sortMenu();
                    break;
                case 6:
                    teamManager.showAllPlayer();
                    break;
                case 7:
                    System.out.println("Thank you for visiting my team. See you again!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Oops...Let's try again.");
                    sc.nextLine();
                    showMenu();
            }
        } while (choice != 0);
    }
}

