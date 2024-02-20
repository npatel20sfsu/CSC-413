// Interface extending ListInterface and adding Iterator functionality
package arraylistwithiterator;

import java.util.Iterator;

public interface ListWithIteratorInterface<T> extends ListInterface<T>, Iterable<T> {
    Iterator<T> getIterator();
}

