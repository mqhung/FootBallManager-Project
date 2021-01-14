package manager;
import storage.ReaderWriterFile;

import model.Football;
import model.Player;
import model.PlayerComparator;

import java.util.ArrayList;
import java.util.List;

public class TeamManager {
    List<Player> team = new ArrayList<>();
    ReaderWriterFile file = new ReaderWriterFile();

    //them cau thu moi
    public void addNewPlayer(Player player) {
        team.add(player);
        file.writeFile(team);
    }

    //hien thi team
    public void showAllPlayer() {
        for (Player p : team) {
            System.out.println(p);
        }
    }
    //sua thong tin cau thu
    public void editPlayer(int index, Player player){
        team.set(index,player);
        file.writeFile(team);
    }

    //tinh tien luong cau thu
    public int getSalaryForPlayer() {
        int totalSalary = 0;
        for (int i = 0; i < team.size(); i++) {
            totalSalary += (team.get(i).getSalary());
        }
        return totalSalary;
    }

    //thanh toan tien luong
    public int paySalary(Football football) {
        return football.getMoney() - getSalaryForPlayer();
    }

    //tim kiem cau thu theo ten
    public void searchingByName(String name) {
        String result = "";
        for (Player p : team) {
            if (p.getName().equals(name)) {
                result += p.toString();
            }
        }
        System.out.println(result);
    }

    //tim kiem theo muc luong
    public void searchingBySalary(int salary) {
        String result = "";
        for (Player p : team) {
            if (p.getSalary() == salary) {
                result += p.toString();
            }
        }
        System.out.println(result);
    }

    //sap xep theo tien luong, theo ten
    public void sort(PlayerComparator playerComparator, int number) {
        for (int i = 1; i < team.size(); i++) {
            for (int j = 0; j < team.size() - i; j++) {
                switch (number) {
                    case 1:
                        if (playerComparator.compare(team.get(j), team.get(j + 1)) > 0) {
                            Player temp = team.get(j);
                            team.set(j, team.get(j + 1));
                            team.set(j + 1, temp);
                        }
                        break;
                    case 2:
                        if (playerComparator.compare(team.get(j), team.get(j + 1)) < 0) {
                            Player temp = team.get(j);
                            team.set(j, team.get(j + 1));
                            team.set(j + 1, temp);
                        }
                        break;
                }
            }
        }
    }

    //xoa cau thu
    public void removePlayerByName(String name) {
        for (Player p : team) {
            if (p.getName() == name) {
                team.remove(p);
                break;
            }
        }
    }
}
