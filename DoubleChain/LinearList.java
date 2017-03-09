/**
 * DataStructure
 * Created by Blaise Wang on 16/6/4.
 */
package DoubleChain;

interface LinearList {
    boolean isEmpty();

    int size();

    Object get(int index);

    int indexOf(Object theElement);

    Object remove(int index);

    void add(int index, Object theElement);

    String toString();
}
