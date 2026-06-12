package complexity;

/**
 * The three Fibonacci methods developed in this chapter. All three compute
 * the same numbers; what changes is the cost: the recursive version takes
 * exponential time, building up an array brings the time down to linear,
 * and keeping just two variables drops the auxiliary space to constant.
 */
public final class Fibonacci {

  private Fibonacci() {
    // This class should not be instantiated!
  }

  /**
   * Computes the nth Fibonacci number directly from the recursive
   * definition. Each call with n >= 2 makes two more calls, and the same
   * subproblems are recomputed over and over: O(2^n) time, O(n) space
   * from the deepest call-stack chain.
   *
   * @param n which Fibonacci number to compute (n >= 0).
   * @return the nth Fibonacci number.
   */
  public static int fibRecursive(int n) {
    if (n <= 1) {
      return n;
    }
    return fibRecursive(n - 1) + fibRecursive(n - 2);
  }

  /**
   * Computes the nth Fibonacci number from the bottom up, storing every
   * value in an array so each is calculated exactly once: O(n) time,
   * O(n) auxiliary space for the array.
   *
   * @param n which Fibonacci number to compute (n >= 0).
   * @return the nth Fibonacci number.
   */
  public static int fibWithArray(int n) {
    if (n <= 1) {
      return n;
    }
    int[] f = new int[n + 1];
    f[0] = 0;
    f[1] = 1;
    for (int i = 2; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }
    return f[n];
  }

  /**
   * Computes the nth Fibonacci number with a two-cell window that slides
   * up the sequence. Each value needs only the two before it, so keeping
   * just those two gives O(n) time and O(1) auxiliary space.
   *
   * @param n which Fibonacci number to compute (n >= 0).
   * @return the nth Fibonacci number.
   */
  public static int fibWithTwoVariables(int n) {
    if (n <= 1) {
      return n;
    }
    int prev = 0;
    int curr = 1;
    for (int i = 2; i <= n; i++) {
      int next = prev + curr;
      prev = curr;
      curr = next;
    }
    return curr;
  }
}
