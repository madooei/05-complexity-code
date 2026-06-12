package complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests for the early-stopping linear search on a sorted array. Each test is
 * one scenario from the notes, including the inputs that produce the best
 * case (stop at the first element) and the worst case (a full scan).
 */
public class SortedLinearSearchTest {

  @Test
  public void foundInTheMiddle() {
    assertEquals(2, SortedLinearSearch.indexOf(new int[] {2, 5, 8, 11, 14}, 8));
  }

  @Test
  public void absentEarlyStop() {
    // target falls between two elements; the scan stops as soon as it passes 9
    assertEquals(-1, SortedLinearSearch.indexOf(new int[] {2, 5, 8, 11, 14}, 9));
  }

  @Test
  public void smallerThanFirst() {
    // target is below every element; the first comparison already passes it
    assertEquals(-1, SortedLinearSearch.indexOf(new int[] {2, 5, 8, 11, 14}, 1));
  }

  @Test
  public void firstElement() {
    assertEquals(0, SortedLinearSearch.indexOf(new int[] {2, 5, 8, 11, 14}, 2));
  }

  @Test
  public void lastElement() {
    assertEquals(4, SortedLinearSearch.indexOf(new int[] {2, 5, 8, 11, 14}, 14));
  }

  @Test
  public void largerThanMax() {
    // target exceeds every element; the early stop never fires and the scan runs to the end
    assertEquals(-1, SortedLinearSearch.indexOf(new int[] {2, 5, 8, 11, 14}, 20));
  }

  @Test
  public void emptyArray() {
    assertEquals(-1, SortedLinearSearch.indexOf(new int[] {}, 5));
  }

  @Test
  public void singleElementFound() {
    assertEquals(0, SortedLinearSearch.indexOf(new int[] {7}, 7));
  }
}
