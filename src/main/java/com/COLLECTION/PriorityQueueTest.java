package com.COLLECTION;

import com.JAVA8.stream.Employee;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
  
    public static void main(String[] args) {

    // Element added to PriorityQueue either need to implement comparable or comparator implementaion should be passed.
        
    /*  A heap is a specialized tree-based data structure that satisfies the heap property.
     It's a complete binary tree where each node is either smaller than or equal to (min-heap)
      or larger than or equal to (max-heap) all of its children.

    Min-Heap (Default): By default, a PriorityQueue in Java is a min-heap.
      This means the element with the highest priority (the "smallest" element according to
      its natural ordering) is always at the head of the queue. When you call poll(),
      you get the smallest element.
    
    Max-Heap (With Comparator): You can create a max-heap by providing
      a custom Comparator that reverses the natural order. 

    1. Add(e) or offer(e): Inserts an element into the heap. This is an O(log n) operation.

    2. remove() or poll(): Removes and returns the head of the heap (the minimum element in a min-heap or maximum in a max-heap). 
       This is also an O(log n) operation.

    3. element() or peek(): Retrieves, but does not remove, the head of the heap.
       This is an O(1) operation.
       
*/
        PriorityQueue<Employee> minHeap = new PriorityQueue<>(Comparator.comparing(Employee::getSalary));
        minHeap.add(new Employee(1, "emp1", 1, 400, null, null, null, 0, null));
        minHeap.add(new Employee(2, "emp2", 2, 900, null, null, null, 0, null));
        minHeap.add(new Employee(3, "emp3", 3, 300, null, null, null, 0, null));
        minHeap.add(new Employee(4, "emp4", 4, 200, null, null, null, 0, null));
        minHeap.add(new Employee(5, "emp5", 5, 700, null, null, null, 0, null));

        System.out.println("minHeap: "+minHeap);

        minHeap.add(new Employee(6, "emp5", 5, 50, null, null, null, 0, null));
        System.out.println("peek the minimum: "+minHeap.peek());

        System.out.println("remove the minimun : "+minHeap.remove());


        // Priority will be decreasing value of salary  
        PriorityQueue<Employee> maxHeap = new PriorityQueue<>(Comparator.comparing(Employee::getSalary).reversed());
        maxHeap.add(new Employee(1, "emp1", 1, 400, null, null, null, 0, null));
        maxHeap.add(new Employee(2, "emp2", 2, 900, null, null, null, 0, null));
        maxHeap.add(new Employee(3, "emp3", 3, 300, null, null, null, 0, null));
        maxHeap.add(new Employee(4, "emp4", 4, 200, null, null, null, 0, null));
        maxHeap.add(new Employee(5, "emp5", 5, 700, null, null, null, 0, null));

        System.out.println("maxHeap: " +maxHeap);

    }

}