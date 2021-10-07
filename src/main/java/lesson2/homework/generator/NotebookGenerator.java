package lesson2.homework.generator;

import lesson2.homework.Notebook;
import lesson2.homework.constants.Company;

import java.util.Random;

public class NotebookGenerator {

    private static final Random random = new Random();

    private static final int maxNotebookPrice = 3000;
    private static final int minNotebookPrice = 500;
    private static final int priceStep = 50;

    private static final int maxRamValue = 24;
    private static final int minRamValue = 4;
    private static final int ramStep = 4;

    public static Notebook[] generate(int count) {

        Notebook[] notebookList = new Notebook[count];
        for (int i = 0; i < count; i++) {
            notebookList[i] = new Notebook(
                            // Генерируем имя
                            Company.getCompanyNameByPriority(random.nextInt(5) + 1),
                            // Генерируем цену
                            (int) Math.round(Math.random() * ((maxNotebookPrice - minNotebookPrice) / priceStep)) * priceStep + minNotebookPrice,
                            // Генерируем кол-во оперативной памяти
                            (int) Math.round(Math.random() * ((maxRamValue - minRamValue) / ramStep)) * ramStep + minRamValue
            );
        }
        return notebookList;
    }
}
