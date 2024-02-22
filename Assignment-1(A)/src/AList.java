package arraylistwithiterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AList<T> implements ListInterface<T> {
    private T[] list;
    private int numberOfEntries;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public AList() {
        this(DEFAULT_CAPACITY);
    }

    public AList(int initialCapacity) {
        this.integrityOK = false;
        if (initialCapacity < 25) {
            initialCapacity = 25;
        } else {
            checkCapacity(initialCapacity);
        }

        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity + 1];
        this.list = tempList;
        this.numberOfEntries = 0;
        this.integrityOK = true;
    }

    @Override
    public void add(T newEntry) {
        checkIntegrity();
        ensureCapacity();
        list[numberOfEntries + 1] = newEntry;
        numberOfEntries++;
    }

    @Override
    public void add(int givenPosition, T newEntry) {
        checkIntegrity();
        if (givenPosition >= 1 && givenPosition <= numberOfEntries + 1) {
            if (givenPosition <= numberOfEntries) {
                makeRoom(givenPosition);
            }

            list[givenPosition] = newEntry;
            numberOfEntries++;
            ensureCapacity();
        } else {
            throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
        }
    }

    @Override
    public T remove(int givenPosition) {
        checkIntegrity();
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            T result = list[givenPosition];
            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }

            list[numberOfEntries] = null;
            numberOfEntries--;
            return result;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }
    }

    @Override
    public void clear() {
        checkIntegrity();

        for (int index = 1; index <= numberOfEntries; index++) {
            list[index] = null;
        }

        numberOfEntries = 0;
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        checkIntegrity();
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            T originalEntry = list[givenPosition];
            list[givenPosition] = newEntry;
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }
    }

    @Override
    public T getEntry(int givenPosition) {
        checkIntegrity();
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            return list[givenPosition];
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }
    }

    @Override
    public T[] toArray() {
        checkIntegrity();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index + 1];
        }

        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        checkIntegrity();
        boolean found = false;

        for (int index = 1; !found && index <= numberOfEntries; index++) {
            if (anEntry.equals(list[index])) {
                found = true;
            }
        }

        return found;
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorForArrayList();
    }

    private void ensureCapacity() {
        int capacity = list.length - 1;
        if (numberOfEntries >= capacity) {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity);
            list = Arrays.copyOf(list, newCapacity + 1);
        }
    }

    private void makeRoom(int givenPosition) {
        int newIndex = givenPosition;
        int lastIndex = numberOfEntries;

        for (int index = lastIndex; index >= newIndex; index--) {
            list[index + 1] = list[index];
        }
    }

    private void removeGap(int givenPosition) {
        for (int index = givenPosition; index < numberOfEntries; index++) {
            list[index] = list[index + 1];
        }
    }

    private void checkIntegrity() {
        if (!integrityOK) {
            throw new SecurityException("AList object is corrupt.");
        }
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a list whose capacity exceeds allowed maximum.");
        }
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
            return nextPosition <= numberOfEntries;
        }

        @Override
        public T next() {
            if (hasNext()) {
                wasNextCalled = true;
                T nextEntry = list[nextPosition];
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
                AList.this.remove(nextPosition);
                wasNextCalled = false;
            } else {
                throw new IllegalStateException("Illegal call to remove(); next() was not called.");
            }
        }
    }
}
