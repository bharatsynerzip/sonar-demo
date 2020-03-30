package com.problem.solving;

import java.util.Scanner;
import java.util.Stack;

public class MyQueue<T> {

    Stack<T> inbox;
    Stack<T> outbox;

    public MyQueue() {
        inbox = new Stack<>();
        outbox = new Stack<>();
    }

    public void enqueue(T data) {

        inbox.push(data);
    }

    public T dequeue() {

        T data = null;

        if(outbox.isEmpty()) {
            while(!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }

        if(!outbox.isEmpty()) {
            data = outbox.pop();
        }

        return data;
    }

    public T peek() {
        T data = null;

        if(outbox.isEmpty()) {

            while(!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }

        if(!outbox.isEmpty()) {
            data = outbox.peek();
        }

        return data;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
