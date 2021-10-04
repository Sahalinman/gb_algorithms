package lesson1.materials.bigO;

public class ExampleLogn {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};

        for (int i = 1; i < arr.length; i*=2) {
            System.out.println(arr[i]);
        } //O(logn)
    }
}
