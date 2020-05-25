package test200_209;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Test207{
    // 拓扑排序

    // BFS 广度优先
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0) return true;

        //入度表
        int[] indegrees = new int[numCourses];
        
        //边
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        
        //处理队列
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<Integer>());
        }

        //初始化入度表和边条件
        for(int[] arr : prerequisites){
            indegrees[arr[0]]++;
            list.get(arr[1]).add(arr[0]);
        }

        //初始化处理队列
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0)
                queue.add(i);
        }

        //BFS
        while(!queue.isEmpty()){
            int curr = queue.poll();
            numCourses--;
            for(int temp : list.get(curr)){
                if(--indegrees[temp] == 0){
                    queue.add(temp);

                }
            }
        }

        return numCourses==0;
    }  

    // DFS 深度优先 本质是检测是否有环
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] points = new int[numCourses];
        List<List<Integer>> list = new ArrayList<List<Integer>>(numCourses+1);

        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int[] arr : prerequisites){
            list.get(arr[1]).add(arr[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(points, i, list)){
                return false;
            }
        }

        return true;

    }
    
    private boolean dfs(int[] points,int curr,List<List<Integer>> list){
        if(points[curr] == 1) return false;
        if(points[curr] == -1) return true;

        points[curr] = 1;
        for(int temp : list.get(curr)){
            if(!dfs(points, temp, list)){
                return false;
            }
        }
        points[curr] = -1;
        return true;
    }


}