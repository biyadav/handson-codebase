package com.java8;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collector;

public class StreamExample {
    public static void main(String[] args) {
       List<Employee> employees = initializeEmployeedata();

       System.out.println("######## Group the Employees by city.");
       employees.stream().collect(Collectors.groupingBy(Employee::getCity)).entrySet()
      .forEach(entry -> System.out.println(entry.getKey()+""+entry.getValue()));

      System.out.println("######## count of male and female employees");
      employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
      .forEach((k,v) -> System.out.println(k+" "+v));

      System.out.println(" ########## names of all departments ");
      employees.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

      System.out.println(" ########## Full employee Object with maximum age ");
      employees.stream().collect(Collectors.maxBy((e1,e2) -> e1.getAge() - e2.getAge())).ifPresent(System.out::println);
      Optional<Employee> oldestEmp = employees.stream().max(Comparator.comparingInt(Employee::getAge));
      Employee oldestEmployee = oldestEmp.get();
      System.out.println("Oldest employee details:: \n" + oldestEmployee);


      System.out.println(" ####### only maximum age not employee");
      employees.stream().mapToInt(Employee::getAge).max().ifPresent(System.out::println);
    
      System.out.println(" #########  Average age of Male and Female Employees ");

      Map<String,Double> genderwiseAvgAge = employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
      genderwiseAvgAge.forEach((k,v)->System.out.println(k+" "+v));

      System.out.println(" ######### department name which has the highest number of employees");
      employees.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()))
      .entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);


      System.out.println("######  Sort by name and age ");
      employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).forEach(System.out::println);

      System.out.println(" ####### Highest experienced employees in the organization"); 
      employees.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));

      System.out.println(" ######## average and total salary of the organization");
      DoubleSummaryStatistics salaryStatistics =  employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
      System.out.println("Average Salary in the organisation = " + salaryStatistics.getAverage());
      System.out.println("Total Salary in the organisation  = " + salaryStatistics.getSum());

      System.out.println(" ######## Print Average salary of each department.");
      Map<String,Double> deptWiseAvgSalary = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.averagingDouble(Employee::getSalary)));
      Set<Map.Entry<String, Double>> entrySet = deptWiseAvgSalary.entrySet();
      for (Map.Entry<String, Double> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
      }
      System.out.println(" ######## department which has the highest number of employees.");
      employees.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()))
      .entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);
      
      System.out.println(" ########  Highest experienced employees");
      employees.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining))).ifPresent(System.out::println);

      Optional<Employee> seniorEmp = employees.stream().sorted(Comparator
      .comparingInt(Employee::getYearOfJoining)).findFirst();
      System.out.println("Senior Employee Details :" + seniorEmp.get());  

      System.out.println(" ########   Second Highest salary in the organisation.");
      employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
      .skip(1).findFirst().ifPresent(System.out::println);

      System.out.println(" ########  Nth Highest salary."); int n = 5;
      employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
      .skip(n-1).findFirst().ifPresent(System.out::println);

      System.out.println(" ########  highest paid salary in the organisation based on gender."); 
      employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))))
      .entrySet().forEach(System.out::println);
      
      System.out.println(" ########  Highest second salary dept wise."); 
      employees.stream().collect(
        Collectors.groupingBy(Employee:: getDeptName, 
         Collectors.collectingAndThen(Collectors.toList(),
             list->list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().orElse(null))));

      System.out.println(" ######## Partition employees by experience (>= 5 years)");
      Map<Boolean, List<Employee>> experiencedEmployees = employees.stream()
              .collect(Collectors.partitioningBy(e -> (2024 - e.getYearOfJoining()) >= 5));
      System.out.println("Experienced employees: " + experiencedEmployees.get(true));
      System.out.println("Inexperienced employees: " + experiencedEmployees.get(false));

      System.out.println(" ######## Get all unique skills of employees");
      List<String> uniqueSkills = employees.stream()
              .flatMap(e -> e.getSkills().stream())
              .distinct()
              .collect(Collectors.toList());
      System.out.println("Unique skills: " + uniqueSkills);

      System.out.println(" ######## Calculate average and total salary using teeing collector");
      Map<String, Double> avgAndTotalSalary = employees.stream().collect(
              Collectors.teeing(
                      Collectors.averagingDouble(Employee::getSalary),
                      Collectors.summingDouble(Employee::getSalary),
                      (avg, total) -> {
                          Map<String, Double> map = new java.util.HashMap<>();
                          map.put("average", avg);
                          map.put("total", total);
                          return map;
                      }
              )
      );
      System.out.println("Average and total salary: " + avgAndTotalSalary);
    }

    
    private static List<Employee> initializeEmployeedata(){

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020, Arrays.asList("Java", "Python")));
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015, Arrays.asList("Recruiting", "Data Analysis")));
        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014, Arrays.asList("Java", "Spring")));
        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013, Arrays.asList("Python", "SQL")));

        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013, Arrays.asList("Java", "JavaScript")));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017, Arrays.asList("Angular", "React")));
        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016, Arrays.asList("SQL", "NoSQL")));
        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015, Arrays.asList("Java", "AWS")));
        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010, Arrays.asList("Spring", "Hibernate")));
        return empList;
    }
}
