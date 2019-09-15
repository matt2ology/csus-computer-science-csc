import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Breadth{
    
    public static class BFS {
        public boolean[] marked;
        public int[] distance;
        public ArrayList<Integer>[] adj;
        public int s;
        
        public BFS(ArrayList<Integer>[] adj, int s) {
            int n = adj.length;
            
            this.distance = new int[n];
            for (int i = 1; i < n; i++) distance[i] = -1;
            
            this.marked = new boolean[n];
            this.s = s;
            this.adj = adj;
        }
        
        public void shortestReach() {
            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.add(this.s);
            this.marked[this.s] = true;
            this.distance[this.s] = 0;
            
            while (queue.size() > 0) {
                int u = queue.remove();
                for (int v : adj[u]) {
                    if (!this.marked[v]) {
                        queue.add(v);
                        this.marked[v] = true;
                        this.distance[v] = this.distance[u] + 6;
                    }
                }
            }
            
            for (int i = 1; i < this.distance.length; i++) {
                if (this.distance[i] != 0) System.out.print(this.distance[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        
        for (int test = 0; test < tests; test++) {
            int n = in.nextInt(), m = in.nextInt();
            ArrayList<Integer>[] adj = new ArrayList[n+1];
            
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<Integer>();
            
            for (int i = 0; i < m; i++) {
                int u = in.nextInt(), v = in.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            
            BFS bfs = new BFS(adj, in.nextInt());
            bfs.shortestReach();
        }
    }
}