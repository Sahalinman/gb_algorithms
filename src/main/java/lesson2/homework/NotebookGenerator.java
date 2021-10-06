package lesson2.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotebookGenerator {

    private static final Random random = new Random();

    private static final int maxNotebookPrice = 3000;
    private static final int minNotebookPrice = 500;
    private static final int priceStep = 50;

    private static final int maxRamValue = 24;
    private static final int minRamValue = 4;
    private static final int ramStep = 4;

    public static List<Notebook> generate(int count) {

        List<Notebook> notebookList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            notebookList.add(
                    new Notebook(
                            // Генерируем имя
                            CompanyName.getCompanyNameByPriority(random.nextInt(5) + 1),
                            // Генерируем цену
                            (int) Math.round(Math.random() * ((maxNotebookPrice - minNotebookPrice) / priceStep)) * priceStep + minNotebookPrice,
                            // Генерируем кол-во оперативной памяти
                            (int) Math.round(Math.random() * ((maxRamValue - minRamValue) / ramStep)) * ramStep + minRamValue
                    )
            );
        }
        return notebookList;
    }
}
