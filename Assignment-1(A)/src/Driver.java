// Driver class to test the ArrayListWithIterator
package arraylistwithiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Driver {
    public Driver() {
    }

    public static void main(String[] args) {
        System.out.println("Create a list: ");
        arraylistwithiterator.ListWithIteratorInterface<String> myList = new ArrayListWithIterator();
        System.out.println("Testing add to end: Add A, B, C, D");
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        System.out.println("\nUsing ADT list operations hasNext and next:");
        displayList(myList);
        Iterator it = myList.getIterator();
        System.out.println("Execute the iterator's next() again:");

        try {
            it.next();
            System.out.println("Oops... No exception");
        } catch (NoSuchElementException var5) {
            System.out.println("NoSuchElementException was thrown as expected!");
        }

        System.out.println("\nBegin iteration again:");
        it = myList.getIterator();
        System.out.println("next() returns " + it.next() + " (should be A)");
        System.out.println("remove() should remove A");
        it.remove();
        System.out.println("next() returns " + it.next() + " (should be B)");
        System.out.println("next() returns " + it.next() + " (should be C)");
        System.out.println("remove() should remove C");
        it.remove();
        System.out.println();
        System.out.println("List state after all adds and removes");
        displayList(myList);
        System.out.println("\nExecute the iterator's remove() again:");

        try {
            it.remove();
            System.out.println("Oops... No exception");
        } catch (IllegalStateException var4) {
            System.out.println("IllegalStateException was thrown as expected!");
        }
    }

    public static void displayList(ListWithIteratorInterface<String> aList) {
        System.out.println("The list contains " + aList.getLength() + " string(s) running through the iterator, as follows:");
        Iterator it = aList.getIterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
