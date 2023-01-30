package genericList;

public class MyList<T> {
    private Object[] array;
    private Object[] tempArray;
    private int capacity = 10;
    private int size = 0;

    public MyList(int capacity) {
        this.capacity = Math.max(capacity, 10);
        this.array = new Object[this.capacity];
    }

    public MyList() {
        this.array = new Object[this.capacity];
    }

    public void add(T value) {
        if (this.size == this.capacity) {
            increaseCapacity();
        }
        this.array[this.size] = value;
        this.size++;
    }

    public int indexOf(T value) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T value) {
        for (int i = (this.size - 1); i >= 0; i--) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> list = new MyList<T>();
        for (int i = start; i <= finish; i++) {
            list.add((T) this.get(i));
        }
        return list;
    }

    public void clear() {
        this.capacity = 10;
        this.array = new Object[this.capacity];
        this.size = 0;
    }

    public Object[] toArray() {
        tempArray = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.tempArray[i] = this.array[i];
        }
        return this.tempArray;
    }

    public boolean contains(T value) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public Object get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        return this.array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.size--;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= this.size) {
            return;
        }
        this.array[index] = value;
    }


    private void increaseCapacity() {
        copyToTempArray();
        this.capacity *= 2;
        this.array = new Object[this.capacity];
        copyToRealArray();
    }

    private void copyToTempArray() {
        tempArray = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            this.tempArray[i] = this.array[i];
        }
    }

    @Override
    public String toString() {
        if (this.get(0) == null) {
            return "[]";
        }
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < this.size - 1; i++) {
            str.append(this.get(i)).append(", ");
        }
        str.append(this.get(this.size - 1)).append("]");
        return str.toString();
    }

    private void copyToRealArray() {
        for (int i = 0; i < this.size; i++) {
            this.array[i] = this.tempArray[i];
        }
    }

    public int size() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }


}
