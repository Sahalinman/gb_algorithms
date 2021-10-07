package lesson2.homework.sort;

import lesson2.homework.Notebook;

public class NotebookInsertionSort {

    public static void sort(Notebook[] arr){

        for (int i = 1; i < arr.length; i++) {
            Notebook value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getPrice() > value.getPrice()) {
                arr[j + 1] = arr[j];
                j--;
            }
            while (j >= 0 && arr[j].getPrice() == value.getPrice() && arr[j].getRam() < value.getRam()) {
                arr[j + 1] = arr[j];
                j--;
            }
            while (j >= 0 && arr[j].getPrice() == value.getPrice() && arr[j].getRam() == value.getRam() && arr[j].getPriority() > value.getPriority()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
    }
}
