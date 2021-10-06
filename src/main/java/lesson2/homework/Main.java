package lesson2.homework;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Notebook> notebooks = NotebookGenerator.generate(30);
        for (Notebook n : notebooks) {
            System.out.println(n.toString());
        }
    }

}
