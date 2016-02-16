package indeed;

import java.util.Scanner;

public class Solution4 {


    public static void main(String[] args) throws Exception {

        // read input from STDIN
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        SuperStack S = new SuperStack();

        for (int i =0; i<n; i++) {
            String command = in.nextLine();
            String[] tokens = command.split(" ");

            int tokenCount = tokens.length;
            switch (tokenCount) {

                case 1:
                    S.pop();

                    break;
                case 2:
                    int a = Integer.parseInt(tokens[1]);
                    S.push(a);

                    break;
                case 3:
                    int x = Integer.parseInt(tokens[1]);
                    int d = Integer.parseInt(tokens[2]);
                    S.inc(x, d);

                    break;
                default:
                    break;
            }

        }

        S.printResult();
}


    private static class SuperStack {

        Node head;
        Node tail;
        int size;
        StringBuilder result;

        SuperStack() {
            size = 0;
            head = new Node(0);
            tail = new Node(0);
            result = new StringBuilder();
        }

        void push(int a) {
            Node node = new Node(a);

            if (head.next == null) {
                head.next = node;
                tail.prev = node;
            } else {
                Node firstNode = head.next;

                node.next = firstNode;
                firstNode.prev = node;
                node.prev = null;

                head.next = node;
            }

            this.size++;
            printHead();
        }

        private void printHead() {
            if (size == 0) {
                result.append("EMPTY\n");
            }
            else {
                result.append(head.next.key);
                result.append("\n");
            }

        }

        private void printList() {

            Node node = head.next;

            while (node != null) {
                System.out.print(node.key + " ");
                node = node.next;
            }

            System.out.println();
        }

        void pop() {
            if (head.next == null) {
                result.append("EMPTY\n");
            }

            if (size == 1) {
                result.append("EMPTY\n");

                head.next = null;
                tail.prev = null;
                size = 0;
            }
            else {
                head.next = head.next.next;
                int topElement = head.next.key;
                size = size - 1;

                //noinspection SuspiciousNameCombination
                result.append(topElement);
                result.append("\n");
            }


        }

        // Add values d to the bottom x elements
        void inc(int x, int d) {

            Node node = tail.prev;
            x = Math.min(x, size);

            int i = 0;
            while (i < x) {
                node.key = node.key + d;
                node = node.prev;
                i++;
            }

            printHead();

        }

        public void printResult() {
            System.out.println(result);
        }
    }

    private static class Node {
        Node prev;
        Node next;
        int key;

        Node(int _key) {
            key = _key;
            prev = null;
            next = null;
        }
    }

}
