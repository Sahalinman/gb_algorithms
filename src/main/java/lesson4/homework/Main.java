package lesson4.homework;

import lesson4.materials.DequeLinkedListImpl;
import lesson4.materials.SimpleLinkedListImpl;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        testLinkedList();
        testLinkedDequeList();
    }

    /**
     * Реализация только того, что необходимо по заданию, без метода remove
     */
    private static void testLinkedList() {

        var linkedList = new SimpleLinkedListImpl<Integer>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        linkedList.removeFirst();
        linkedList.remove(4);

        linkedList.display();

        // Вывод через iterator
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Вывод через iterator : " + iterator.next());
        }

        // Вывод через for
        for (Integer value : linkedList) {
            System.out.println("Вывод через for : " + value);
        }
    }

    public static void testLinkedDequeList() {

        var deque = new DequeLinkedListImpl<>();
//        Deque<Integer> deque = new MyDequeImpl<>(5);

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

        System.out.println("add element to right side : " + deque.insertRight(555));
        System.out.println("add element to left side : " + deque.insertLeft(666));

        // Результат [666 -> 6 -> 5 -> 4 -> 3 -> 2 -> 555]

        deque.display();
    }
}
