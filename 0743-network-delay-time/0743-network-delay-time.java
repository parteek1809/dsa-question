class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int time[] : times){
            adj.get(time[0]).add(new int[] {time[1], time[2]});
        }
        int dis[] = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        dis[k] = 0;
        pq.offer(new int[] {k,0});
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int dist = curr[1];
            if(dist>dis[node]) continue;
            for(int neigh[] : adj.get(node)){
                int next = neigh[0];
                int wt = neigh[1];
                if(dist + wt < dis[next]){
                    dis[next] = dist + wt;
                    pq.offer(new int[] {next, dist+wt});
                }
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++){
            if(dis[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dis[i]);
        }
        return ans;
    }
}