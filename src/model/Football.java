package model;

public class Football {
    private int money;

    private Football(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private static Football football;

    public static Football getFootball(int money) {
        if (football == null) synchronized (Football.class) {
            if (football == null) football = new Football(money);
        }
        return football;
    }
}
