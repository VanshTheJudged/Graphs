import java.util.*;
public class path{
    public static void main (String[] args){
        int vtces = Integer.parseInt(br.readline());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0;i<vtces;i++){
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readline());
        for(int i = 0;i<edges;i++){
            String[] parts = br.readline().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        int src = Integer.parseInt(br.readline());
        int dest = Integer.parseInt(br.readline());

        boolean[] visited = new boolean[vtces];
        boolean path = hasPath(graph,src,dest,visited);
    }
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest){
        if(src == dest){
            return true;
        }
        visited[src] = true;
        for(Edge<Edge> edge : graph[src]){
            if(visited[edge.nbr]==false){
                boolean hasNbrPath = hasPath(graph , edge.nbr, dest, visited);
            if(hasNbrPath == true){
                return true;
            }
            }
        }
        return false
    }
}