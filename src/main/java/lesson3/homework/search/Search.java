package lesson3.homework.search;

public class Search {

    public static int findMissNumberInSortedArray(Integer arr[]) {

        int start, base, end;
        start = 0;
        end = arr.length - 1;
        base = (start + end)/2;

        while (start < end) {
            if ((arr[base] - arr[start]) != (base - start)) {
                if ((base - start) == 1 && (arr[base] - arr[start] > 1)) {
                    return (arr[base] - 1);
                }
                end = base;

            } else if ((arr[end] - arr[base]) != (end - base)) {
                if ((end - base) == 1 && (arr[end] - arr[base] > 1)) {
                    return (arr[base] + 1);
                }
                start = base;

            } else {
                return -1;
            }

            base = (start + end)/2;
        }
        return -1;
    }
}
