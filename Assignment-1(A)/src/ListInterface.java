// Interface defining the methods for the List
package arraylistwithiterator;

public interface ListInterface<T> {
    void add(T var1);

    void add(int var1, T var2);

    T remove(int var1);

    void clear();

    T replace(int var1, T var2);

    T getEntry(int var1);

    T[] toArray();

    boolean contains(T var1);

    int getLength();

    boolean isEmpty();
}
