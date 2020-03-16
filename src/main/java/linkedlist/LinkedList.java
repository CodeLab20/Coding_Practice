package linkedlist;

/**
 * Singly Linked List
 * @param <T>
 */
public class LinkedList<T> {
    private Node<T> head;

    public LinkedList(Node<T> head)
    {
        this.head = head;
    }

    /**
     * @return head of the linked list
     */
    public Node<T> getHead(){return this.head;}

    /**
     * Adds element at the end of list
     * @param elem
     */
    public void append(T elem)
    {
        if(head == null)
            prepend(elem);

        Node<T> tmpNode = head;
        while(tmpNode.getNext() != null)
            tmpNode = tmpNode.getNext();

        Node<T> newNode = new Node<>(elem,null);
        tmpNode.setNext(newNode);
    }

    /**
     * Adds element at the start of list
     * @param elem
     */
    public void prepend(T elem)
    {
        Node<T> newNode = new Node<>(elem,head);
        head = newNode;
    }

    /**
     * Inserts an element at index. If index is negative or greater than size of list,
     * exception will be thrown
     * @param idx index of element to insert data. starts at 0
     * @param elem
     */
    public void insertAtIndex(int idx, T elem)
    {
        validate(idx);

        if(idx == 0 || head == null)
            prepend(elem);
        else
        {
            Node<T> node = head;
            Node<T> prevNode = null;
            int count = 0;
            while(node != null)
            {
                if(count == idx)
                {
                    Node<T> newNode = new Node(elem, node);
                    prevNode.setNext(newNode);
                    return;
                }
                prevNode = node;
                node = node.getNext();
                count++;
            }

            if(node == null && count == idx)
                append(elem);
            else
                throw new IndexOutOfBoundsException("Index " + idx + " is greater than total size of list.");
        }
    }

    /**
     * Deletes an element at given index.If index is negative or greater than size of list,
     *      * exception will be thrown
     * @param idx index of element to insert data. starts at 0
     */
    public void deleteElementAtIndex(int idx)
    {
        validate(idx);

        if(idx == 0)
            deleteHead();

        Node<T> node = head;
        Node<T> prevNode = null;
        int count = 0;
        while(node != null)
        {
            if(count == idx)
            {
                Node<T> nextNode = node.getNext();
                prevNode.setNext(nextNode);
                node.setNext(null);
                return;
            }
            prevNode = node;
            node = node.getNext();
            count++;
        }

    }

    private void validate(int idx) {
        if (idx < 0)
            throw new IllegalArgumentException(" Index must be >= 0");
    }

    /**
     * deletes head node from linked list
     */
    private void deleteHead() {
        Node newHead = head.getNext();
        head.setNext(null);
        head = newHead;
    }

    @Override
    public String toString() {
        StringBuilder sb =  new StringBuilder();
        Node<T> node = head;

        while(node != null)
        {
            sb.append(node + " --> ");
            node = node.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}
