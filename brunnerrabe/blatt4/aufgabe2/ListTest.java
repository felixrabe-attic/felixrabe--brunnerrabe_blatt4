package brunnerrabe.blatt4.aufgabe2;

import java.util.Iterator;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class ListTest {
  private static final Comparable DUMMY_ELEMENT_1 = new Integer(1);
  private static final Comparable DUMMY_ELEMENT_2 = new Integer(2);
  private static final Comparable DUMMY_ELEMENT_3 = new Integer(3);
  private static final Comparable DUMMY_ELEMENT_4 = new Integer(4);
  private static final Comparable DUMMY_ELEMENT = DUMMY_ELEMENT_1;  // alias

  private List list;

  public ListTest() {
    list = new List();
  }

  @Test
  public void newIsEmpty() {
    assertTrue(list.isEmpty());
  }

  @Test
  public void newSize() {
    assertEquals(0, list.size());
  }

  @Test
  public void insertCompiles() {
    list.insert(DUMMY_ELEMENT);
  }

  @Test
  public void afterInsertNotEmpty() {
    assertTrue(list.isEmpty());
    list.insert(DUMMY_ELEMENT);
    assertFalse(list.isEmpty());
  }

  @Test(expected = ListException.class)
  public void insertNullThrowsException() {
    list.insert(null);
  }

  @Test
  public void afterInsertOneElementSize1() {
    assertEquals(0, list.size());
    assertInsertIncreasesSizeByOne(DUMMY_ELEMENT);
  }

  @Test(expected = ListException.class)
  public void insertingDuplicateElementsThrowsException() {
    list.insert(DUMMY_ELEMENT);
    list.insert(DUMMY_ELEMENT);
  }

  @Test
  public void afterInsertTwoElementsSize2() {
    assertEquals(0, list.size());
    assertInsertIncreasesSizeByOne(DUMMY_ELEMENT_1);
    assertInsertIncreasesSizeByOne(DUMMY_ELEMENT_2);
  }

  private void assertInsertIncreasesSizeByOne(Comparable element) {
    int size = list.size();
    list.insert(element);
    assertEquals(size + 1, list.size());
  }

  @Test
  public void get() {
    list.insert(DUMMY_ELEMENT_1);
    list.insert(DUMMY_ELEMENT_2);
    list.insert(DUMMY_ELEMENT_3);
    assertEquals(DUMMY_ELEMENT_1, list.get(0));
    assertEquals(DUMMY_ELEMENT_2, list.get(1));
    assertEquals(DUMMY_ELEMENT_3, list.get(2));
    // TODO: list.get(3) should throw an exception
  }

  @Test
  public void insertSortedElementsToStaySorted() {
    list.insert(DUMMY_ELEMENT_1);
    list.insert(DUMMY_ELEMENT_2);
    list.insert(DUMMY_ELEMENT_3);
    list.insert(DUMMY_ELEMENT_4);
    assertIsSorted();
  }

  @Test
  public void insertReversedElementsToStaySorted() {
    list.insert(DUMMY_ELEMENT_4);
    list.insert(DUMMY_ELEMENT_3);
    list.insert(DUMMY_ELEMENT_2);
    list.insert(DUMMY_ELEMENT_1);
    assertIsSorted();
  }

  @Test
  public void insertChaoticElementsToStaySorted() {
    list.insert(DUMMY_ELEMENT_2);
    list.insert(DUMMY_ELEMENT_4);
    list.insert(DUMMY_ELEMENT_1);
    list.insert(DUMMY_ELEMENT_3);
    assertIsSorted();
  }

  @Test
  public void removeFirstElement() {
    list.insert(DUMMY_ELEMENT_1);
    list.insert(DUMMY_ELEMENT_2);
    list.insert(DUMMY_ELEMENT_3);

    list.remove(DUMMY_ELEMENT_1);
    assertEquals(DUMMY_ELEMENT_2, list.get(0));
    assertEquals(DUMMY_ELEMENT_3, list.get(1));
  }

  @Test
  public void removeElementInTheMiddle() {
    list.insert(DUMMY_ELEMENT_1);
    list.insert(DUMMY_ELEMENT_2);
    list.insert(DUMMY_ELEMENT_3);

    list.remove(DUMMY_ELEMENT_2);
    assertEquals(DUMMY_ELEMENT_1, list.get(0));
    assertEquals(DUMMY_ELEMENT_3, list.get(1));
  }

  @Test
  public void removeLastElement() {
    list.insert(DUMMY_ELEMENT_1);
    list.insert(DUMMY_ELEMENT_2);
    list.insert(DUMMY_ELEMENT_3);

    list.remove(DUMMY_ELEMENT_3);
    assertEquals(DUMMY_ELEMENT_1, list.get(0));
    assertEquals(DUMMY_ELEMENT_2, list.get(1));
  }

  /** expects all DUMMY_ELEMENTs to be inserted */
  private void assertIsSorted() {
    assertEquals(DUMMY_ELEMENT_1, list.get(0));
    assertEquals(DUMMY_ELEMENT_2, list.get(1));
    assertEquals(DUMMY_ELEMENT_3, list.get(2));
    assertEquals(DUMMY_ELEMENT_4, list.get(3));
  }

  @Test
  public void toString_() {
    assertTrue(list.isEmpty());
    assertEquals("", list.toString());
    list.insert(DUMMY_ELEMENT_1);
    assertEquals("" + DUMMY_ELEMENT_1 + "\n", list.toString());
    list.insert(DUMMY_ELEMENT_2);
    assertEquals("" + DUMMY_ELEMENT_1 + "\n" + DUMMY_ELEMENT_2 + "\n", list.toString());
  }

  @Test
  public void iterate() {
    list.insert(DUMMY_ELEMENT_1);
    list.insert(DUMMY_ELEMENT_2);
    list.insert(DUMMY_ELEMENT_3);

    Iterator<Comparable> iter = list.iterator();

    // while (iter.hasNext()) { Comparable element = iter.next(); }

    assertTrue(iter.hasNext());
    assertEquals(DUMMY_ELEMENT_1, iter.next());

    assertTrue(iter.hasNext());
    assertEquals(DUMMY_ELEMENT_2, iter.next());

    assertTrue(iter.hasNext());
    assertEquals(DUMMY_ELEMENT_3, iter.next());

    assertFalse(iter.hasNext());
  }

  @Test
  public void contains() {
    list.insert(DUMMY_ELEMENT_1);
    list.insert(DUMMY_ELEMENT_3);
    assertTrue(list.contains(DUMMY_ELEMENT_1));
    assertFalse(list.contains(DUMMY_ELEMENT_2));
    assertTrue(list.contains(DUMMY_ELEMENT_3));
    assertFalse(list.contains(DUMMY_ELEMENT_4));
  }
}
