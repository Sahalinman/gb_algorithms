package lesson4.materials.finalMaterials;

public interface TwoSideLinkedList<E>  extends LinkedList<E> {
    void insertLast(E value);
    E getLast();
}
