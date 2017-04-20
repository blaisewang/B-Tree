import BTree.BTree;
import BTree.DrawBTree;

public class Main {

    public static void main(String[] args) {
        BTree<Integer, Double> bTree = new BTree<Integer, Double>(3);
        System.out.print("Tree is empty: ");
        System.out.println(bTree.isEmpty());

        // test function insert
        bTree.insert(10, 0.0);
        bTree.insert(20, 0.0);
        bTree.insert(25, 0.0);
        bTree.insert(30, 0.0);
        bTree.insert(40, 0.0);
        bTree.insert(50, 0.0);
        bTree.insert(70, 0.0);
        bTree.insert(80, 0.0);
        bTree.insert(85, 0.0);
        bTree.insert(90, 0.0);
        bTree.insert(95, 0.0);
        bTree.insert(55, 0.0);
        bTree.insert(60, 0.0);
        bTree.insert(35, 0.0);
        bTree.insert(82, 0.0);
        bTree.insert(44, 0.0);

        // test function replace
        bTree.replace(10, 1.0);
        bTree.replace(11, 1.0);

        // test function delete
        bTree.delete(82);

        // construct new b-tree
        new DrawBTree(bTree);

        System.out.print("Pair for key = 10 is: (");
        System.out.println(bTree.get(10) + ")");
        System.out.print("Tree size is: ");
        System.out.println(bTree.getTreeSize());
        System.out.print("Height of tree: ");
        System.out.println(bTree.getHeight());

        System.out.println("Tree in level order is: ");
        System.out.println(bTree);
    }
}
