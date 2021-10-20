package lesson5.homework;

import lombok.Data;

@Data
public class Stuff {

    private String stuffName;
    private double stuffWeight;
    private int stuffCost;

    public Stuff(String stuffName, double stuffWeight, int stuffCost) {
        this.stuffName = stuffName;
        this.stuffWeight = stuffWeight;
        this.stuffCost = stuffCost;
    }

    @Override
    public String toString() {
        return this.stuffName + " {" +
                "ВЕС = " + stuffWeight +
                ", ЦЕНА = " + stuffCost +
                "}";
    }
}
