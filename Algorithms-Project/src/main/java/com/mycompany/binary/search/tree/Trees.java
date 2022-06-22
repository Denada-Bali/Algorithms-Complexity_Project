package com.mycompany.binary.search.tree;

import java.util.Stack;

/**
 *
 * @author Danja
 */
public class Trees {

    int key;                                            // key variable will used to enter numbers. 
    Node left;                                          // left and right node.
    Node right;

    static class Node {                                 // Node declaration 

        int key;                                        // key variable will used to enter numbers. 
        Node left;                                      // left and right node.
        Node right;

    };

    static Node createNewNode(int item) {                // Is a function to create a new Binary Search Tree Node 

        Node tree = new Node();
        tree.key = item;
        tree.left = tree.right = null;
        return tree;

    }

//    static Node insert(Node node, int key) {             //this function insert a new Node with given key in Binary Search Tree
//
//        if (node == null) {
//            return createNewNode(key);                   // If the tree is empty, return a new Node 
//        }
//
//        if (key < node.key) {                            // if key is smaller, should be inserted to left
//
//            node.left = insert(node.left, key);
//        } else {                                        //if key is greater, should be inserted to right
//            node.right = insert(node.right, key);
//        }
//
//        return node;                                    // This function returns the node pointer unchanged.
//    }

      public Node insert(Node node, int value) {
        if (node == null) {
            return createNewNode(value);
        } else {
            if (node.left == null) {
                node.left = insert(node.left, value);
            } else {
                node.right = insert(node.right, value);
            }
        }
        return node;
    }
    
    /**
     * 1
     *            / \
     *           / \
     * 2 3
     *         /\ / \ / \ / \ 4 5 6 7
     *
     * [ 1, 3, 2, 4, 5, 6, 7 ]
     */
    static void spiralOrder(Node root) {

        if (root == null) {                                    // Checks if  tree is empty
            return;
        }

        Stack<Node> stack = new Stack<>();                     // here I have create an empty stack 
        stack.push(root);                                      // and I have push root to it

        boolean direction = false;
        while (!stack.isEmpty()) {                             // if stack is not null then 

            Stack<Node> MyStack = new Stack<>();               // I create an empty stack called MyStack

            while (!stack.isEmpty()) {                         // if stack is not null
                Node node = stack.pop();                       // the condition pop a node from stack and push it to MyStack   

                System.out.print(node.key + " ");

                if (!direction) {                               //depending one direction

                    if (node.left != null) {
                        MyStack.push(node.left);
                    }

                    if (node.right != null) {
                        MyStack.push(node.right);
                    }

                } else {
                    if (node.right != null) {
                        MyStack.push(node.right);
                    }

                    if (node.left != null) {
                        MyStack.push(node.left);
                    }
                }
            }
            direction = !direction;                            // Change direction to change the direction of traversal
            stack = MyStack;                                    // then I set stack = MyStack
        }
    }
}
