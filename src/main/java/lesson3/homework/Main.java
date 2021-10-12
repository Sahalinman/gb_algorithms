package lesson3.homework;

import lesson3.homework.search.Search;
import lesson3.materials.deque.Deque;
import lesson3.materials.queue.Queue;

public class Main {

    public static void main(String[] args) {

        // Задание 1
        /** Вывод
         * Пропущено число : 11
         */
         Task1();

        // Задание 2
        /** Вывод
         * add element to right side : true
         * add element to left side : true
         * add element to right side : true
         * add element to left side : true
         * add element to right side : true
         * add element to left side : true
         * add element to left side : true
         * [7, 6, 5, 4, 3, 2, 1]
         * remove from left side : 7
         * [6, 5, 4, 3, 2, 1]
         * remove from right side : 1
         * [6, 5, 4, 3, 2]
         */
         Task2();

        // Задание 3
        /** Вывод
         * add element: true == > [34]
         * add element: true == > [34, 12]
         * add element: true == > [34, 12, 20]
         * add element: true == > [34, 12, 20, 16]
         * add element: true == > [34, 12, 20, 16, 14]
         * Очередь полная? : true
         * remove value from head : == > [12, 20, 16, 14]
         * remove value from head : == > [20, 16, 14]
         * remove value from head : == > [16, 14]
         * remove value from head : == > [14]
         * remove value from head : == > []
         * Очередь пустая? : true
         */
         Task3();
    }

    public static void Task1() {

        // С пропущенными значениями
        Integer[] array1 = new Integer[]{1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        Integer[] array2 = new Integer[]{1, 2, 4, 5, 6};
        // Без пропущенных значений
        Integer[] array3 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] array4 = new Integer[]{};

        int x = Search.findMissNumberInSortedArray(array1);
        if (x > 0) {
            System.out.println("Пропущено число : " + x);
        } else {
            System.out.println("В отсортированном массиве нет пропущенных чисел");
        }
    }

    public static void Task2() {

        Deque<Integer> deque = new MyDequeImpl<>(7);

        System.out.println("add element to right side : " + deque.insertRight(3));
        System.out.println("add element to left side : " + deque.insertLeft(4));
        System.out.println("add element to right side : " + deque.insertRight(2));
        System.out.println("add element to left side : " + deque.insertLeft(5));
        System.out.println("add element to right side : " + deque.insertRight(1));
        System.out.println("add element to left side : " + deque.insertLeft(6));
        System.out.println("add element to left side : " + deque.insertLeft(7));

        deque.display(); // Результат : [7, 6, 5, 4, 3, 2, 1]

        System.out.println("remove from left side : " + deque.removeLeft()); // Удаляем слева значение 7

        deque.display(); // Результат : [6, 5, 4, 3, 2, 1]

        System.out.println("remove from right side : " + deque.removeRight()); // Удаляем справа значение 1

        deque.display(); // Результат [6, 5, 4, 3, 2]
    }

    public static void Task3() {

        Queue<Integer> queue = new MyQueueImpl<>(5);
        System.out.print("add element: " + queue.insert(34) + " == > ");
        queue.display();
        System.out.print("add element: " + queue.insert(12) + " == > ");
        queue.display();
        System.out.print("add element: " + queue.insert(20) + " == > ");
        queue.display();
        System.out.print("add element: " + queue.insert(16) + " == > ");
        queue.display();
        System.out.print("add element: " + queue.insert(14) + " == > ");
        queue.display();

        System.out.println("Очередь полная? : " + queue.isFull());

        queue.remove();
        System.out.print("remove value from head : == > "); queue.display();
        queue.remove();
        System.out.print("remove value from head : == > "); queue.display();
        queue.remove();
        System.out.print("remove value from head : == > "); queue.display();
        queue.remove();
        System.out.print("remove value from head : == > "); queue.display();
        queue.remove();
        System.out.print("remove value from head : == > "); queue.display();

        System.out.println("Очередь пустая? : " + queue.isEmpty());

    }
}
