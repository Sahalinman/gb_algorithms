package lesson1.homework;

public class Example {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        showArray(removeElement(2, array));
    }

    // Удаление элемента массива с известным индексом без сдвига

    public static int[] removeElement(int index, int[] arr) {

        int length = arr.length - 1;
        int[] res = new int[length];
        for(int i = 0; i < index; i++) {
            res[i] = arr[i];
        }
        for(int i = index; i < length; i++) {
            res[i] = arr[i + 1];
        }
        return res;
    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
