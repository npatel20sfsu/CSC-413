package arraylistwithiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ArrayListWithIterator$IteratorForArrayList<T> implements Iterator<T> {
    private int nextPosition;
    private boolean wasNextCalled;
    private final ArrayListWithIterator<T> this$0;

    public ArrayListWithIterator$IteratorForArrayList(ArrayListWithIterator<T> var1) {
        this.this$0 = var1;
        this.nextPosition = 1;
        this.wasNextCalled = false;
    }

    @Override
    public boolean hasNext() {
        return nextPosition <= this.this$0.getLength();
    }

    @Override
    public T next() {
        if (hasNext()) {
            wasNextCalled = true;
            T nextEntry = this.this$0.getEntry(nextPosition);
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
            this.this$0.remove(nextPosition);
            wasNextCalled = false;
        } else {
            throw new IllegalStateException("Illegal call to remove(); next() was not called.");
        }
    }
}
