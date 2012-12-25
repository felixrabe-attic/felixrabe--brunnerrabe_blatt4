package brunnerrabe.blatt4.aufgabe1;

@SuppressWarnings("unchecked")
public class List {
  private class Node {
    public Comparable element;
    public Node prev;
    public Node next;

    public Node(Comparable element, Node prev, Node next) {
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

    tail = new Node(element, tail, null);
    if (head == null) {
      head = tail;
    } else {
      tail.prev.next = tail;
    }
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
