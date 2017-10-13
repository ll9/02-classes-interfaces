package de.fhro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList {
    Element head = null;

    private static class Element {
        private Object item = null;
        private Element next = null;

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

    private class MyIterator implements Iterator<Element> {
        Element cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Element next() {
            if (this.hasNext()) {
                Element current = cursor;
                cursor = cursor.getNext();
                return current;
            }
        }
    }
}
