package model;

public class PlayerSalaryCompare implements PlayerComparator{
    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
        return firstPlayer.getSalary() - secondPlayer.getSalary();
    }
}
