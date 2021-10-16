package lesson4.homework;

import lesson3.materials.deque.Deque;
import lesson3.materials.queue.Queue;
import lesson4.materials.LinkedDeque;
import lesson4.materials.LinkedQueue;
import lesson4.materials.SimpleLinkedListImpl;

public class Main {

    public static void main(String[] args) {
//        testLinkedList();
//        testQueue();
        testLinkedDequeList();
    }

    private static void testLinkedList() {

        var linkedList = new SimpleLinkedListImpl<>();

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

//        Iterator<Integer> iterator = linkedList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        for (Integer value : linkedList) {
//            System.out.println("value: " + value);
//        }
    }

    private static void testQueue() {

        Queue<Integer> queue = new LinkedQueue<>();

        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));

        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();
    }

    public static void testLinkedDequeList() {

        Deque<Integer> deque = new LinkedDeque<>();
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
    }
}
