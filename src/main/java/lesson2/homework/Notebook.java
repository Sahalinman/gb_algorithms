package lesson2.homework;

import lesson2.homework.constants.Company;

public class Notebook {

    private int price;
    private int ram;
    private String companyName;

    public Notebook(String companyName, int price, int ram) {
        this.companyName = companyName;
        this.price = price;
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getPriority() {
        return Company.getPriorityByCompanyName(this.companyName);
    }

    @Override
    public String toString() {
        return this.companyName + " (Priority " + Company.getPriorityByCompanyName(this.companyName) + ") : "
                + this.price + " : " + ram;
    }
}
