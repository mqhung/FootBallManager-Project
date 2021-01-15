package view;

import manager.TeamManager;
import model.Football;
import model.Player;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static view.SubMain.sortMenu;

public class Main {
    public static TeamManager teamManager = new TeamManager();
    public static Scanner sc = new Scanner(System.in);
    public static SubMain subMain = new SubMain();
    public static Football football = Football.getFootball(50000);

    public static void main(String[] args) {
        SubMain.setTeamManager(teamManager);
        System.out.println("Welcome back to my football team : LIVERPOOL");
        getTime();
        showMenu();
    }
    public static void getTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm, dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Today is: " + formatter.format(now));
    }

    public static void showMenu() {
        int choice = -1;
        do {
            System.out.println("Here is the menu, your choice???");
            System.out.println("1.Add new player.");
            System.out.println("2.Edit player on team.");
            System.out.println("3.Remove player on team.");
            System.out.println("4.Find player.");
            System.out.println("5.Sort player.");
            System.out.println("6.Show my team.");
            System.out.println("7.Pay salary for team.");
            System.out.println("8.Exit");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Not an option.");
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter number of player you wanna add:");
                    try{
                        int numberOfPlayer = Integer.parseInt(sc.nextLine());
                        for (int i = 0; i < numberOfPlayer; i++) {
                            Player newPlayer = subMain.addNewPlayer();
                            teamManager.addNewPlayer(newPlayer);
                        }
                    }catch (Exception e){
                        System.out.println("Oops incorrect!! Please enter again");
                    }
                    break;
                case 2:
                    System.out.println("Enter index of player you wanna edit:");
                    try{
                        int index = Integer.parseInt(sc.nextLine());
                        Player editPlayer = subMain.editPlayer();
                        teamManager.editPlayer(index, editPlayer);
                    } catch (Exception e){
                        System.out.println("Oops incorrect!! Please enter again");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter player's name you wanna remove:");
                        String name = sc.nextLine();
                        teamManager.removePlayerByName(name);
                        teamManager.showAllPlayer();
                    } catch (Exception e){
                        System.out.println("Oops incorrect!! Please enter again");
                    }
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
                    int money = teamManager.paySalary(football);
                    System.out.println(money);
                    break;
                case 8:
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

