import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
}

@Test(timeout = 500)
  public void testMerge2() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("b", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge3() {
    List<String> left = Arrays.asList( "b", "c");
    List<String> right = Arrays.asList("a", "c", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge4() {
    List<String> left = Arrays.asList( "b");
    List<String> right = Arrays.asList("b");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("b", "b");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge5() {
    List<String> left = Arrays.asList( "b", "c");
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("b", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter1() {
    List<String> inputList = Arrays.asList("moon", "Sun", "earth", "Moon", "Mars", "moon");
    List<String> expectedFiltered = Arrays.asList("moon", "Moon", "moon");
    List<String> filteredList = ListExamples.filter(inputList, new IsMoon());
    assertEquals(expectedFiltered, filteredList);
  }

  @Test(timeout = 500)
  public void testFilter2() {
    List<String> inputList = Arrays.asList("Moon", "Sun", "earth", "moon", "Mars", "much");
    List<String> expectedFiltered = Arrays.asList("Moon", "moon");
    List<String> filteredList = ListExamples.filter(inputList, new IsMoon());
    assertEquals(expectedFiltered, filteredList);
  }
}

