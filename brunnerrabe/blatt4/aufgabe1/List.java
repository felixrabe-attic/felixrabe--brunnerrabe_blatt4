package brunnerrabe.blatt4.aufgabe1;

@SuppressWarnings("unchecked")
public class List {
  private class Node {
    public Comparable element;
    public Node prev;
    public Node next;

    public Node(Comparable element, Node prev, Node next) {
      // TODO: remove prev and next arguments if not needed
      this.element = element;
      this.prev    = prev;
      this.next    = next;
    }
  }

  private Node head;
  private Node tail;

  public List() {
    this.head = null;
    this.tail = null;
  }

  /** Praedikat, das prueft, ob Liste leer ist */
  public boolean isEmpty() {
    return head == null;
  }

  /** aktuelle Anzahl der Elemente */
  public int size() {
    int size = 0;
    Node current = head;
    while (current != null) {
      size++;
      current = current.next;
    }
    return size;
  }

  /** sortiertes Einfuegen eines gegebenen Elementes, keine doppelten Elemente */
  public void insert(Comparable element) {
    if (element == null) {
      throw new ListException();
    } else if (contains(element)) {  // no duplicate elements
      throw new ListException();
    }

    Node newNode = new Node(element, null, null);
    Node larger = findFirstNodeLargerThan(newNode);

    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else if (larger == head) {  // larger.prev == null
      // insert at beginning
      newNode.next = larger;
      newNode.next.prev = newNode;
      head = newNode;
    } else if (larger == null) {
      // insert at end
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    } else {
      // insert in the middle
      newNode.next = larger;
      newNode.prev = larger.prev;
      newNode.prev.next = newNode;
      newNode.next.prev = newNode;
    }
  }

  private Node findFirstNodeLargerThan(Node newNode) {
    Node larger = head;
    while (larger != null) {  // TODO: write test to prove that 'larger != null' is the right way
      if (larger.element.compareTo(newNode.element) > 0) {
        break;
      }
      larger = larger.next;
    }
    return larger;
  }

  /** Returns the element at the specified position in this list (like java.util.List.get()) */
  public Comparable get(int index) {
    Node current = head;

    for (int i = 0; i < index; i++) {
      current = current.next;
    }

    return current.element;
  }

  /** pruefe, ob ein gegebenes Element bereits in der Liste vorhanden ist */
  private boolean contains(Comparable element) {
    Node current = head;
    while (current != null) {
      if (current.element.compareTo(element) == 0) {
        return true;
      }
      current = current.next;
    }

    return false;
  }
}
