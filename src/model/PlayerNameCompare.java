package model;

public class PlayerNameCompare implements PlayerComparator {
    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
        return firstPlayer.getName().compareTo(secondPlayer.getName());
    }
}
