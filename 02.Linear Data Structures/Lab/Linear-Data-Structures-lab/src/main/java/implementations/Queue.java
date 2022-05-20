package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private Node<E> first;
    private int elementsCount;

    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E value){
            this.element = value;
        }
    }

    public Queue(){
        this.first = null;
        this.elementsCount = 0;
    }

    @Override
    public void offer(E element) {
        Node<E> elementToInsert = new Node<>(element);
        if (this.first == null){
            this.first = elementToInsert;
        }else {
            Node<E> current = this.first;
            while (current.next != null){
                current = current.next;
            }
            current.next = elementToInsert;
        }

        this.elementsCount++;

    }

    @Override
    public E poll() {
        ensureNotEmpty();
        E element = this.first.element;
//        if (this.elementsCount == 1){
//            this.first = null;
//        }else {
//            Node<E> next = this.first.next;
//            this.first.next = null;
//            this.first = next;
//        }


        if (this.first.next == null){
            this.first = null;
        }else{
            this.first = this.first.next;
        }

        this.elementsCount--;
        return element;
    }



    @Override
    public E peek() {
        ensureNotEmpty();
        return this.first.element;
    }

    @Override
    public int size() {
        return this.elementsCount;
    }

    @Override
    public boolean isEmpty() {
        return this.elementsCount == 0;
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
        if (elementsCount == 0){
            throw new IllegalStateException();
        }
    }
}
