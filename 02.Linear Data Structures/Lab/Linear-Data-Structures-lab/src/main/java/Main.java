import implementations.ArrayList;
import implementations.Queue;
import implementations.SinglyLinkedList;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {

        SinglyLinkedList<Integer> test = new SinglyLinkedList<>();

        test.addFirst(5);
        test.addFirst(10);
        test.addFirst(15);

        test.addLast(7);

        for (Integer integer : test) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("First element is: " + test.getFirst());
        System.out.println("Last element is: " + test.getLast());

        System.out.println(test.size());
//        try {
//
//            System.out.println( test.removeFirst());
//            System.out.println( test.removeFirst());
//            System.out.println( test.removeFirst());
//            System.out.println( test.removeFirst());
//            System.out.println( test.removeFirst());
//        }catch (IllegalStateException ex){
//            System.out.println(ex.getMessage());
//        }






    }
}
