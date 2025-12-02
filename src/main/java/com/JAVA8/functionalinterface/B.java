package com.JAVA8.functionalinterface;

public interface B{

    static String getFullName(String firstName, String lastName){
        return firstName + " " + lastName;
    }
    default String getDefaultTitle(){
         return getPrivateTitle() ;
    }
    private String getPrivateTitle(){
        return "Ms.";
    }
    default void print(){
        System.out.println(getDefaultTitle()+getFullName("John","Doe"));
      }
}