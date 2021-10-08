package lesson2.homework.sort;

import lesson2.homework.Notebook;

public class NotebookSelectionSort {

    public static void sort(Notebook[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getPrice() < arr[min].getPrice()) {
                    min = j;
                }
                if (arr[j].getPrice() == arr[min].getPrice() && arr[j].getRam() > arr[min].getRam()) {
                    min = j;
                }
                if (arr[j].getPrice() == arr[min].getPrice() && arr[j].getRam() == arr[min].getRam() && arr[j].getPriority() < arr[min].getPriority()) {
                    min = j;
                }
            }

            if (i == min) {
                continue;
            }

            Notebook temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
