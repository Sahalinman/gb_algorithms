package lesson3.materials.deque;

import lesson3.materials.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    private final int HEAD_DEFAULT = 0;
    private final int TAIL_DEFAULT = -1;

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (head == HEAD_DEFAULT)
            head = data.length;

        data[--head] = value;
        size++;

        return true;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return  null;
        }
        if (tail == TAIL_DEFAULT)
            tail = data.length - 1;

        size--;
        return data[tail--];
    }

}