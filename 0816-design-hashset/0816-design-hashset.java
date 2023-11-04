class MyHashSet {
    private static final int SIZE = 1000; // Choose a suitable size for your HashSet
    private LinkedList<Integer>[] table;

    public MyHashSet() {
        table = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        if (!table[index].contains(key)) {
            table[index].add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        if (table[index] != null) {
            table[index].remove((Integer) key);
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        if (table[index] != null) {
            return table[index].contains(key);
        }
        return false;
    }
}
