import java.lang.reflect.Constructor;
import java.util.Stack;

class Solution {

//     //深度优先算法
//     public int numIslands(char[][] grid) {
//         int result = 0;
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 //       i-1,j
//                 //i,j-1  i,j  i,j+1
//                 //       i+1,j

//                 if( grid[i][j] == '1'){
//                     result ++;
//                     helper(grid,i,j);
//                 }
//             }
//         }
//         return result;
//    }

//     private void helper(char[][] grid,int i,int j){
//         if( grid[i][j] == '1'){
//             grid[i][j] = '0';
//             if( j-1 >= 0 ) helper(grid,i,j-1);
//             if( i-1 >= 0 ) helper(grid,i-1,j);
//             if( i+1 < grid.length) helper(grid,i+1,j);
//             if( j+1 < grid[0].length) helper(grid, i, j+1);
//         }
//     }

//     //广度优先算法
//     public int numIslands(char[][] grid) {
//         int result = 0;
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 //       i-1,j
//                 //i,j-1  i,j  i,j+1
//                 //       i+1,j

//                 if( grid[i][j] == '1'){
//                     result ++;
//                     helper(grid,i,j);
//                 }
//             }
//         }
//         return result;
//    }
//     private void helper(char[][] grid,int i,int j){
//         if( grid[i][j] == '1'){
//             grid[i][j] = '0';
//             Queue<int[]> stack = new Queue<>();
//             if( j-1 >= 0 ) {
//                 int[] temp = {i,j-1};
//                 stack.push(temp);
//             }
//             if( i-1 >= 0 ) {
//                 int[] temp = {i-1,j};
//                 stack.push(temp);
//             }
//             if( i+1 < grid.length) {
//                 int[] temp = {i+1,j};
//                 stack.push(temp);
//             }
//             if( j+1 < grid[0].length) {
//                 int[] temp = {i,j+1};
//                 stack.push(temp);
//             }
//             while(!stack.isEmpty()){
//                 int[] temp = stack.pop();
//                 helper(grid,temp[0],temp[1]);
//             }
//         }
//     }



    //并查集
    public int numIslands(char[][] grid) {
        int result = 0;
        if( grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int[] input = new int[grid.length*grid[0].length];
        Unionfind unionfind = new Unionfind(input);
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //       i-1,j
                //i,j-1  i,j  i,j+1
                //       i+1,j
                if(grid[i][j] == '1'){
                    unionfind.count++;
                    unionfind.arr[i*grid[0].length + j] = i*grid[0].length +j;
                    
                    //grid[i][j] = '0';
                    if(i-1 >= 0 && grid[i-1][j] == '1')
                        unionfind.union(i*grid[0].length + j, (i-1)*grid[0].length + j);
                    if(j - 1 >= 0 && grid[i][j-1] == '1')
                        unionfind.union(i*grid[0].length + j, i*grid[0].length + j - 1);
                }
            }
        }
        result = unionfind.count;

        return result;
   }

   class Unionfind{
        public int[] arr;
        public int count = 0;
        public Unionfind(int[] input){
            this.arr = input;
        }

        public int find(int i){
            if(this.arr[i] != i) this.arr[i] = find(this.arr[i]);
            return this.arr[i];
        }

        public void union(int i, int j){
            int rooti = find(i);
            int rootj = find(j);
            if( rooti != rootj){
                if(rooti > rootj)
                    this.arr[rooti] = rootj;
                else
                    this.arr[rootj] = rooti;
                count--;
            }
        }


   }

   public static void main(String[] args) {
    // char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    char[][] grid = {{'1'},{'1'}};
    Solution solution = new Solution();
    System.out.println(solution.numIslands(grid));
   }

}

