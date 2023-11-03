class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int p = flight[2];
            graph.computeIfAbsent(u, k1 -> new HashMap<>()).put(v, p);
        }

        Map<Integer, Integer> seen = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, src});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int hops = current[1];
            int city = current[2];
            seen.put(city, hops);

            if (city == dst) {
                return cost;
            }

            if (hops > k) {
                continue;
            }

            if (graph.containsKey(city)) {
                for (Map.Entry<Integer, Integer> entry : graph.get(city).entrySet()) {
                    int nextCity = entry.getKey();
                    int nextCost = entry.getValue();
                    if (seen.containsKey(nextCity) && seen.get(nextCity) <= hops) {
                        continue;
                    }
                    pq.offer(new int[]{cost + nextCost, hops + 1, nextCity});
                }
            }
        }

        return -1;
    }
}
