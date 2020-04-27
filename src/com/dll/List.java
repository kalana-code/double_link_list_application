package com.dll;

/**
 * Defines a singly-linked list class
 * @author
 * @author
 */

import java.util.NoSuchElementException;
import java.util.Objects;

public class List<T> {
    private class Node {
        private T data;
        private Node next;
        private Node prev;
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private int length;
    private Node first;
    private Node last;
    private Node iterator;

    /****CONSTRUCTOR****/

    /**
     * Instantiates a new List with default values
     * @postcondition
     */
    public List() {
        first = null;
        last = null;
        length = 0;
        iterator=null;
    }

    /****ACCESSORS****/

    /**
     * Returns the value stored in the first node
     * @precondition
     * @return the value stored at node first
     * @throws NoSuchElementException when the precondition is violated
     */
    public T getFirst() throws NoSuchElementException{
        if (length == 0) {
            throw new NoSuchElementException("getFirst: List is Empty. No data to access!");
        }
        return first.data; //why do we return last.data and not last? return object address
    }

    /**
     * Returns the value stored in the last node
     * @precondition
     * @return the value stored at node last
     * @throws NoSuchElementException when the precondition is violated
     */
    public T getLast() throws NoSuchElementException{
        if (length == 0) {
            throw new NoSuchElementException("getLast: List is Empty. No data to access!");
        }
        return last.data; //why do we return last.data and not last? return object address
    }

    /**
     * Returns the current length of the list
     * @return the length of the list from 0 to n
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns whether the list is currently empty
     * @return whether the list is empty
     */
    public boolean isEmpty() {
        return length==0;
    }
    /**
     * Returns the element currently pointed at by the iterator
     * @return element currently pointed at by the iterator
     */
    public T getIterator(){
        if (iterator == null) {
            throw new NoSuchElementException("getIterator: Iterator is point to the NULL. No data to access!");
        }
        return iterator.data; //why do we return last.data and not last? return object address
    }

    /**
     * compares this list to another list, if they contain the same data in the same order.
     * @param o of the list
     * @precondition Object should be list object
     * @postcondition
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List<?> list = (List<?>) o;
        return length == list.length &&
                Objects.equals(first, list.first) &&
                Objects.equals(last, list.last) &&
                Objects.equals(iterator, list.iterator);
    }


    /****MUTATORS****/

    /**
     * Creates a new first element
     * @param data the data to insert at the
     * front of the list
     * @postcondition
     */
    public void addFirst(T data) {
        if (first == null) {
            first = last = new Node(data);
        } else {
            Node N = new Node(data);
            N.next = first;
            first.prev = N;
            first = N;
        }
        length++;
    }

    /**
     * Creates a new last element
     * @param data the data to insert at the
     * end of the list
     * @postcondition
     */
    public void addLast(T data) {
        if (first == null) {
            first = last = new Node(data);
        } else {
            Node N = new Node(data);
            last.next = N;
            N.prev = last;
            last = N;
        }
        length++;
    }


    /**
     * removes the element at the front of the list
     * @precondition
     * @postcondition
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeFirst() throws NoSuchElementException{
        if (length == 0) {
            throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
        } else if (length == 1) {
            first = last = null;
        } else {
            first = first.next;
            first.prev=null;
        }
        length--;
    }

    /**
     * removes the element at the end of the list
     * @precondition
     * @postcondition
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeLast() throws NoSuchElementException {
        if (length == 0) {
            throw new NoSuchElementException("removeLast: list is empty. Nothing to remove.");
        } else if (length == 1) {
            first = last = null;
        } else {
            last = last.prev;
            last.next =null;
        }
        length--;
    }

    /**
     * moves the iterator to the start of the list
     * @precondition  iterator should not be NULL
     * @postcondition
     * @throws NoSuchElementException when precondition is violated
     */
    public void placeIterator() throws NoSuchElementException{
        if(first == null){
            throw new NoSuchElementException("placeIterator: first element is point to the NULL");
        }
        iterator= first;
    }

    /**
     * removes the element currently pointed to by the iterator
     * @precondition  iterator should not be point to the NULL
     * @postcondition Iterator then points to NULL
     */
    public void removeIterator() throws NoSuchElementException{
        if(iterator==null){
            throw new NoSuchElementException("removeIterator: null iterator.");
        }

        if(iterator == first){
            removeFirst();
        }else if(iterator == last){
            removeLast();
        }else{
           Node prev = iterator.prev;
           Node next = iterator.next;

           prev.next= next;
           next.prev = prev;

           length --;
        }

        iterator=null;
    }
    /**
     * inserts an element after the node currently pointed to by the iterator
     * @precondition  iterator should not be point to the NULL
     * @param data the data to insert at the
     * @postcondition
     * @throws NoSuchElementException when precondition is violated
     */
    public void addIterator(T data) throws NoSuchElementException{
        if(iterator==null){
            throw new NoSuchElementException("addIterator: null iterator.");
        }
        if(iterator==last){
            addLast(data);
        }else{
            Node N = new Node(data);
            N.next= iterator.next;
            N.prev= iterator;
            iterator.next.prev = N;
            iterator.next=N;
            length++;
        }
    }

    /**
     * inserts an element after the node currently pointed to by the iterator
     * @precondition  iterator should not be NULL
     * @postcondition
     * @throws IndexOutOfBoundsException iterator point to last element then iterator cannot advance any more
     * @throws NullPointerException when iterator is point to the NULL
     */
    public void advanceIterator() throws Exception{
        if(offEnd()){
            throw new NullPointerException("advanceIterator: Iterator point to NULL. cannot advance any more.");
        }
        if(iterator==last){
            throw new IndexOutOfBoundsException("advanceIterator: Iterator point to the last element. cannot advance any more.");
        }
        iterator = iterator.next;
    }

    /**
     * inserts an element after the node currently pointed to by the iterator
     * @precondition  iterator should not be NULL
     * @postcondition
     * @throws NullPointerException when iterator point to NULL
     * @throws IndexOutOfBoundsException when iteraror point to the first element, then cannot reverse any more
     */
    public void  reverseIterator() throws Exception{
        if(offEnd()){
            throw new NullPointerException("reverseIterator: Iterator point to the NULL");
        }
        if(iterator==first){
            throw new IndexOutOfBoundsException("reverseIterator: Iterator point to the first element. cannot reverse any more.");
        }
        iterator = iterator.prev;
    }

    public boolean offEnd(){
        return iterator==null;
    }

    /****ADDITIONAL OPERATIONS****/

    /**
     * List with each value on its own line
     * At the end of the List a new line
     * @return the List as a String for display
     */
    @Override public String toString() {
        String result = "";
        Node temp = first;
        while(temp != null) {
            result += temp.data + " ";
            temp = temp.next;
        }
        return result + "\n";
    }
    /**
     * Numbered  list with each value on its own line
     * At the end of the List a new line
     * @return the List as a String for display
     */

    public String printNumberedList(){
        String result = "";
        int index = 1;
        Node temp = first;
        while(temp != null) {
            result += index +". " +temp.data + "\n";
            temp = temp.next;
            index++;
        }
        return result + "\n";
    }

}