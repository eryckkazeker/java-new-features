# Course Notes

## Java 8

* Default methods
    * Enables adding new functionalities to interfaces without contract breaking.
* Lambda expressions
    * Enables functional programming.
* Stream API
* **LTS**

## Java 9

* Factory method for collections
    * Enables the creation of an immutable collection with less effort
    * It differs from the Arrays.asList() method because it creates a fully immutable list. 
    Arrays.asList() creates a list with a fixed size (you can't append to it), 
    but you can change the value of it's positions using the .set(index, value) method.
* JShell
    * Interactive terminal for running java code (similar to python)
* Reactive Flow
* Jigsaw (modular Java)

## Java 10

* Time based release
* Variable inference
    * The **var** keyword
* Garbage collector interface
    * Enables choosing another garbage collectore without impacting code

## Java 11

* Run Java code with single command
    * Enables running Java code without separate commands for compilling and running
* HttpClient
    * Support for HTTP2
* **LTS**

## Java 12

* New Garbage Collector

## Java 13

* Socket API update
* Text blocks
    * Enables multiple line strings. (Facilitates writing large SQL queries, for example)

## Java 14

* Helpful NullPointerExceptions
* Switch Expressions
    * Verbosity reduction
* Records
    * Verbosity reduction