import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

    private Comparator<T> comparator;

    public SortedDoubleLinkedList(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    @Override
    public void addToFront(T data) {
        throw new UnsupportedOperationException("Cannot add element to front in a sorted list");
    }

    @Override
    public void addToEnd(T data) {
        throw new UnsupportedOperationException("Cannot add element to end in a sorted list");
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            Node current = head;
            while (current != null && comparator.compare(current.data, data) <= 0) {
                current = current.next;
            }
            if (current == head) {  // Insert at the front
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) {  // Insert at the end
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {  // Insert in the middle
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    protected class DoubleLinkedListIterator extends BasicDoubleLinkedList<T>.DoubleLinkedListIterator {
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported in this iterator");
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return super.next();
        }
    }
}
