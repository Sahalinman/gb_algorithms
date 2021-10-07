package lesson2.homework;

import lesson2.homework.generator.NotebookGenerator;
import lesson2.homework.sort.NotebookBubbleSort;
import lesson2.homework.sort.NotebookInsertionSort;
import lesson2.homework.sort.NotebookSelectionSort;

public class Main {

    private static Long time;
    private static final Boolean debug = false;
    private static final int notebookCount = 5000;

    public static void main(String[] args) {

        if (!debug) {

            startTime();
            NotebookBubbleSort.sort(NotebookGenerator.generate(notebookCount));
            System.out.println("Время выполнения Пузырьковой сортировки, в ms : " + endTime());

            startTime();
            NotebookSelectionSort.sort(NotebookGenerator.generate(notebookCount));
            System.out.println("Время выполнения Сортировки выбором, в ms : " + endTime());

            startTime();
            NotebookInsertionSort.sort(NotebookGenerator.generate(notebookCount));
            System.out.println("Время выполнения Сортировки вставками, в ms : " + endTime());

        } else {

            Notebook[] notebooks = NotebookGenerator.generate(notebookCount);

            startTime();

//            NotebookSelectionSort.sort(notebooks); // Сортировка выбором
//            NotebookBubbleSort.sort(notebooks); // Пузырьковая сортировка
//            NotebookInsertionSort.sort(notebooks); // Сортировка вставками

            long x = endTime();
            System.out.println("============== Результат сортировки =====================");
            for (Notebook n : notebooks) {
                System.out.println(n.toString());
            }
            System.out.println("============== Время =====================");
            System.out.print("Время выполнения, в ms : " + x);
        }
    }

    public static void startTime() {
        time = System.currentTimeMillis();
    }

    public static Long endTime() {
        return System.currentTimeMillis() - time;
    }
}
