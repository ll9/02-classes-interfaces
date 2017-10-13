package de.fhro.inf.prg3.a02;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList {
    Element head;

    private static class Element {
        private Object item;
        private Element next;
    }
}
