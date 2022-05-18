import implementations.ArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> test = new ArrayList<>();

        test.add(1);
        test.add(3);
        test.add(5);
        test.add(7);

        test.add(2,9);


        System.out.println(Arrays.toString(test.getElements()));
        System.out.println(test.remove(1));
        System.out.println(test.size());

        System.out.println(Arrays.toString(test.getElements()));
        System.out.println(test.size());
    }
}
