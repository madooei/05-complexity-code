# Complexity Analysis

The companion code for the Complexity Analysis chapter: the three Fibonacci
versions the chapter develops, the chapter's practice problems (linear search
on a sorted array, the is-it-sorted check, and bubble sort with and without
early termination), and a JUnit suite that exercises every version.

## Prerequisites

- JDK 17+ (JUnit 6 requires it). The JUnit jar is already vendored in `lib/`;
  there is nothing to download.

## Repository Layout

```plaintext
.
├── lib/
│   └── junit-platform-console-standalone-6.1.0.jar
├── src/
│   ├── main/
│   │   └── complexity/                  # the taught code
│   │       ├── Fibonacci.java           #   recursive, with an array, with two variables
│   │       ├── SortedLinearSearch.java  #   linear search that stops early on sorted input
│   │       ├── IsSorted.java            #   is the array sorted? early return on a descent
│   │       └── BubbleSort.java          #   plain, and with early termination
│   └── test/
│       └── complexity/
│           ├── FibonacciTest.java
│           ├── SortedLinearSearchTest.java
│           ├── IsSortedTest.java
│           └── BubbleSortTest.java
└── scripts/
    └── test.sh                          # compile + run every JUnit suite
```

## Run the tests

```bash
./scripts/test.sh
```

This compiles everything and runs the full suite: every scenario is checked
against every version of the method it tests.

## The chapter's code

Each class collects the versions of one method exactly as the lecture pages
develop them, side by side, so you can compare their costs:

- `Fibonacci` has three versions of `fib`. The recursive one is O(2^n) time
  and O(n) space; building up an array is O(n) time and O(n) space; keeping
  just two variables is O(n) time and O(1) space. Same numbers, three costs.
- `SortedLinearSearch` stops the scan the moment it passes where the target
  would be. The early stop makes the best case O(1); the worst case is
  still O(n).
- `IsSorted` walks the adjacent pairs and returns at the first descent. The
  early return is what splits the best case, O(1), from the worst, O(n).
- `BubbleSort` has the plain sort, O(n^2) on every input, next to the
  early-termination version, whose best case drops to O(n) on an
  already-sorted array. Both sort in place.
