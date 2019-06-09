/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

/**
 *
 * @author mamadtp
 */
public class BinaryTree {

    fnode root;
    int count = 0;

    int goal[][] = new int[3][3];
    int start[][] = new int[3][3];

    public BinaryTree() {

        int g[][] = new int[3][3];
        g[0][0] = 1;
        g[0][1] = 2;
        g[0][2] = 3;
        g[1][0] = 4;
        g[1][1] = 5;
        g[1][2] = 6;
        g[2][0] = 7;
        g[2][1] = 8;
        g[2][2] = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                goal[i][j] = g[i][j];
            }
        }

        root = new fnode();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                root.value[i][j] = -1;
            }
        }

        root.left = null;
        root.right = null;
    }

    public BinaryTree(int s[][]) {

        int g[][] = new int[3][3];
        g[0][0] = 1;
        g[0][1] = 2;
        g[0][2] = 3;
        g[1][0] = 4;
        g[1][1] = 5;
        g[1][2] = 6;
        g[2][0] = 7;
        g[2][1] = 8;
        g[2][2] = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                goal[i][j] = g[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                start[i][j] = s[i][j];
            }
        }

        root = new fnode();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                root.value[i][j] = -1;
            }
        }

        root.left = null;
        root.right = null;
    }

    public void Insert(fnode newNode) {
        count++;
        if (root.value[0][0] == -1) {
            root = newNode;
            return;
        }
        fnode temp = root;
        fnode parent = null;
        while (true) {
            parent = temp;
            if (newNode.fn(start, goal) <= temp.fn(start, goal)) {
                temp = temp.left;
                if (temp == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                temp = temp.right;
                if (temp == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    boolean Search(fnode node) {
        fnode temp = root;
        while (temp != null) {

            if (equal(temp.value, node.value)) {
                return true;
            } else if (temp.fn(start, goal) <= node.fn(start, goal)) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    public fnode del() {

        count--;

        fnode temp = root;
        fnode node;

        if (root.left == null && root.right == null) {
            node = root;
            root = null;
            return node;
        }
        while (true) {
            if (temp.left != null) {
                temp = temp.left;
            } else if (temp.right != null) {
                node = temp;
                temp = temp.right;
                return node;
            } else {
                node = temp;
                temp.parent.left = null;
                return node;
            }
        }
    }

    public static boolean equal(int one[][], int two[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (one[i][j] != two[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
