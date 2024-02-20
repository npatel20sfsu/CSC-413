
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListWithIterator<T> extends arraylistwithiterator.AList<T> implements arraylistwithiterator.ListWithIteratorInterface<T> {
    public ArrayListWithIterator() {
        super();
    }

    public ArrayListWithIterator(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public Iterator<T> getIterator() {
        return new IteratorForArrayList();
    }

    private class IteratorForArrayList implements Iterator<T> {
        private int nextPosition;
        private boolean wasNextCalled;

        public IteratorForArrayList() {
            this.nextPosition = 1;
            this.wasNextCalled = false;
        }

        @Override
        public boolean hasNext() {
            return nextPosition <= getLength();
        }

        @Override
        public T next() {
            if (hasNext()) {
                wasNextCalled = true;
                T nextEntry = getEntry(nextPosition);
                nextPosition++;
                return nextEntry;
            } else {
                throw new NoSuchElementException("Illegal call to next(); iterator is after the end of the list.");
            }
        }

        @Override
        public void remove() {
            if (wasNextCalled) {
                nextPosition--;
                ArrayListWithIterator.this.remove(nextPosition);
                wasNextCalled = false;
            } else {
                throw new IllegalStateException("Illegal call to remove(); next() was not called.");
            }
        }
    }
}
