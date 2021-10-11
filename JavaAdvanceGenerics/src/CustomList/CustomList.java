package CustomList;

import java.util.ArrayList;

import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> structure;

    public CustomList() {
        this.structure = new ArrayList<>();
    }


    public void add(T element) {
        this.structure.add(element);
    }


    public T remove(int index) {
        if (index < 0 || index >= this.structure.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.structure.remove(index);
    }

    public boolean contains(T element) {
        return this.structure.contains(element);
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= structure.size() || index2 < 0 || index2 >= structure.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        } else {
//            Collections.swap(structure,index1,index2);
            T t1 = structure.get(index1);
            T t2 = structure.get(index2);
            this.structure.set(index1, t2);
            this.structure.set(index2, t1);
        }

    }

    public int countGreaterThan(T element) {
        return (int) this.structure.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
//        Collections.max(this.structure);

        T t = structure.get(0);
        for (T t1 : structure) {
            if (t1.compareTo(t) > 0) {
                t = t1;
            }
        }
        return t;
    }

    public T getMin() {
        T t = structure.get(0);
        for (T t1 : structure) {
            if (t1.compareTo(t) < 0) {
                t = t1;
            }
        }
        return t;
    }
    public void print(){
        for (T t : structure) {
            System.out.println(t);
        }
    }

    public int size() {
        return this.structure.size();
    }

    public T get(int index) {
        return this.structure.get(index);
    }
}

