package com.problem.solving;

public class DetectLinkedListLoop {

    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    public  static void main(String args[]) {

    }

    public  static boolean detectLoop(Node head) {
        // Add code here
        boolean isLoopPresent = false;
        Node nodeRunnerByTwoNode = head;

        while(nodeRunnerByTwoNode != null && head != null) {

            if(head.next != null) {
                head = head.next;
            } else {
                break;
            }

            if(nodeRunnerByTwoNode.next != null && nodeRunnerByTwoNode.next.next != null) {
                nodeRunnerByTwoNode = nodeRunnerByTwoNode.next.next;
            } else  {
                break;
            }

            if(head == nodeRunnerByTwoNode) {
                isLoopPresent = true;
                break;
            }
        }

        return isLoopPresent;
    }

}
