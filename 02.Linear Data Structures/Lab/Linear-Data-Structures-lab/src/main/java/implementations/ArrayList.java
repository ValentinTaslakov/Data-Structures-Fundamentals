package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 4;
    private Object[] elements;
    private int elementsCount;

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.elementsCount = 0;
    }

    @Override
    public boolean add(E element) {

        checkAndResizeIfNecessary();

        this.elements[this.elementsCount] = element;
        this.elementsCount++;
        return true;
    }


    @Override
    public boolean add(int index, E element) {
        indexValidation(index);
        checkAndResizeIfNecessary();

        E lastElement = this.get(elementsCount - 1);
        for (int i = elementsCount - 1; i < index; i--) {

        }

        return true;
    }

    @Override
    public E get(int index) {
        indexValidation(index);

        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private Object[] grow() {

        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    private void indexValidation(int index) {
        if (index < 0 || index >= this.elements.length) {
            throw new IndexOutOfBoundsException
                    (String.format("Index %d is out of bounds for size %d%n", index, this.elements.length));
        }
    }

    private void checkAndResizeIfNecessary() {
        if (this.elementsCount == this.elements.length) {
            this.elements = grow();
        }
    }
}
