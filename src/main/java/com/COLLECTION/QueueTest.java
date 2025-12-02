package com.COLLECTION;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {
    public static void main(String[] args) {

        System.out.println("#################  Queue ##########################");

        // difference between poll and remove is that poll returns null if queue is empty 
        // and remove throws exception


        // difference between offer and add is that offer returns false if queue is full 
        // and add throws exception


        // poll ----- remove 
        // offer ------ add 

        
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
    

        deque.addFirst(0);
        deque.addLast(5);
        System.out.println(deque);

        int first = deque.getFirst();
        System.out.println("deque.getFirst() is %s ".formatted(first));

        int last = deque.getLast();
        System.out.println("deque.getFirst() is %s ".formatted(last));

        int pollFirst = deque.pollFirst();
        System.out.println("deque.pollFirst() is %s ".formatted(pollFirst));

        int pollLast = deque.pollLast();
        System.out.println("deque.pollLast() is %s ".formatted(pollLast));

        int peekFirst = deque.peekFirst();
        System.out.println("deque.peekFirst() is %s ".formatted(peekFirst));

        int peekLast = deque.peekLast();
        System.out.println("deque.peekLast() is %s ".formatted(peekLast));



        System.out.println("################# Blocking Queue ##########################");
        Queue<Integer> queue = new LinkedBlockingQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
       
        queue.offer(7); // add element without exception for size restricted queue and return true/false
        int polled = queue.poll() ;//  return and removes head of queue 
        System.out.println("polled is %s ".formatted(polled));

        int peekedItem =queue.peek(); // return head of queue without removing it
        System.out.println("peekedItem is %s ".formatted(peekedItem));
        int removedItem = queue.remove(); // remove head of queue
        System.out.println("removedItem is %s ".formatted(removedItem));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        queue.removeIf(i -> i%2==0);
        System.out.println(queue.size());
        
    }
    
}
