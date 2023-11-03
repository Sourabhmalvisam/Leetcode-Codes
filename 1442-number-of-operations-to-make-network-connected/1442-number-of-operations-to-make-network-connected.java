class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1; // Not enough connections to connect all computers.
        }
        
        int[] parent = new int[n];
        int components = n;
        
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Initialize each computer as its own parent.
        }
        
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            
            if (union(parent, u, v)) {
                components--; // Merge two components into one.
            }
        }
        
        // The number of cables to extract is equal to the number of components minus 1.
        return components - 1;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    private boolean union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        
        if (rootX == rootY) {
            return false; // x and y are already in the same component.
        }
        
        parent[rootX] = rootY; // Connect the two components.
        return true;
    }
}
