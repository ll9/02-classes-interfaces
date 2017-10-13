package de.fhro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {
    Element head = null;
    int size = 0;

    private static class Element {
        private Object item = null;
        private Element next = null;

        public Element(Object item) {
            this.item = item;
        }

        public Object getItem() {
            return item;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    private class SimpleIteratorImplf implements Iterator<Object> {
        Element cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Object next() {
            Element current = cursor;
            cursor = cursor.getNext();
            return current.getItem();
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new SimpleIteratorImplf();
    }

    @Override
    public void add(Object o) {
        if (head == null)
            head = new Element(o);
        else {
            Element cursor = head;
            while (cursor.getNext() != null)
                cursor = cursor.getNext();

            cursor.setNext(new Element(o));
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleListImpl filteredSimpleList = new SimpleListImpl();

        for (Object object: this) {
            if (filter.include(object))
                this.add(new Element(object));
        }
        return this;
    }
}
