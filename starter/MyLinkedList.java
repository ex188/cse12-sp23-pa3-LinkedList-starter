import java.util.AbstractList;

public class MyLinkedList<E> extends AbstractList<E> {

    int size;
    Node head;
    Node tail;

    /**
     * A Node class that holds data and references to previous and next Nodes.
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            // Initialize the instance variables
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the parameter prev as the previous node
         * @param prev new previous node
         */
        public void setPrev(Node prev) {
            this.prev = prev;		
        }

        /** 
         * Set the parameter next as the next node
         * @param next new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /** 
         * Set the parameter element as the node's data
         * @param element new element 
         */
        public void setElement(E element) {
            this.data = element;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }
        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        } 
        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        } 
    }

    //  Implementation of the MyLinkedList Class
    public MyLinkedList() {
        /* Add your implementation here */
        // TODO
        size=0;
        head=new Node(null);
        tail=new Node(null);
        head.next=tail;
        tail.prev=head;
    }

    @Override
    public int size() {
        // need to implement the size method
        return size; // TODO
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) getNth(index).data;
        }  // TODO
    }

    @Override
    public void add(int index, E data) {
        /* Add your implementation here */
        // TODO
        if (data == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node element = new Node(data);
        Node currNodeNext= head;
        Node currNodePrev= tail;
        for (int i=0; i<index; i++){
            currNodeNext=currNodeNext.getNext();
        }
        for (int j=index; j<size();j++){
            currNodePrev=currNodePrev.getPrev();
        }
        currNodeNext.setNext(element);
        element.setPrev(currNodeNext);
        currNodePrev.setPrev(element);
        element.setNext(currNodePrev);
        size+=1;
    }

    @Override
    public boolean add(E data) {
        if (data == null) {
            throw new NullPointerException();
        }
        Node element = new Node(data);
        Node currNodeNext= head;
        for (int i=0; i<size; i++){
            currNodeNext=currNodeNext.getNext();
        }
        currNodeNext.setNext(element);
        element.setPrev(currNodeNext);
        tail.setPrev(element);
        element.setNext(tail);
        size+=1;
        return true;
    }

    @Override
    public E set(int index, E data) {
        if (data == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node prve = getNth(index);
        Node element = new Node(data);
        element.setNext(prve.getNext());
        element.setPrev(prve.getPrev());
        prve.getNext().setPrev(element);
        prve.getPrev().setNext(element);
        return (E) prve.getElement();
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node output = getNth(index);
        output.getPrev().setNext(output.getNext());
        output.getNext().setPrev(output.getPrev());
        size-=1;
        return (E) output.getElement();
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (size==0){
            return true;
        }
        return false;  // TODO
    }

    protected Node getNth(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node output=head.getNext();
        for (int i = 0; i < index; i++) {
            output = output.getNext();
        }
        return (Node) output;
    }
}
