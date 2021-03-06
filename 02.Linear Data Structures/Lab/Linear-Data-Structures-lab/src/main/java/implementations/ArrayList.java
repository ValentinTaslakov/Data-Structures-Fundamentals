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

        E lastElement = this.get(this.elementsCount - 1);
        for (int i = this.elementsCount - 1; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        this.add(lastElement);

        return true;
    }

    @Override
    public E get(int index) {
        indexValidation(index);

        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        indexValidation(index);

        E removedElement = (E) this.elements[index];

        this.elements[index] = element;

        return removedElement;
    }

    @Override
    public E remove(int index) {
        indexValidation(index);
        E removedElement = (E) this.elements[index];

        for (int i = index; i < elementsCount; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elementsCount--;

        if (this.elements.length > this.elementsCount && this.elementsCount <= this.elements.length / 4) {
            this.elements = shrink();
        }


        return removedElement;
    }

    @Override
    public int size() {
        return this.elementsCount;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < elementsCount; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(E element) {

        return this.indexOf(element) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return this.elementsCount == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < elementsCount;
            }

            @Override
            public E next() {
                return get(this.index++);
            }
        };
    }

    private Object[] grow() {

        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    private Object[] shrink() {

        return Arrays.copyOf(this.elements, this.elements.length / 2);
    }

    private void indexValidation(int index) {
        if (index < 0 || index >= this.elementsCount) {
            throw new IndexOutOfBoundsException
                    (String.format("Index %d is out of bounds for size %d%n", index, this.elements.length));
        }
    }

    private void checkAndResizeIfNecessary() {
        if (this.elementsCount == this.elements.length) {
            this.elements = grow();
        }
    }

    public Object[] getElements() {
        return elements;
    }
}
