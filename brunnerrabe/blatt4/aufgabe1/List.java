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

    head = new Node(element, null, head);
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
