import BTree.BTree;
import BTree.DrawBTree;
import DoubleChain.DoubleChain;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BTree<Integer, Double> b = new BTree<Integer, Double>(3);
        System.out.print("Tree is empty: ");
        System.out.println(b.isEmpty());

        b.insert(10, 0.0);
        b.insert(20, 0.0);
        b.insert(25, 0.0);
        b.insert(30, 0.0);
        b.insert(40, 0.0);
        b.insert(50, 0.0);
        b.insert(70, 0.0);
        b.insert(80, 0.0);
        b.insert(85, 0.0);
        b.insert(90, 0.0);
        b.insert(95, 0.0);
        b.insert(55, 0.0);
        b.insert(60, 0.0);
        b.insert(35, 0.0);
        b.insert(82, 0.0);
        b.insert(44, 0.0);

        b.replace(10, 1.0);
        b.replace(11, 1.0);
        b.delete(82);

        new DrawBTree(b);
    }
}
