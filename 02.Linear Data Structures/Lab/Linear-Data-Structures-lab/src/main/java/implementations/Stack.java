package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
//    Стека има две полета, едното е последно добавения Node
//    а другото е броя на елементите които сме добавили
    private Node<E> top;
    private int size;

//    Правим Node клас който държи в себе си стойност от
//    тип който ни е нужен, и указател за следващия Node
//    Конструктора приема само елемента който ще пазим в Node
    private static class Node<E>{
        private E value;
        private Node<E> next;

        Node(E element){
            this.value = element;
        }
    }
// конструктора не приема стойности, инициализираме
//    празен стек със нула елементи и топ елемент
//    равен на null
    public Stack(){
        this.top = null;
        this.size = 0;
    }

//    Първо трябва да добавим елемент в стека

    @Override
    public void push(E element) {

//    Инициализираме Node който приема стойноста на подадения елемент
        Node<E> toInsert = new Node<>(element);

//    За този нов Node трябва да добавим указател към предишния елемент(последния добавен преди този)
//    следващия Node е топ елемента
        toInsert.next = this.top;

//    трябва да променим и елемента който е най-отгоре в стека
//    този елемент е последно добавения
        this.top = toInsert;


//    актуализираме броя на елементите в стека
        this.size++;
    }

//    Следва премахването на елемент.
//    премахва се елемента който е най-отгоре или последния добавен.
    @Override
    public E pop() {
//        правим метод който хвърля грешка ако стека е празен
        ensureNotEmpty();

//        създаваме Node който взима стойността на последния добавен
        Node<E> tmp = this.top;
//        за най-горния елемент следващия
        this.top = tmp.next;
//        намаляваме броя на елементите в стека
        this.size--;
//        връщаме стойността
        return tmp.value;
    }


//   тук взимаме стойността на последно добавения елемент без да го премахваме
    @Override
    public E peek() {
        ensureNotEmpty();

        return this.top.value;
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
            private Node<E> current = top;
            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E value = this.current.value;
                this.current = this.current.next;

                return value;
            }
        };
    }

    private void ensureNotEmpty() {
        if (this.isEmpty()){
            throw new IllegalStateException();
        }
    }
}
