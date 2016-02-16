package indeed;

import java.util.Scanner;

public class Solution4 {


    public static void main(String[] args) throws Exception {

        // read input from STDIN
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Deque deque = new Deque();

        int i =0;
        while (i<n) {
            String command = in.nextLine();
            String[] tokens = command.split(" ");

            int tokenCount = tokens.length;
            if (tokenCount == 1) {
                deque.removeFront();


            } else if (tokenCount == 2) {
                int a = Integer.parseInt(tokens[1]);
                deque.insertFront(a);


            } else if (tokenCount == 3) {
                int x = Integer.parseInt(tokens[1]);
                int d = Integer.parseInt(tokens[2]);
                deque.increment(x, d);

            } else {
            }

            i++;
        }

        deque.printOutput();
}


    private static class Deque {

        DequeElement start;
        DequeElement end;
        int count;
        StringBuilder output;

        Deque() {
            count = 0;
            start = new DequeElement(0);
            end = new DequeElement(0);
            output = new StringBuilder();
        }

        void insertFront(int a) {
            DequeElement dequeElement = new DequeElement(a);

            if (start.nextElement != null) {
                DequeElement firstDequeElement = start.nextElement;

                dequeElement.nextElement = firstDequeElement;
                firstDequeElement.previousElement = dequeElement;
                dequeElement.previousElement = null;

                start.nextElement = dequeElement;
            } else {
                start.nextElement = dequeElement;
                end.previousElement = dequeElement;
            }

            this.count++;
            printHead();
        }

        private void printHead() {
            if (count != 0) {
                output.append(start.nextElement.data);
                output.append("\n");
            } else {
                output.append("EMPTY\n");
            }

        }

        private void printList() {

            DequeElement dequeElement = start.nextElement;

            if (dequeElement != null) {
                do {
                    System.out.print(dequeElement.data + " ");
                    dequeElement = dequeElement.nextElement;
                } while (dequeElement != null);
            }

            System.out.println();
        }

        void removeFront() {
            if (start.nextElement != null) {
            } else {
                output.append("EMPTY\n");
            }

            switch (count) {
                case 1:
                    output.append("EMPTY\n");

                    start.nextElement = null;
                    end.previousElement = null;
                    count = 0;
                    break;
                default:
                    start.nextElement = start.nextElement.nextElement;
                    int topElement = start.nextElement.data;
                    count = count - 1;

                    //noinspection SuspiciousNameCombination
                    output.append(topElement);
                    output.append("\n");
                    break;
            }


        }

        // Add values d to the bottom x elements
        void increment(int x, int d) {

            DequeElement dequeElement = end.previousElement;
            x = Math.min(x, count);

            int i = 0;
            while (true) {
                if (!(i < x)) break;
                dequeElement.data = dequeElement.data + d;
                dequeElement = dequeElement.previousElement;
                i++;
            }

            printHead();

        }

        public void printOutput() {
            System.out.println(output);
        }
    }

    private static class DequeElement {
        DequeElement previousElement;
        DequeElement nextElement;
        int data;

        DequeElement(int key) {
            data = key;
            previousElement = null;
            nextElement = null;
        }
    }

}
