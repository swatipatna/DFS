package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G1 {
    public static void main(String[] args) {

        //initialize nodes/vertex;
        int v = 8;

        //create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        //create indices
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        //add edges
        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,3,5);
        addEdge(adj,5,7);
        addEdge(adj,2,7);
        addEdge(adj,4,6);

        System.out.println(printBfs(v,adj));
        System.out.println(printDfs(v,adj));
    }

    private static ArrayList<Integer> printDfs(int v, ArrayList<ArrayList<Integer>> adj) {
        //create answer storage
        ArrayList<Integer> answer = new ArrayList<>();
        
        //create visited array
        boolean vis[] = new boolean[v+1];
        
        //iterate over each node
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                dfs(i,vis,adj,answer);
            }
        }
        
        return answer;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> answer) {
        //add node to answer list
        answer.add(node);

        //mark the node as visited
        vis[node] = true;

        //dfs recursively for each adj node
        for(int adjNode:adj.get(node)){
            if(vis[adjNode]==false){
                dfs(adjNode,vis,adj,answer);
            }
        }
    }

    private static ArrayList<Integer> printBfs(int v, ArrayList<ArrayList<Integer>> adj) {

        //create array to store answers
        ArrayList<Integer> answer = new ArrayList<>();

        //create boolean visited array
        boolean vis[] = new boolean[v+1];

        //iterate over each node
        for(int i=0;i<v;i++){
            if(vis[i]==false){

                //create queue
                Queue<Integer> q = new LinkedList<>();

                //put node in queue
                q.add(i);

                //mark as visited
                vis[i] = true;

                //prepare visited array and add nodes in queue until queue is empty
                while(!q.isEmpty()){
                    Integer node = q.poll();
                    answer.add(node);

                    //prepare visited array
                    for(Integer adjNode : adj.get(node)){
                        if(vis[adjNode] == false) {
                            vis[adjNode] = true;
                            q.add(adjNode);
                        }
                    }
                }
            }
        }
        return answer;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
}
