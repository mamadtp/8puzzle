/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

import static java.lang.Math.abs;

/**
 *
 * @author mamadtp
 */
public class fnode {

    public int value[][] = new int[3][3];

    public fnode parent;
    public fnode left;
    public fnode right;

    int gn = 0;

    public fnode(int v[][], fnode p) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value[i][j] = v[i][j];
            }
        }

        parent = p;
        if (parent != null) {
            gn = parent.gn + 1;
        }
    }

    public fnode(int v[][], fnode p, fnode l, fnode r) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value[i][j] = v[i][j];
            }
        }
        parent = p;
        right = r;
        left = l;
        if (parent != null) {
            gn = parent.gn + 1;
        }
    }

    public fnode(int v[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value[i][j] = v[i][j];
            }
        }
        gn = parent.gn + 1;
    }

    public fnode() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value[i][j] = -1;
            }
        }
        parent = null;
        left = null;
        right = null;

    }

    public int hn(int g[][]) {
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (value[x][y] == g[i][j]) {
                            temp += abs(i - x) + abs(j - y);
                        }
                    }
                }
            }
        }
        return temp;
    }

    public int fn(int g[][]) {
        return gn + hn(g);
    }
}
