package complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests for the three Fibonacci methods. Each test is one scenario, checked
 * against all three versions: recursive, with an array, and with two
 * variables must agree on every input.
 */
public class FibonacciTest {

  @Test
  public void baseCaseZero() {
    assertEquals(0, Fibonacci.fibRecursive(0));
    assertEquals(0, Fibonacci.fibWithArray(0));
    assertEquals(0, Fibonacci.fibWithTwoVariables(0));
  }

  @Test
  public void baseCaseOne() {
    assertEquals(1, Fibonacci.fibRecursive(1));
    assertEquals(1, Fibonacci.fibWithArray(1));
    assertEquals(1, Fibonacci.fibWithTwoVariables(1));
  }

  @Test
  public void firstComputedValue() {
    // smallest n past the base cases: F(2) = F(1) + F(0)
    assertEquals(1, Fibonacci.fibRecursive(2));
    assertEquals(1, Fibonacci.fibWithArray(2));
    assertEquals(1, Fibonacci.fibWithTwoVariables(2));
  }

  @Test
  public void smallN() {
    assertEquals(5, Fibonacci.fibRecursive(5));
    assertEquals(5, Fibonacci.fibWithArray(5));
    assertEquals(5, Fibonacci.fibWithTwoVariables(5));
  }

  @Test
  public void fibOfTen() {
    assertEquals(55, Fibonacci.fibRecursive(10));
    assertEquals(55, Fibonacci.fibWithArray(10));
    assertEquals(55, Fibonacci.fibWithTwoVariables(10));
  }

  @Test
  public void fibOfTwenty() {
    assertEquals(6765, Fibonacci.fibRecursive(20));
    assertEquals(6765, Fibonacci.fibWithArray(20));
    assertEquals(6765, Fibonacci.fibWithTwoVariables(20));
  }

  @Test
  public void fibOfThirty() {
    // large enough that naive recursion is visibly slow
    assertEquals(832040, Fibonacci.fibRecursive(30));
    assertEquals(832040, Fibonacci.fibWithArray(30));
    assertEquals(832040, Fibonacci.fibWithTwoVariables(30));
  }
}
