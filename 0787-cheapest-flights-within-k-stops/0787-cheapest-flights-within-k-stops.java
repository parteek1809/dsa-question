class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int flight[] : flights){
            adj.get(flight[0]).add(new int[] { flight[1], flight[2] }); // des, price
        }
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,src,0});
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int stop = curr[0];
            int node = curr[1];
            int cost = curr[2];
            if(stop > k) continue;
            for(int neigh[] : adj.get(node)){
                int des = neigh[0];
                int price = neigh[1];
                int newCost = cost + price;
                if(newCost < dis[des] && stop<=k){
                    dis[des] = newCost;
                    q.offer(new int[] {stop+1, des, newCost});
                }
            }
        }
        if(dis[dst] == Integer.MAX_VALUE) return -1;
        return dis[dst];
    }
}