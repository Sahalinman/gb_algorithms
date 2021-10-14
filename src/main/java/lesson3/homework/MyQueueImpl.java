package lesson3.homework;

import lesson3.materials.queue.Queue;

public class MyQueueImpl<E> implements Queue<E> {

    protected final E[] data;
    protected int size;

    protected int tailIndex;
    protected int headIndex;

    private final int HEAD_DEFAULT = -1;
    private final int TAIL_DEFAULT = -1;

    public MyQueueImpl(int maxSize) {
        this.data = (E[])new Object[maxSize];
        headIndex = -1;
        tailIndex = -1;
        size = maxSize;
    }

    @Override
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            headIndex = 0;
        }

        tailIndex = (tailIndex + 1) % size;
        data[tailIndex] = value;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        if (headIndex == tailIndex) {
            headIndex = -1;
            tailIndex = -1;
        }
        headIndex = (headIndex + 1) % size;
        E value = data[headIndex];
        return value;
    }

    @Override
    public E peekFront() {
        return data[headIndex];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tailIndex == -1;
    }

    @Override
    public boolean isFull() {
        return ((tailIndex + 1) % size) == headIndex;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = headIndex; i <= tailIndex; i++) {
            sb.append(data[i]);
            if (i != tailIndex) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
