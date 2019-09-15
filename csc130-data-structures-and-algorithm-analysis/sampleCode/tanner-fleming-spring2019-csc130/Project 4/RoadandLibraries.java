import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int J = 0; J < q; J++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            List<List<Integer>> groups = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; i++){
                List<Integer> group = new ArrayList<Integer>();
                group.add(i);
                groups.add(group);
            }
            boolean[] enabled = new boolean[n];
            for (int i = 0; i < n; i++)
                enabled[i] = true;
            int[] pointers = new int[n];
            for (int i = 0; i < n; i++)
                pointers[i] = i;
            for(int K = 0; K < m; K++){
                int c1 = in.nextInt() - 1;
                int c2 = in.nextInt() - 1;
                int p1 = pointers[c1];
                int p2 = pointers[c2];
                if (p1 != p2){
                    for (int i : groups.get(p2)){
                        pointers[i] = p1;
                        groups.get(p1).add(i);
                    }
                    enabled[p2] = false;
                }
            }
            long total = 0;
            for (int i = 0; i < n; i++){
                if (enabled[i]){
                    int size = groups.get(i).size();
                    total += Math.min(size * x, x + (size - 1) * y);
                }
            }
            System.out.println(total);
        }
    }
}