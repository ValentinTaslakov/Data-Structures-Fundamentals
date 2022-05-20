package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> first;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E value) {
            this.element = value;
        }
    }

    public SinglyLinkedList() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> elementToInsert = new Node<>(element);
        if (this.first != null) {
            elementToInsert.next = this.first;
        }
        this.first = elementToInsert;
        this.size++;

    }

    @Override
    public void addLast(E element) {
        Node<E> elementToInsert = new Node<>(element);
        Node<E> current = this.first;
        if (current == null) {
            this.addFirst(element);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = elementToInsert;
            this.size++;
        }

    }

    @Override
    public E removeFirst() {
        ensureNotEmpty();

        E element = first.element;
        this.first = this.first.next;

        this.size--;
        return element;
    }


    @Override
    public E removeLast() {
        ensureNotEmpty();
        Node<E> current = this.first;
        Node<E> previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;

        this.size--;
        return current.element;
    }

    @Override
    public E getFirst() {
        ensureNotEmpty();
        return this.first.element;
    }

    @Override
    public E getLast() {
        ensureNotEmpty();
        Node<E> current = this.first;
        while (current.next != null) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = this.current.element;
                this.current = this.current.next;
                return value;
            }
        };
    }

    private void ensureNotEmpty() {
        if (this.size == 0) {
            throw new IllegalStateException("No more elements");
        }
    }
}
