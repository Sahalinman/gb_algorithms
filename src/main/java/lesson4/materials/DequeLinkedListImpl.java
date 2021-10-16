package lesson4.materials;

public class DequeLinkedListImpl<E> extends TwoSideLinkedListImpl<E> implements MyDeque<E> {

    @Override
    public boolean insertLeft(E value) {
        super.insertFirst(value);
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        Node<E> newNode = new Node<>(value, null, last);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        E value = super.removeFirst();
        size--;
        return value;
    }

    @Override
    public E removeRight() {
        E value = getLast();
        if (super.remove(getLast())) {
            return value;
        }
        size--;
        return value;
    }
}
