import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedListTest_STUDENT {

    BasicDoubleLinkedList<String> linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new BasicDoubleLinkedList<>();
    }

    @Test
    public void getSize() {
        linkedList.addToFront("A");
        linkedList.addToEnd("B");
        assertEquals(2, linkedList.getSize());
    }

    @Test
    public void addToEnd() {
        linkedList.addToEnd("A");
        assertEquals("A", linkedList.getLast());
        linkedList.addToEnd("B");
        assertEquals("B", linkedList.getLast());
    }

    @Test
    public void addToFront() {
        linkedList.addToFront("A");
        assertEquals("A", linkedList.getFirst());
        linkedList.addToFront("B");
        assertEquals("B", linkedList.getFirst());
    }

    @Test
    public void getFirst() {
        linkedList.addToFront("A");
        linkedList.addToEnd("B");
        assertEquals("A", linkedList.getFirst());
    }

    @Test
    public void getLast() {
        linkedList.addToFront("A");
        linkedList.addToEnd("B");
        assertEquals("B", linkedList.getLast());
    }

    @Test
    public void iterator() {
        linkedList.addToFront("A");
        linkedList.addToEnd("B");
        linkedList.addToEnd("C");
        linkedList.addToEnd("D");
        ListIterator<String> iterator = linkedList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertEquals("D", iterator.next());
        assertTrue(iterator.hasPrevious());
        assertEquals("D", iterator.previous());
        assertEquals("C", iterator.previous());
        assertEquals("B", iterator.previous());
        assertEquals("A", iterator.previous());
    }

    @Test
    public void remove() {
        linkedList.addToFront("A");
        linkedList.addToEnd("B");
        linkedList.addToEnd("C");
        linkedList.addToEnd("D");

        assertEquals(4, linkedList.getSize());
        ArrayList<String> list = linkedList.toArrayList();
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals("D", list.get(3));

        // Define a comparator for strings
        Comparator<String> comparator = Comparator.naturalOrder();
        linkedList.remove("B", comparator);

        assertEquals(3, linkedList.getSize());
        list = linkedList.toArrayList();
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
        assertEquals("D", list.get(2));
    }

    @Test
    public void retrieveFirstElement() {
        linkedList.addToFront("A");
        linkedList.addToEnd("B");
        assertEquals("A", linkedList.retrieveFirstElement());
        assertEquals("B", linkedList.getFirst());
    }

    @Test
    public void retrieveLastElement() {
        linkedList.addToFront("A");
        linkedList.addToEnd("B");
        assertEquals("B", linkedList.retrieveLastElement());
        assertEquals("A", linkedList.getLast());
    }

    @Test
    public void toArrayList() {
        linkedList.addToFront("A");
        linkedList.addToEnd("B");
        linkedList.addToEnd("C");
        linkedList.addToEnd("D");
        ArrayList<String> list = linkedList.toArrayList();
        assertEquals(4, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals("D", list.get(3));
    }
}
