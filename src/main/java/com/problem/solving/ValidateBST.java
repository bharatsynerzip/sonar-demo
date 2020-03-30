package com.problem.solving;

public class ValidateBST {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {

        if(root == null) {
            return true;
        }

        boolean isBST = true;
        if(root.left != null && root.left.data > root.data) {
            isBST = false;
        }

        if(root.right != null && root.right.data < root.data) {
            isBST = false;
        }

        if(isBST) {
            checkBST(root.left);
            checkBST(root.right);
        }

        return isBST;
    }
}
