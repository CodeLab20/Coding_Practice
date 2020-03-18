package linkedlist;

public class LinkedListOperations<T> {

    /**
     * Finds central element of the list
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Node<T> findCentralElement(LinkedList<T> list)
    {
        Node<T> fast = list.getHead();
        Node<T> slow = list.getHead();

        while(fast.getNext() != null)
        {
            //move fast node by 2 steps
            fast = fast.getNext();
            if(fast != null)
                fast = fast.getNext();

            //move slow node by 1 step.
            slow = slow.getNext();
        }
        return slow;
    }
}
