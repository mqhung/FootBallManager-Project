package model;

import java.io.Serializable;

public class Player extends Person implements Serializable {
    private String position;
    private int salary;

    public Player(String name, String dateOfBirth, String country, String position, int salary) {
        super(name, dateOfBirth, country);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Player{" + super.toString() +
                "position='" + position + '\'' +
                ", salary=" + salary +
                '}' + "\n";
    }
}
