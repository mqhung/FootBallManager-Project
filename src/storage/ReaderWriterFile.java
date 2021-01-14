package storage;

import model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderWriterFile {

    public static final String FILE = "PlayerList.txt";

    public void writeFile(List<Player> list) {
        File file = new File(FILE);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Player p : list) {
                String line = p.getName() + " " + p.getDateOfBirth() + " " + p.getCountry()
                        + " " + p.getPosition() + " " + p.getSalary() + "\n";
                bufferedWriter.write(line);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  List<Player> readFile() {
        List<Player> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                Player player = splitString(line);
                list.add(player);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Player splitString(String string) {
        String[] array = string.split(" ");
        int salary = Integer.parseInt(array[4]);
        Player player = new Player(array[0], array[1], array[2], array[3],salary);
        return player;
    }

}
