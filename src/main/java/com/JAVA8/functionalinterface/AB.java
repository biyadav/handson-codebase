package com.JAVA8.functionalinterface;

public class AB implements A, B {

    @Override
    public String getDefaultTitle() {
        return A.super.getDefaultTitle();
    }

    @Override
    public void print() {
        System.out.println("From FunctionalInterfaceA: " + A.super.getDefaultTitle());
        System.out.println("From FunctionalInterfaceB: " + B.super.getDefaultTitle());
    }
}
