package BTree;

/**
 * DataStructure
 * Created by Blaise Wang on 16/6/5.
 */

class Pair<A extends Comparable<A>, B> implements Comparable<Pair<A, B>> {
    A first;
    B second;

    Pair(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        if (first == null || second == null)
            return "(null, null)";
        return "(" + first.toString() + ", " + second.toString() + ")";
    }

    @Override
    public int compareTo(Pair<A, B> o) {
        return first.compareTo(o.first);
    }
}
