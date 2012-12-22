public class List {
  private boolean empty = true;

  /** Praedikat, das prueft, ob Liste leer ist */
  public boolean isEmpty() {
    return empty;
  }

  /** aktuelle Anzahl der Elemente */
  public int size() {
    return 0;
  }

  /** sortiertes Einfuegen eines gegebenen Elementes, keine doppelten Elemente */
  public void insert(Comparable element) {
    empty = false;
  }
}
