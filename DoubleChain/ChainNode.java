/**
 * DataStructure
 * Created by Blaise Wang on 16/6/4.
 */
package DoubleChain;

class ChainNode {
    // package visible data members
    Object element;
    ChainNode previous;
    ChainNode next;

    // package visible constructors
    ChainNode() {
    }

    ChainNode(Object element, ChainNode previous, ChainNode next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }
}
