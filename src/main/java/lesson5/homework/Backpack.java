package lesson5.homework;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Backpack {

    private Stuff[] stuffs;
    private double capacity;

    private double bestPrice;
    private List<Stuff> bestStuff = null;

    public Backpack(double capacity) {
        this.capacity = capacity;
    }

    public List<Stuff> getBestStuff() {
        return this.bestStuff;
    }

    private double calcWeightSum(List<Stuff> stuffs) {
        double result = 0.0;
        for (Stuff stuff : stuffs) {
            result += stuff.getStuffWeight();
        }
        return result;
    }

    private double calcPriceSum(List<Stuff> stuffs) {
        double result = 0.0;
        for (Stuff stuff : stuffs) {
            result += stuff.getStuffCost();
        }
        return result;
    }

    private void checkList(List<Stuff> stuffs) {
        if (this.bestStuff == null) {
            if (this.calcWeightSum(stuffs) <= this.capacity) {
                this.bestStuff = stuffs;
                this.bestPrice = this.calcPriceSum(stuffs);
            }
        } else {
            if (this.calcWeightSum(stuffs) <= this.capacity && this.calcPriceSum(stuffs) > this.bestPrice) {
                this.bestStuff = stuffs;
                this.bestPrice = this.calcPriceSum(stuffs);
            }
        }
    }

    public void processing(List<Stuff> stuffs) {
        if (stuffs.size() > 0) {
            this.checkList(stuffs);
            for (int i = 0; i < stuffs.size(); i++) {
                List<Stuff> combination = new ArrayList<>(stuffs);
                combination.remove(i);
                processing(combination);
            }
        }
    }
}
