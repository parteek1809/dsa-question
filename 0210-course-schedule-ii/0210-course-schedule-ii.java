class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int pre[] : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }
        int indeg[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int id : graph.get(i)){
                indeg[id]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> res  = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            for(int neigh : graph.get(curr)){
                indeg[neigh]--;
                if(indeg[neigh] == 0){
                    q.add(neigh);
                }
            }
        }
        if(res.size() != numCourses) {
            return new int[] {};
        }
        int arr[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}