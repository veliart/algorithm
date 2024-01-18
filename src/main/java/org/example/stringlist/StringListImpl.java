package org.example.stringlist;

import org.example.exception.InvalidIndexException;
import org.example.exception.ItemNotFoundException;
import org.example.exception.NullItemException;
import org.example.exception.StorageIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList{
    private final String[] storage;
    private int storageSize;

    public StringListImpl() {
        storage = new String[10];
    }



    public StringListImpl(int storageSize) {
        storage = new String[storageSize];
    }
    @Override
    public int getStorageSize() {
        return storageSize;
    }
    @Override
    public String add(String item) {
        validateStorageSize();
        validateItemIsNotNull(item);
        storage[storageSize++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateItemIsNotNull(item);
        validateStorageSize();
        validateIndexIsCorrect(index);
        if (index == storageSize) {
            storage[index] = item;
            return item;
        }
        System.arraycopy(storage, index, storage,index+1,storageSize-index);
        storage[index] = item;
        storageSize++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndexIsCorrect(index);
        validateItemIsNotNull(item);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItemIsNotNull(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotFoundException("Элемент не найден в хранилище");
        }
        if(index != storageSize) {
            System.arraycopy(storage, index, storage, index + 1, storageSize - index);
        }
        storageSize--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndexIsCorrect(index);
        String item = storage[index];
        if (index != storageSize) {
            System.arraycopy(storage, index, storage, index + 1, storageSize - index);
        }
        storageSize--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        validateItemIsNotNull(item);
        return (indexOf(item) != -1);
    }

    @Override
    public int indexOf(String item) {
        validateItemIsNotNull(item);
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItemIsNotNull(item);
        for (int i = storageSize - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndexIsCorrect(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return storageSize;
    }

    @Override
    public boolean isEmpty() {
        return storageSize == 0;
    }

    @Override
    public void clear() {
        storageSize = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, storageSize);
    }
    private void validateStorageSize() {
        if (storageSize == storage.length) {
            throw new StorageIsFullException("Хранилище заполнено");
        }
    }
    private void validateItemIsNotNull(String item) {
        if (item == null) {
            throw new NullItemException("Хранилище заполнено");
        }
    }
    private void validateIndexIsCorrect(int index) {
        if (index < 0 || index >= storageSize) {
            throw new InvalidIndexException("Индекс за пределами размеров хранилища");
        }
    }
}
