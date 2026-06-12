package complexity;

/**
 * Linear search on a sorted array, the chapter's first practice problem.
 * Because the array is in non-decreasing order, the scan can stop the
 * moment it passes where the target would be: best case O(1), worst case
 * O(n), O(1) auxiliary space.
 */
public final class SortedLinearSearch {

  private SortedLinearSearch() {
    // This class should not be instantiated!
  }

  /**
   * Searches a sorted (non-decreasing) array for the target, giving up
   * early once a value larger than the target is seen.
   *
   * @param arr the array to search, sorted in non-decreasing order.
   * @param target the value to look for.
   * @return the index of target, or -1 if it is not present.
   */
  public static int indexOf(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;          // found it
      }
      if (arr[i] > target) {
        return -1;         // passed where target would be; it can't be ahead
      }
    }
    return -1;             // walked off the end without finding it
  }
}
