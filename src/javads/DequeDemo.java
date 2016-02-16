package javads;/* Authored by Kushagra on 2/15/2016. */

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedList<>();

        deque.add(10);
        deque.add(12);
        deque.add(3);
        deque.add(41);

        System.out.println(deque.toString());

        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        deque.removeFirst();
        deque.removeLast();

        System.out.println(deque.toString());

    }

}
