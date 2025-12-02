package com.COLLECTION;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHasMapTest {
    public static void main(String[] args) {

        /*
          ifPresent take (k,v) ifAbsent take (k)


        
        */

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");

        map.compute("key1", (k, v) -> v + "updatedkey1");
        System.out.println(map.get("key1")); // Output: value1updated)

        map.compute("key8", (k, v) -> v + "updatedkey8");
        System.out.println(map.get("key8")); // Output: nullupdated // key8 

        map.computeIfAbsent("key4", k -> "value4updated");
        System.out.println(map.get("key5")); // Output:value5

        map.computeIfAbsent("key5", k -> "value5");
        System.out.println(map.get("key5")); // Output:value5 as key5 not present 

        map.computeIfPresent("key6", (k, v) -> v + "updated");
        System.out.println(map.get("key6")); // Output: null as key6 not present
      

         map.forEach((k,v)->System.out.println(k+" "+v));
         map.getOrDefault("key7", "defaultvalue"); // Output: defaultvalue as key7 not present
         map.putIfAbsent("key7", "value7");
         System.out.println(map.get("key7")); // Output: value7 as key7 not present
         boolean returned = map.remove("key7", "value7");  // return true
         map.replaceAll((k,v)->v.toUpperCase());
         System.out.println(map.get("key1")); // Output: VALUE1UPDATEDKEY1 replaced in map 
         map.replace("key1", "VALUE1UPDATEDKEY1", "newvalue1");// replace when K,V match else not 
         System.out.println(map.get("key1")); // Output: newvalue1 as key1 updated in map )
         map.replace("key1", "newvalue1"); // replace when K match else not 
         System.out.println(map.get("key1")); // Output: newvalue1
        









        
    }
}
