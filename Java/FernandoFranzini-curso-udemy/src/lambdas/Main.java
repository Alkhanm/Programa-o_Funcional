package lambdas;

import java.util.Arrays;

public class Main {
    public static void loop(){
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        //ponteiro funcional (Runnable é uma interface funcional)
        Runnable r1 = Main::loop;
        Runnable r2 = Main::loop;

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
