package complexity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests for the two bubble sorts. Both versions sort the array in place,
 * so each test hands each version its own copy of the input and asserts
 * on the mutated array: the plain sort and the early-termination sort
 * must agree on every input.
 */
public class BubbleSortTest {

  @Test
  public void happyPath() {
    // unsorted array sorts ascending
    int[] plain = {5, 1, 4, 2};
    int[] early = {5, 1, 4, 2};
    BubbleSort.bubbleSort(plain);
    BubbleSort.bubbleSortWithEarlyTermination(early);
    assertArrayEquals(new int[] {1, 2, 4, 5}, plain);
    assertArrayEquals(new int[] {1, 2, 4, 5}, early);
  }

  @Test
  public void emptyArray() {
    int[] plain = {};
    int[] early = {};
    BubbleSort.bubbleSort(plain);
    BubbleSort.bubbleSortWithEarlyTermination(early);
    assertArrayEquals(new int[] {}, plain);
    assertArrayEquals(new int[] {}, early);
  }

  @Test
  public void singleElement() {
    int[] plain = {1};
    int[] early = {1};
    BubbleSort.bubbleSort(plain);
    BubbleSort.bubbleSortWithEarlyTermination(early);
    assertArrayEquals(new int[] {1}, plain);
    assertArrayEquals(new int[] {1}, early);
  }

  @Test
  public void alreadySorted() {
    // best case for early termination
    int[] plain = {1, 2, 3};
    int[] early = {1, 2, 3};
    BubbleSort.bubbleSort(plain);
    BubbleSort.bubbleSortWithEarlyTermination(early);
    assertArrayEquals(new int[] {1, 2, 3}, plain);
    assertArrayEquals(new int[] {1, 2, 3}, early);
  }

  @Test
  public void reverseSorted() {
    // worst case, no early exit fires
    int[] plain = {3, 2, 1};
    int[] early = {3, 2, 1};
    BubbleSort.bubbleSort(plain);
    BubbleSort.bubbleSortWithEarlyTermination(early);
    assertArrayEquals(new int[] {1, 2, 3}, plain);
    assertArrayEquals(new int[] {1, 2, 3}, early);
  }

  @Test
  public void allEqual() {
    int[] plain = {4, 4, 4};
    int[] early = {4, 4, 4};
    BubbleSort.bubbleSort(plain);
    BubbleSort.bubbleSortWithEarlyTermination(early);
    assertArrayEquals(new int[] {4, 4, 4}, plain);
    assertArrayEquals(new int[] {4, 4, 4}, early);
  }

  @Test
  public void longerUnsorted() {
    int[] plain = {5, 1, 4, 2, 8};
    int[] early = {5, 1, 4, 2, 8};
    BubbleSort.bubbleSort(plain);
    BubbleSort.bubbleSortWithEarlyTermination(early);
    assertArrayEquals(new int[] {1, 2, 4, 5, 8}, plain);
    assertArrayEquals(new int[] {1, 2, 4, 5, 8}, early);
  }

  @Test
  public void negatives() {
    // mix of negative and positive values
    int[] plain = {-3, 1, -7, 4};
    int[] early = {-3, 1, -7, 4};
    BubbleSort.bubbleSort(plain);
    BubbleSort.bubbleSortWithEarlyTermination(early);
    assertArrayEquals(new int[] {-7, -3, 1, 4}, plain);
    assertArrayEquals(new int[] {-7, -3, 1, 4}, early);
  }
}
