package complexity;

/**
 * Bubble sort, the chapter's last practice problem, in two versions: the
 * plain sort, which costs O(n^2) on every input, and the version with
 * early termination, whose best case drops to O(n) on an already-sorted
 * array while the worst case stays O(n^2). Both sort the array in place
 * with O(1) auxiliary space.
 */
public final class BubbleSort {

  private BubbleSort() {
    // This class should not be instantiated!
  }

  /**
   * Sorts the array in place with plain bubble sort: repeated passes of
   * adjacent compare-and-swap, with the settled tail growing by one each
   * pass. O(n^2) time on every input.
   *
   * @param arr the array to sort.
   */
  public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];        // swap the out-of-order pair
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  /**
   * Sorts the array in place with bubble sort plus early termination: a
   * flag tracks whether the current pass swapped anything, and a clean
   * pass ends the sort, since it means the array is already in order.
   * Best case O(n), worst case O(n^2).
   *
   * @param arr the array to sort.
   */
  public static void bubbleSortWithEarlyTermination(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];        // swap the out-of-order pair
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;           // remember that this pass did work
        }
      }
      if (!swapped) {
        break;                      // a clean pass means the array is already sorted
      }
    }
  }
}
