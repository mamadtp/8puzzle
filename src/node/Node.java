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
public class Node {

    /**
     * @param args the command line arguments
     */
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

    public static void main(String[] args) {
        // TODO code application logic here
        long start = System.currentTimeMillis();

        Plist frontier = new Plist();

        int map[][] = new int[3][3];
        map[0][0] = 1;
        map[0][1] = 2;
        map[0][2] = 3;

        map[1][0] = 4;
        map[1][1] = 5;
        map[1][2] = 6;

        map[2][0] = 7;
        map[2][1] = 0;
        map[2][2] = 8;

        System.out.println("operation done!");

        BinaryTree explored = new BinaryTree(map);

        fnode intial_state = new fnode(map, null);

        frontier.Insert(intial_state);
        explored.Insert(intial_state);

        while (true) {
            if (frontier.count <= 0) {
                System.out.println("GG");

                break;
            }

            fnode l = frontier.del();

            if (!explored.Search(l)) {
                explored.Insert(l);
            }

            if (equal(l.value, explored.goal)) {

                long end = System.currentTimeMillis();
                end = end - start;
                fnode temp = l;
                /*while (temp != null) {
                   
                }*/

                System.out.println("The number of Node in explored:" + explored.count);
                System.out.println("Time in Seconds:" + (float) end / 1000);
                break;
            } else if (l.value[0][0] == 0) {
                fnode temp = new fnode(l.value, l.parent, l.left, l.right);

                temp.value[0][0] = temp.value[0][1];
                temp.value[0][1] = 0;
                if (!explored.Search(temp)) {
                    explored.Insert(temp);
                }
                fnode temp2 = new fnode(l.value, l.parent, l.left, l.right);

                temp2.value[0][0] = temp2.value[1][0];
                temp2.value[1][0] = 0;
                if (!explored.Search(temp2)) {
                    explored.Insert(temp2);
                }

            } else if (l.value[0][1] == 0) {
                fnode temp = new fnode(l.value, l.parent, l.left, l.right);

                temp.value[0][1] = temp.value[0][0];
                temp.value[0][0] = 0;
                if (!explored.Search(temp)) {
                    explored.Insert(temp);
                }
                fnode temp2 = new fnode(l.value, l.parent, l.left, l.right);

                temp2.value[0][1] = temp2.value[0][2];
                temp2.value[0][2] = 0;
                if (!explored.Search(temp2)) {
                    explored.Insert(temp2);
                }

                fnode temp3 = new fnode(l.value, l.parent, l.left, l.right);

                temp3.value[0][1] = temp3.value[1][1];
                temp3.value[1][1] = 0;
                if (!explored.Search(temp3)) {
                    explored.Insert(temp3);
                }
            } else if (l.value[0][2] == 0) {

                fnode temp = new fnode(l.value, l.parent, l.left, l.right);

                temp.value[0][2] = temp.value[0][1];
                temp.value[0][1] = 0;
                if (!explored.Search(temp)) {
                    explored.Insert(temp);
                }
                fnode temp2 = new fnode(l.value, l.parent, l.left, l.right);

                temp2.value[0][2] = temp2.value[1][2];
                temp2.value[1][2] = 0;
                if (!explored.Search(temp2)) {
                    explored.Insert(temp2);
                }

            } else if (l.value[1][0] == 0) {
                fnode temp = new fnode(l.value, l.parent, l.left, l.right);

                temp.value[1][0] = temp.value[0][0];
                temp.value[0][0] = 0;
                if (!explored.Search(temp)) {
                    explored.Insert(temp);
                }

                fnode temp2 = new fnode(l.value, l.parent, l.left, l.right);

                temp2.value[1][0] = temp2.value[1][1];
                temp2.value[1][1] = 0;
                if (!explored.Search(temp2)) {
                    explored.Insert(temp2);
                }
                fnode temp3 = new fnode(l.value, l.parent, l.left, l.right);

                temp3.value[1][0] = temp3.value[2][0];
                temp3.value[2][0] = 0;
                if (!explored.Search(temp3)) {
                    explored.Insert(temp3);
                }

            } else if (l.value[1][1] == 0) {
                fnode temp = new fnode(l.value, l.parent, l.left, l.right);

                temp.value[1][1] = temp.value[1][0];
                temp.value[1][0] = 0;
                if (!explored.Search(temp)) {
                    explored.Insert(temp);
                }

                fnode temp2 = new fnode(l.value, l.parent, l.left, l.right);

                temp2.value[1][1] = temp2.value[0][1];
                temp2.value[0][1] = 0;
                if (!explored.Search(temp2)) {
                    explored.Insert(temp2);
                }

                fnode temp3 = new fnode(l.value, l.parent, l.left, l.right);
                temp3.value[1][1] = temp3.value[1][2];
                temp3.value[1][2] = 0;
                if (!explored.Search(temp3)) {
                    explored.Insert(temp3);
                }
                fnode temp4 = new fnode(l.value, l.parent, l.left, l.right);

                temp4.value[1][1] = temp4.value[2][1];
                temp4.value[2][1] = 0;
                if (!explored.Search(temp4)) {
                    explored.Insert(temp4);
                }

            } else if (l.value[1][2] == 0) {
                fnode temp = new fnode(l.value, l.parent, l.left, l.right);

                temp.value[1][2] = temp.value[1][1];
                temp.value[1][1] = 0;
                if (!explored.Search(temp)) {
                    explored.Insert(temp);
                }

                fnode temp2 = new fnode(l.value, l.parent, l.left, l.right);

                temp2.value[1][2] = temp2.value[0][2];
                temp2.value[0][2] = 0;
                if (!explored.Search(temp2)) {
                    explored.Insert(temp2);
                }
                fnode temp3 = new fnode(l.value, l.parent, l.left, l.right);

                temp3.value[1][2] = temp3.value[2][2];
                temp3.value[2][2] = 0;
                if (!explored.Search(temp3)) {
                    explored.Insert(temp3);
                }

            } else if (l.value[2][0] == 0) {
                fnode temp = new fnode(l.value, l.parent, l.left, l.right);

                temp.value[2][0] = temp.value[1][0];
                temp.value[1][0] = 0;
                if (!explored.Search(temp)) {
                    explored.Insert(temp);
                }

                fnode temp2 = new fnode(l.value, l.parent, l.left, l.right);

                temp2.value[2][0] = temp2.value[2][1];
                temp2.value[2][1] = 0;
                if (!explored.Search(temp2)) {
                    explored.Insert(temp2);
                }

            } else if (l.value[2][1] == 0) {

                fnode temp = new fnode(l.value, l.parent, l.left, l.right);

                temp.value[2][1] = temp.value[2][0];
                temp.value[2][0] = 0;
                if (!explored.Search(temp)) {
                    explored.Insert(temp);
                }

                fnode temp2 = new fnode(l.value, l.parent, l.left, l.right);

                temp2.value[2][1] = temp2.value[1][1];
                temp2.value[1][1] = 0;
                if (!explored.Search(temp2)) {
                    explored.Insert(temp2);
                }

                fnode temp3 = new fnode(l.value, l.parent, l.left, l.right);

                temp3.value[2][1] = temp3.value[2][2];
                temp3.value[2][2] = 0;

                System.out.println(explored.count);

                if (!explored.Search(temp3)) {
                    explored.Insert(temp3);
                }

            } else if (l.value[2][2] == 0) {

                fnode temp = new fnode(l.value, l.parent, l.left, l.right);

                temp.value[2][2] = temp.value[1][2];
                temp.value[1][2] = 0;
                if (!explored.Search(temp)) {
                    explored.Insert(temp);
                }

                fnode temp2 = new fnode(l.value, l.parent, l.left, l.right);

                temp2.value[2][2] = temp2.value[2][1];
                temp2.value[2][1] = 0;
                if (!explored.Search(temp2)) {
                    explored.Insert(temp2);
                }

            }
        }
    }
}
