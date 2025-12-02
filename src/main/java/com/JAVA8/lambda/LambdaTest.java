package com.JAVA8.lambda;

public class LambdaTest {

public static void main(String[] args) {
    
    BinaryOperator add = (first, second) -> first + second;
    BinaryOperator sub = (first, second) -> first - second;
    BinaryOperator mul = (first,second) -> first * second;
    BinaryOperator div = (first,second) -> first / second;

    System.out.println("sum is : %d".formatted(add.operate(10, 20)));
    System.out.println("sub is : %d".formatted(sub.operate(10, 20)));
    System.out.println("mul is : %d".formatted(mul.operate(10, 20)));
    System.out.println("div is : %d".formatted(div.operate(10, 20)));

}


}