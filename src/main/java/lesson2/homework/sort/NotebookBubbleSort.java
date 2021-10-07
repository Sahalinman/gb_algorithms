package lesson2.homework.sort;

import lesson2.homework.Notebook;

public class NotebookBubbleSort {

    public static void sort(Notebook[] arr) {

        boolean isChange;
        int limit = arr.length;
        do {
            isChange = false;
            limit--;
            for (int i = 0; i < limit; i++) {
                if (arr[i].getPrice() > arr[i + 1].getPrice()) {
                    Notebook temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                // Если цены равны, проверяем объем оперативной памяти, причем чем ее больше, там выше ноутбук должен стоять.
                // Как в жизни, за одну и ту же цену предпочтительнее взять больше оперативки :)
                if (arr[i].getPrice() == arr[i + 1].getPrice() && arr[i].getRam() < arr[i + 1].getRam()) {
                    Notebook temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                // Если и цена и кол-во оперативки равны, смотрим на популярность модели (тут, в контексте - приоритет)
                if (arr[i].getPrice() == arr[i + 1].getPrice() && arr[i].getRam() == arr[i + 1].getRam() && arr[i].getPriority() > arr[i + 1].getPriority()) {
                    Notebook temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                isChange = true;
            }
        } while (isChange);
    }
}
