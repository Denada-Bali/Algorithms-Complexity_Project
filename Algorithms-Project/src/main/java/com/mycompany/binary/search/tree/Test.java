package com.mycompany.binary.search.tree;

import com.mycompany.binary.search.tree.Trees.Node;
import java.util.Scanner;

/**
 *
 * @author Danja
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Trees myTree = new Trees();
        Node root = null;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter size of nodes: ");
        int size = input.nextInt();

        System.out.println("Input a set of integers (one by one): ");
        int value;

        for (int i = 0; i < size; i++) {
            value = input.nextInt();
            root = myTree.insert(root, value);
        }

        System.out.println("Display all Values Level by Level in Spiral Order:");

        myTree.spiralOrder(root);

    }
}
