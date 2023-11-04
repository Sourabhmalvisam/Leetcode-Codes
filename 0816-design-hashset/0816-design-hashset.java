class MyHashSet {
    private boolean[] array;

    public MyHashSet() {
        // Initialize an array to store the HashSet elements.
        array = new boolean[1000001]; // Assuming the input range for keys is 0 to 1000000
    }

    public void add(int key) {
        // Set the value at the index corresponding to the key to true.
        array[key] = true;
    }

    public void remove(int key) {
        // Set the value at the index corresponding to the key to false.
        array[key] = false;
    }

    public boolean contains(int key) {
        // Return the value at the index corresponding to the key.
        return array[key];
    }
}
