package lesson1.materials.bigO;

public class Fibo {

    public long calculateWithFor(int n) {

        long first = 0;
        long second = 1;
        long result = n;

        for (int i = 1; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
