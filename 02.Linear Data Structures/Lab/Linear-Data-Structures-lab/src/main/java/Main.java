import implementations.ArrayList;
import implementations.Queue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {

        Queue<Integer> test = new Queue<>();

        test.offer(5);
        test.offer(10);
//        test.offer(15);
//        test.offer(20);

        System.out.println();

        test.poll();
        test.poll();


    }
}
