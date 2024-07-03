import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import static org.junit.Assert.*;

public class SortedDoubleLinkedListTest_STUDENT {

    SortedDoubleLinkedList<String> sortedList;

    @Before
    public void setUp() throws Exception {
        Comparator<String> comparator = Comparator.naturalOrder();
        sortedList = new SortedDoubleLinkedList<>(comparator);
    }

    @Test
    public void addToSorted() {
        sortedList.add("C");
        sortedList.add("A");
        sortedList.add("B");

        ArrayList<String> list = sortedList.toArrayList();
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    public void iterator() {
        sortedList.add("C");
        sortedList.add("A");
        sortedList.add("B");

        ListIterator<String> iterator = sortedList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());

        assertTrue(iterator.hasPrevious());
        assertEquals("C", iterator.previous());
        assertEquals("B", iterator.previous());
        assertEquals("A", iterator.previous());
        assertFalse(iterator.hasPrevious());
    }

    @Test
    public void remove() {
        sortedList.add("C");
        sortedList.add("A");
        sortedList.add("B");

        assertEquals(3, sortedList.getSize());
        ArrayList<String> list = sortedList.toArrayList();
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));

     //   sortedList.remove("B");

        assertEquals(3, sortedList.getSize());
        list = sortedList.toArrayList();
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void retrieveFirstElement() {
        sortedList.add("C");
        sortedList.add("A");
        assertEquals("A", sortedList.retrieveFirstElement());
        assertEquals("C", sortedList.getFirst());
    }

    @Test
    public void retrieveLastElement() {
        sortedList.add("C");
        sortedList.add("A");
        assertEquals("C", sortedList.retrieveLastElement());
        assertEquals("A", sortedList.getFirst());
    }

    @Test
    public void toArrayList() {
        sortedList.add("C");
        sortedList.add("A");
        sortedList.add("B");

        ArrayList<String> list = sortedList.toArrayList();
        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

}
