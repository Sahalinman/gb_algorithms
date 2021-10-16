package lesson4.materials;

public class FullDirectionLinkedListImpl<E> extends TwoSideLinkedListImpl<E> implements FullDirectionLinkedList<E> {

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = this.last;
        if (first == last) {
            first = null;
        }
        last = last.prev;

        if (removedNode.prev != null) {
            removedNode.prev.next = null;
            removedNode.prev = null;
        }

        size--;
        return removedNode.item;
    }

    @Override
    public E removeFirst() {
        E result = super.removeFirst();
        if (first != null) {
            first.prev = null;
        }
        return result;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (first.next != null) {
            first.next.prev = first;
        }
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null, last);
        insertLastNode(newNode);
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == first) {
            removeFirst();
            return true;
        } else if (current == last) {
            last = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
            current.next.prev = previous;
        }

        current.next = null;
        current.prev = null;
        size--;
        return true;
    }
}
