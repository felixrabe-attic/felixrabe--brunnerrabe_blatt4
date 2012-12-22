package brunnerrabe.blatt4.aufgabe1;

@SuppressWarnings("unchecked")
public class List {
  private Comparable element = null;

  /** Praedikat, das prueft, ob Liste leer ist */
  public boolean isEmpty() {
    return element == null;
  }

  /** aktuelle Anzahl der Elemente */
  public int size() {
    return element == null ? 0 : 1;
  }

  /** sortiertes Einfuegen eines gegebenen Elementes, keine doppelten Elemente */
  public void insert(Comparable element) {
    if (element == null) {
      throw new ListException();
    } else if (contains(element)) {  // no duplicate elements
      throw new ListException();
    }
    this.element = element;
  }

  /** pruefe, ob ein gegebenes Element bereits in der Liste vorhanden ist */
  private boolean contains(Comparable element) {
    return this.element != null && element.compareTo(this.element) == 0;
  }
}
