# Data Structure & Graph Performance Analyzer
**CIT300 Data Structures and Algorithms — Graded Practical Assignment 2**

An interactive Java console application integrating core data structures, searching algorithms, graph traversals, and comparative performance analysis.

---

## Team Contributions

### 1. UMAR MOHAMED – Member 1
**Responsibility: Array Operations & Searching Algorithms**

- **Array Operations (`ArrayOps`)**:
  - Fixed-capacity integer array implementation.
  - Insert, insert-at-index, delete (with shifting), search, and display operations.
  - Array sorting using dual-pivot quicksort.
  - Capacity and boundary checks (`isEmpty`, `isFull`, `getSize`).
- **Searching Algorithms (`SearchOps`)**:
  - Linear Search implementation with step counter and nanosecond timing ($O(n)$).
  - Binary Search implementation with step counter and nanosecond timing ($O(\log n)$) on sorted data.
  - Side-by-side search comparison mode.
- **Console Interface (`ArraySearchMenu`)**:
  - Interactive submenus for Array and Searching operations.
  - Robust input validation preventing crashes on non-numeric inputs or empty states.
- **Git Branch**: `feature/array-search`

---

### 2. H.F.F HAMNA – 23DA2-0479
**Responsibility: Stack and Queue Operations**

- **Stack Implementation (`src/stack/MyStack.java`)**:
  - Push an item onto the stack ($O(1)$).
  - Pop an item from the stack ($O(1)$) with empty check.
  - Peek / view top item without removing.
  - Display stack elements (top to bottom).
  - Check whether the stack is empty and retrieve size.
- **Queue Implementation (`src/stack/stackqueue/MyQueue.java`)**:
  - Enqueue an item into the rear ($O(1)$).
  - Dequeue an item from the front ($O(1)$) with empty check.
  - Peek / view the front item.
  - Display queue elements (front to rear).
  - Check whether the queue is empty and retrieve size.
- **Testing**:
  - Standalone unit test driver in `src/stack/stackqueue/TestStackQueue.java`.
- **Git Branch**: `hamna-stack-queue`

---

### 3. MA.AABITH NIHMY – 23DA2-0538
**Responsibility: Linked List and Performance Analysis**

- **Linked List Implementation (`src/linkedlist/LinkedList.java`)**:
  - Singly Linked List implementation using custom nodes and pointers.
  - Insert, delete, search, and display operations.
  - List size and empty-status checking.
- **Performance Comparison (`src/linkedlist/PerformanceAnalyzer.java`)**:
  - Benchmark comparing Array vs. Linked List for Insert, Search, and Delete operations.
  - Step counter comparison and runtime in nanoseconds.
  - Formatted results display table.
- **Testing**:
  - Standalone test suite in `src/linkedlist/LinkedListTest.java`.
- **Git Branch**: `feature/linked-list-pr`

---

### 4. S.A.M. SEYED ASLIFF AHAMED MOULANA – 23DA2-0609
**Responsibility: Graph Operations and Integration**

- **Graph Implementation (`src/graph/Graph.java`)**:
  - Undirected Graph representation using an adjacency list (`Map<String, List<String>>`).
  - Add vertex and add edge operations with validation.
  - Graph structure display.
  - Breadth-First Search (BFS) traversal using a queue with step counter ($O(V + E)$).
  - Depth-First Search (DFS) traversal using a stack/recursion with step counter ($O(V + E)$).
- **Integration**:
  - Main menu and submenus integration wiring all team members' modules.
  - Robust user input loop and scanner error handling.
- **Git Branch**: `feature/graph-integration`

---

## How to Compile & Run

### 1. Compile all source files
```bash
javac -d out src/Main.java src/array/*.java src/search/*.java src/stack/*.java src/stack/stackqueue/*.java src/linkedlist/*.java src/graph/*.java
```

### 2. Run the integrated application
```bash
java -cp out Main
```

---

## Main Menu Options

```
========================================
 Data Structure & Graph Performance Analyzer
========================================
1. Array Operations
2. Stack Operations
3. Queue Operations
4. Linked List Operations
5. Searching Operations
6. Graph Operations
7. Performance Comparison
9. Exit
```
