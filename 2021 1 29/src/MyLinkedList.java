import java.util.ConcurrentModificationException;
import java.util.Iterator;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * @author hasherc
 * @ 17-7-21
 */
public class MyLinkedList<E> implements Iterable<E> {


    private static class Node<E> {
        public Node(E d, Node<E> p, Node<E> n) {
            data = d;
            prev = p;
            next = n;
        }

        public E data;
        public Node<E> prev;
        public Node<E> next;
    }

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        beginMarker = new Node<E>(null, null, null);
        endMarker = new Node<E>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;

    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public boolean add(E x) {
        add(size(), x);
        return true;
    }

    public void add(int index, E x) {
        addBefore(getNode(index), x);
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public E set(int index, E element) {
        Node<E> p = getNode(index);
        E oledElement = p.data;
        p.data = element;
        return oledElement;
    }

    public E remove(int index) {
        return remove(getNode(index));
    }


    private Node<E> getNode(int index) {

        Node<E> p;

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < index; i++)
                p = p.next;
        } else {
            p = endMarker;
            for (int i = size(); i > index; i--)
                p = p.prev;
        }
        return p;
    }

    private void addBefore(Node<E> p, E x) {
        Node<E> newNode = new Node<E>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;

    }

    private E remove(Node<E> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }


    private int theSize;
    private int modCount = 0;
    private Node<E> beginMarker;
    private Node<E> endMarker;

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }


    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!hasNext())
                new NoSuchElementException();

            E nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!okToRemove)
                throw new IllegalStateException();
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(1);
        test.add(1);
        test.add(1);
        test.add(1);
        Iterator<Integer> iterator = test.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (1 == integer) {
                iterator.remove();
            }
        }
    }
}
