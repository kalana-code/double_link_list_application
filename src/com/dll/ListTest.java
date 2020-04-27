package com.dll;


/**
 * Class to test List.java
 * @author
 * @author
 */

public class ListTest {

    private static void printTestTitle(String TestNumber , String title){
        System.out.println("-------------------------------------");
        System.out.println("TEST "+TestNumber+": "+title);
    }


    public static void main(String[] args) {
        System.out.println("TEST CASE 01: ");
        List<Integer> L = new List<>();
        System.out.println("Should print nothing (an empty list): " + L);


        ListTest.printTestTitle("02","addFirst() method testing");
        L.addFirst(10);
        System.out.println("List.addFirst(20)");
        L.addFirst(20);
        System.out.println("List.addFirst(30)");
        L.addFirst(30);
        System.out.println("List.addFirst(40)");
        L.addFirst(40);
        System.out.println("Test Validation:");
        System.out.print("Should print 40 30 20 10 : "  + L.toString());
        System.out.println("-------------------------------------\n");

        ListTest.printTestTitle("03","addLast() method testing");
        System.out.println("List.addLast(110)");
        L.addLast(110);
        System.out.println("List.addLast(220)");
        L.addLast(220);
        System.out.println("List.addLast(330)");
        L.addLast(330);
        System.out.print("Should print 40 30 20 10 110 220 330 : "  + L.toString());
        System.out.println("-------------------------------------\n");

        List<Integer> L1 = new List<>();
        ListTest.printTestTitle("04"," addLast(), addFirst() methods testing");
        System.out.println("List1.addFirst(1)");
        L1.addFirst(1);
        System.out.println("List1.addLast(2)");
        L1.addLast(2);
        System.out.println("List1.addLast(3)");
        L1.addLast(3);
        System.out.print("Should print 1 2 3 : "  + L1.toString());
        System.out.println("-------------------------------------\n");


        ListTest.printTestTitle("05"," removeLast()  method testing");
        System.out.println("List1.removeLast()");
        L1.removeLast();
        System.out.print("Should print 1 2 : "  + L1.toString());
        System.out.println("List1.removeLast()");
        L1.removeLast();
        System.out.print("Should print 1: "  + L1.toString());
        System.out.println("List1.removeLast()");
        L1.removeLast();
        System.out.print("Should print (empty list): "  + L1.toString());
        try{
            System.out.println("List1.removeLast()");
            L1.removeLast();
            System.out.print("Should print 1: "  + L1.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("-------------------------------------\n");

        System.out.println("create list 10 20 30");
        L1.addFirst(10);
        L1.addLast(20);
        L1.addLast(30);

        ListTest.printTestTitle("06"," removeFirst()  method testing");
        System.out.println("List.removeFirst()");
        L1.removeFirst();
        System.out.print("Should print 20 30 : "  + L1.toString());
        System.out.println("List.removeLast()");
        L1.removeFirst();
        System.out.print("Should print 30: "  + L1.toString());
        System.out.println("List1.removeFirst()");
        L1.removeFirst();
        System.out.print("Should print (empty list): "  + L1.toString());
        try{
            System.out.println("List1.removeLast()");
            L1.removeLast();
            System.out.print("Should print 1: "  + L1.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("-------------------------------------\n");

        System.out.println("Adding 10 20 30 40 50 elements to the List1");
        L1.addLast(10);
        L1.addLast(20);
        L1.addLast(30);
        L1.addLast(40);
        L1.addLast(50);
        ListTest.printTestTitle("07"," getLength()  method testing");
        System.out.println("Should print 5: "  + L1.getLength());
        System.out.println("List1.removeLast()");
        L1.removeLast();
        System.out.println("Should print 4: "  + L1.getLength());
        System.out.println("List1.removeFirst()");
        L1.removeFirst();
        System.out.println("Should print 3: "  + L1.getLength());
        System.out.println("-------------------------------------\n");

        System.out.println("10 50 added to the List1");
        L1.addLast(50);
        L1.addFirst(10);

        ListTest.printTestTitle("08"," advanceIterator(), reverseIterator(), getIterator() and placeIterator()  methods testing");
        try {
            System.out.println("List1.getIterator()");
            L1.getIterator();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("List1.placeIterator()");
        L1.placeIterator();
        try {
            System.out.println("Should print 10 :"+L1.getIterator()+" (L1.getIterator() result)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("List1.advanceIterator()");
            L1.advanceIterator();
            System.out.println("Should print 20 :"+L1.getIterator()+" (L1.getIterator() result)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("List1.reverseIterator()");
            L1.reverseIterator();
            System.out.println("Should print 10 :"+L1.getIterator()+" (L1.getIterator() result)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("List1.reverseIterator()");
            L1.reverseIterator();
            System.out.println("Should print 10 :"+L1.getIterator()+" (L1.getIterator() result)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("List1.advanceIterator() X 4 times");
            L1.advanceIterator();
            L1.advanceIterator();
            L1.advanceIterator();
            L1.advanceIterator();
            System.out.println("Should print 50:"+L1.getIterator()+" (L1.getIterator() result)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            System.out.println("List1.advanceIterator()");
            L1.advanceIterator();
            System.out.println("Should print 50:"+L1.getIterator()+" (L1.getIterator() result)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("-------------------------------------\n");

        ListTest.printTestTitle("09"," advanceIterator(), reverseIterator(), addIterator() , removeIterator()  methods testing");
        System.out.println("List1.placeIterator()");
        L1.placeIterator();
        try {
            System.out.println("List1.addIterator()");
            L1.addIterator(11);
            System.out.print("Should print 10 11 20 30 40 50 :"+ L1.toString());
            System.out.println("List1.advanceIterator()");
            L1.advanceIterator();
            System.out.println("Should print 11:"+L1.getIterator()+" (L1.getIterator() result)");
            System.out.println("List1.advanceIterator()");
            L1.advanceIterator();
            System.out.println("Should print 20:"+L1.getIterator()+" (L1.getIterator() result)");

            System.out.println("List1.reverseIterator()");
            L1.reverseIterator();

            System.out.println("Should print 11:"+L1.getIterator()+" (L1.getIterator() result)");

            System.out.println("List1.reverseIterator()");
            L1.reverseIterator();
            System.out.println("Should print 10:"+L1.getIterator()+" (L1.getIterator() result)");
            System.out.println("List1.removeIterator()");
            L1.removeIterator();
            System.out.print("Should print 11 20 30 40 50 :"+ L1.toString());

            System.out.println("List1.placeIterator()");
            L1.placeIterator();
            System.out.println("List1.advanceIterator()");
            L1.advanceIterator();
            System.out.println("List1.advanceIterator()");
            L1.advanceIterator();
            System.out.println("Should print 30:"+L1.getIterator()+" (L1.getIterator() result)");
            System.out.println("List1.removeIterator()");
            L1.removeIterator();
            System.out.print("Should print 11 20 40 50 :"+ L1.toString());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("-------------------------------------\n");
    }

}