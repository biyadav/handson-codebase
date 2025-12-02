package com.JAVA8.functionalinterface;

public interface A{

    static String getFullName(String firstName, String lastName){
        return firstName + " " + lastName;
    }
    default String getDefaultTitle(){
        return getPrivateTitle() ;
    }
   

    private String getPrivateTitle(){
        return "Mr.";
    }
    default void print(){
      System.out.println(getDefaultTitle()+getFullName("John","Doe"));
    }



}