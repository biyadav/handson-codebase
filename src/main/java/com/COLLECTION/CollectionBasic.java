package com.COLLECTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionBasic {
    
    public static void main(String[] args) {

        // List.of() and Arrays.asList is immutable elements can be replaced 
        List <Integer>list = List.of(1,2,3,4,5); // cannot modify list 
       // list.add(4); list.remove(2);// UnsupportedOperationException immutable List 
      
        //list.add(2,4); // cannot replace element at index  UnsupportedOperationException immutable List 
        System.out.println(list);

        int maxItem = Collections.max(list);
        System.out.println("maxItem"+maxItem);

        int minItem = Collections.min(list);
        System.out.println("minItem"+minItem);

        List<String> myList = Arrays.asList("hello","namaste","bye");
        // myList.add("GM");// java.lang.UnsupportedOperationException
        myList.add(1,"GM");// UnsupportedOperationException 

        List<String> unmodifiableList = Collections.unmodifiableList(new ArrayList<String>());
        //unmodifiableList.add("Abc");  // java.lang.UnsupportedOperationException


     
        


    }
}
