package lesson1.homework;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {

    public static void main(String[] args) {

//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
//        System.out.println("====================================");
//        showArray(removeByIndex(array, 5));
//        System.out.println("====================================");
//        showArray(removeElement(array, 7));
//        System.out.println("====================================");

//        System.out.println("================ TASK 1 ====================");
//        System.out.println(Task1().size());
//        System.out.println("================ TASK 2 ====================");
//        System.out.println(Task2().size());
//        System.out.println("================ TASK 3 ====================");
//        System.out.println(Task3().size());
        System.out.println("================ TASK 5 ====================");
        System.out.println(factorial(BigInteger.valueOf(5)));
//        System.out.println("================ TASK 6 ====================");
//        System.out.println(fib(BigInteger.valueOf(10)));
//        System.out.println("================ FIBO ====================");
//        Fibo fibo = new Fibo();
//        System.out.println(fibo.calculateWithFor(100));
    }

    // Удаление элемента массива

    public static int[] removeByIndex(int[] arr, int index) {

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



    public static int[] removeElement( int [] arr, int index ){

        int[] arrDestination = new int[arr.length - 1];
        int remainingElements = arr.length - ( index + 1 );
        System.arraycopy(arr, 0, arrDestination, 0, index);
        System.arraycopy(arr, index + 1, arrDestination, index, remainingElements);

        return arrDestination;
    }

    public static void showArray(int[] array) {
        System.out.println("Elements -- "  + Arrays.toString(array));
    }

    public static List<Integer> Task1() {

        int n = 100;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                arrayList.add(i * j);
            }
        }
        return arrayList;
    }

    public static List<Integer> Task2() {

        int n = 100;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            for (int j = i; j < n; j++) {
                arrayList.add(i * j);
            }
        }
        return arrayList;
    }

    public static List<Integer> Task3() {

        int n = 100;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                arrayList.add(i * j);
                n--;
            }
        }
        return arrayList;
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return n;
        }
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
    }

    public static BigInteger fib(BigInteger n) {

        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ZERO;
        }
        if (n.equals(BigInteger.TWO)) {
            return BigInteger.ONE;
        }
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));
    }
}
