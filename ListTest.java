import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class ListTest {
  private static final Comparable DUMMY_ELEMENT_1 = new Integer(1);
  private static final Comparable DUMMY_ELEMENT = DUMMY_ELEMENT_1;  // alias
  private static final Comparable DUMMY_ELEMENT_2 = new Integer(2);

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
    list.insert(DUMMY_ELEMENT);
    assertEquals(1, list.size());
  }

  @Test(expected = ListException.class)
  public void insertingDuplicateElementsThrowsException() {
    list.insert(DUMMY_ELEMENT);
    list.insert(DUMMY_ELEMENT);
  }
}
