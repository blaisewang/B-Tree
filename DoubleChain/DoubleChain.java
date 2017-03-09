/**
 * DataStructure
 * Created by Blaise Wang on 16/6/4.
 */
package DoubleChain;

import java.util.*;

public class DoubleChain implements LinearList {

    // data members
    private ChainNode headerNode = new ChainNode();
    private int size;

    // constructors

    /**
     * create a list that is empty
     */
    public DoubleChain() {
        headerNode.previous = headerNode.next = headerNode;
    }
    // methods

    /**
     * @return true iff list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return current number of elements in list
     */
    public int size() {
        return size;
    }

    /**
     * @throws IndexOutOfBoundsException when
     *                                   index is not between 0 and size - 1
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index = " + index + "  size = " + size);
    }

    /**
     * @return element with specified index
     * @throws IndexOutOfBoundsException when
     *                                   index is not between 0 and size - 1
     */
    public Object get(int index) {
        checkIndex(index);

        /* move to desired node */
        ChainNode currentNode = headerNode;
        for (int i = 0; i <= index; i++)
            currentNode = currentNode.next;

        return currentNode.element;
    }

    /**
     * @return index of first occurrence of theElement,
     * return -1 if theElement not in list
     */
    public int indexOf(Object theElement) {
        // Put theElement in header node
        headerNode.element = theElement;
        // search the chain for theElement
        ChainNode currentNode = headerNode.next;
        int index = 0;  // index of currentNode
        while (currentNode != null &&
                !currentNode.element.equals(theElement)) {
            // move to next node
            currentNode = currentNode.next;
            index++;
        }

        // make sure we found matching element
        if (currentNode != null && currentNode.equals(headerNode))
            return -1;
        else
            return index;
    }

    /**
     * Remove the element with specified index.
     * All elements with higher index have their
     * index reduced by 1.
     *
     * @return removed element
     * @throws IndexOutOfBoundsException when
     *                                   index is not between 0 and size - 1
     */
    public Object remove(int index) {
        checkIndex(index);

        Object removedElement;
        if (index == 0) { // remove first node
            removedElement = headerNode.next.element;
            headerNode.next = headerNode.next.next;
            headerNode.next.previous = headerNode;
        } else {
            // use q to get to predecessor of desired node
            ChainNode q = headerNode.next;
            for (int i = 0; i < index - 1; i++)
                q = q.next;

            removedElement = q.next.element;
            q.next = q.next.next; // remove desired node
            q.next.previous = q;
        }
        size--;
        return removedElement;
    }

    /**
     * Insert an element with specified index.
     * All elements with equal or higher index
     * have their index increased by 1.
     *
     * @throws IndexOutOfBoundsException when
     *                                   index is not between 0 and size
     */
    public void add(int index, Object theElement) {
        if (index < 0 || index > size)
            // invalid list position
            throw new IndexOutOfBoundsException
                    ("index = " + index + "  size = " + size);

        // find predecessor of new element
        ChainNode p = headerNode;
        for (int i = 0; i < index - 1; i++)
            p = p.next;

        // insert after p
        p.next = new ChainNode(theElement, p, p.next);
        p.next.next.previous = p.next;
        size++;
    }

    /**
     * convert to a string
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");

        // put elements into the buffer
        ChainNode currentNode = headerNode.next;
        while (currentNode != null && !currentNode.equals(headerNode)) {
            if (currentNode.element == null)
                s.append("null, ");
            else
                s.append(currentNode.element.toString()).append(", ");
            currentNode = currentNode.next;
        }
        if (size > 0)
            s.delete(s.length() - 2, s.length());  // remove last ", "
        s.append("]");

        // create equivalent String
        return s.toString();
    }

    /**
     * convert to a string with inverted sequence
     */
    public String reverseOutput() {
        StringBuilder s = new StringBuilder("[");

        // put elements into the buffer
        ChainNode currentNode = headerNode.previous;
        while (currentNode != null && !currentNode.equals(headerNode)) {
            if (currentNode.element == null)
                s.append("null, ");
            else
                s.append(currentNode.element.toString()).append(", ");
            currentNode = currentNode.previous;
        }
        if (size > 0)
            s.delete(s.length() - 2, s.length());  // remove last ", "
        s.append("]");

        // create equivalent String
        return s.toString();
    }

    /**
     * create and return an iterator
     */
    public Iterator iterator() {
        return new ChainIterator();
    }

    /**
     * chain iterator
     */
    private class ChainIterator implements Iterator {
        // data member
        private ChainNode nextNode;

        // constructor
        ChainIterator() {
            nextNode = headerNode.next;
        }

        // methods

        /**
         * @return true iff list has a next element
         */
        public boolean hasNext() {
            return nextNode != null && !nextNode.equals(headerNode);
        }

        /**
         * @return next element in list
         * @throws NoSuchElementException when there is no next element
         */
        public Object next() {
            if (nextNode != null && !nextNode.equals(headerNode)) {
                Object elementToReturn = nextNode.element;
                nextNode = nextNode.next;
                return elementToReturn;
            } else
                throw new NoSuchElementException("No next element");
        }

        /**
         * unsupported method
         */
        public void remove() {
            throw new UnsupportedOperationException
                    ("remove not supported");
        }
    }
}
