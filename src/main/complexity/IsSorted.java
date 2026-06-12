package complexity;

/**
 * The is-it-sorted check, the chapter's second practice problem. Walks the
 * adjacent pairs and stops at the first one that is out of order. The early
 * return splits the best case from the worst: best case O(1), worst case
 * O(n), O(1) auxiliary space.
 */
public final class IsSorted {

  private IsSorted() {
    // This class should not be instantiated!
  }

  /**
   * Determines whether the array is sorted in non-decreasing order, so
   * equal neighbors are fine. Empty and single-element arrays have no
   * adjacent pairs, so they count as sorted.
   *
   * @param arr the array to check.
   * @return true if the array is sorted in non-decreasing order.
   */
  public static boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] > arr[i]) {
        return false;     // found a descending step — not sorted
      }
    }
    return true;          // never found one — sorted
  }
}
