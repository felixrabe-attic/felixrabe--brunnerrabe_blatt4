import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class ListTest {
  private static final Comparable DUMMY_ELEMENT = new Comparable<Object>() {
    @Override
    public int compareTo(Object o) {
      return 0;
    }
  };

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
}
