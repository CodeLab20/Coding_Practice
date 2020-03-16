package linkedlist;

public class LinkedListRunner {
    public static void main(String[] args) {
        String[]  str = new String[]{"A", "B", "C"};
        LinkedList<String> lst = LinkedListUtils.getLinkedListFromArray(str);
        System.out.println(lst.toString());

        lst.append("D");
        System.out.println(lst.toString());

        lst.prepend("0");
        System.out.println(lst.toString());

        lst.insertAtIndex(3, "E");
        System.out.println(lst.toString());

        lst.insertAtIndex(6, "F");
        System.out.println(lst.toString());

        lst.deleteElementAtIndex(3);
        System.out.println(lst.toString());

        lst.deleteElementAtIndex(5);
        System.out.println(lst.toString());

        try {
            lst.insertAtIndex(8, "G");
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }



        System.out.println("Central Element:: " + LinkedListOperations.findCentralElement(lst));

    }
}
