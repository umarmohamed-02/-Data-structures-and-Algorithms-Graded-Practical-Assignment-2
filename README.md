# Data Structure and Graph Performance Analyzer

CIT300 Data Structures and Algorithms – Graded Practical Assignment 2 (Week 12)

## Project Description

- A Java console-based application that demonstrates data structures, searching, graph traversal and performance comparison
- Includes Array, Stack, Queue, Linked List, Searching, Graph (BFS/DFS) and a performance comparison
- All modules are integrated into one main menu

## Technologies Used

- Java (console application)
- Git and GitHub (branches, commits, pull requests)

## Main Features

- Array: insert, insert at index, delete (with shifting), search, display, sort (dual-pivot quicksort)
- Searching: linear search and binary search with step counter and nanosecond timing, plus side-by-side comparison
- Stack: push, pop, peek, display, empty check (handles pop on empty stack)
- Queue: enqueue, dequeue, peek, display, empty check (handles dequeue on empty queue)
- Linked List: insert, delete, search, display, size
- Graph: undirected graph (adjacency list), add vertex, add edge, display, BFS, DFS with step counter
- Performance comparison: Array vs Linked List for insert, search and delete (steps and time)
- Input validation and empty-state handling throughout

## Team Members

### 1. M.K. Umar Mohamed (Group Leader)
- Student ID: 23DA2-0501
- Assigned Responsibility: Array Operations and Searching Algorithms
- Individual Contribution:
  - `ArrayOps`: fixed-capacity array, insert, insert-at-index, delete with shifting, search, display
  - Dual-pivot quicksort and capacity checks (`isEmpty`, `isFull`, `getSize`)
  - `SearchOps`: linear search O(n) and binary search O(log n) with step counter and nanosecond timing
  - Side-by-side search comparison mode
  - `ArraySearchMenu`: submenus with input validation
- Git Branch: `feature/array-search`

### 2. H.F.F. Hamna
- Student ID: 23DA2-0479
- Assigned Responsibility: Stack and Queue Operations
- Individual Contribution:
  - `src/stack/MyStack.java`: push, pop (empty check), peek, display, isEmpty, size – O(1)
  - `src/stack/stackqueue/MyQueue.java`: enqueue, dequeue (empty check), peek, display, isEmpty, size – O(1)
  - `src/stack/stackqueue/TestStackQueue.java`: standalone test driver
- Git Branch: `hamna-stack-queue`

### 3. M.A. Aabith Nihmy
- Student ID: 23DA2-0538
- Assigned Responsibility: Linked List and Performance Analysis
- Individual Contribution:
  - `src/linkedlist/LinkedList.java`: singly linked list with custom nodes; insert, delete, search, display, size, empty check
  - `src/linkedlist/PerformanceAnalyzer.java`: Array vs Linked List benchmark for insert, search and delete (steps and ns), formatted results table
  - `src/linkedlist/LinkedListTest.java`: standalone test suite
- Git Branch: `feature/linked-list-pr`

### 4. S.A.M. Seyed Asliff Ahamed Moulana
- Student ID: 23DA2-0609
- Assigned Responsibility: Graph Operations and Integration
- Individual Contribution:
  - `src/graph/Graph.java`: undirected graph using `Map<String, List<String>>`
  - Add vertex and add edge with validation, graph display
  - BFS (queue) and DFS (stack/recursion) with step counter – O(V + E)
  - Integrated all modules into the main menu and submenus
  - Input loop and scanner error handling
- Git Branch: `feature/graph-integration`

## How to Run

- Prerequisites: JDK 8 or later installed
- Clone the repository:
  ```bash
  git clone https://github.com/umarmohamed-02/-Data-structures-and-Algorithms-Graded-Practical-Assignment-2.git
  cd -Data-structures-and-Algorithms-Graded-Practical-Assignment-2
  ```
- Compile all source files:
  ```bash
  javac -d out src/Main.java src/array/*.java src/search/*.java src/stack/*.java src/stack/stackqueue/*.java src/linkedlist/*.java src/graph/*.java
  ```
- Run the integrated console application:
  ```bash
  java -cp out Main
  ```
- (Optional) Run standalone unit test drivers:
  ```bash
  # Stack and Queue Test Driver:
  java -cp out stack.stackqueue.TestStackQueue

  # Linked List Test Driver:
  java -cp out linkedlist.LinkedListTest

  # Performance Analyzer Benchmark:
  java -cp out linkedlist.PerformanceAnalyzerTest
  ```

## Main Menu Options

```text
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

## Repository

- GitHub: https://github.com/umarmohamed-02/-Data-structures-and-Algorithms-Graded-Practical-Assignment-2
