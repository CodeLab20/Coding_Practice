package linkedlist;

public class LinkedListUtils {
    public static <T> LinkedList<T> getLinkedListFromArray(T[] elems)
    {
        if(elems == null || elems.length == 0)
            throw new IllegalArgumentException("Input elements are null/empty");

        final Node<T> head = new Node<>(elems[0], null);

        Node<T> prev = head;

        for(int i = 1; i<elems.length; i++)
        {
            Node<T> node = new Node<>(elems[i], null);
            prev.setNext(node);
            prev = node;
        }

        return new LinkedList<T>(head);
    }
}
