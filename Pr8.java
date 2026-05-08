import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Pr8 {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class KruskalAlgorithm {

    static int V, E;

    // Find parent
    static int find(int parent[], int i) {
        if (parent[i] == i)
            return i;

        return find(parent, parent[i]);
    }

    // Union of two sets
    static void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);

        parent[xset] = yset;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        E = sc.nextInt();

        Edge edges[] = new Edge[E];

        System.out.println("Enter source, destination and weight:");

        for (int i = 0; i < E; i++) {

            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(s, d, w);
        }

        // Sort edges by weight
        Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));

        int parent[] = new int[V];

        for (int i = 0; i < V; i++)
            parent[i] = i;

        System.out.println("\nEdges in Minimum Spanning Tree:");

        int count = 0;
        int i = 0;

        while (count < V - 1) {

            Edge nextEdge = edges[i++];

            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            // Include edge if no cycle formed
            if (x != y) {

                System.out.println(nextEdge.src + " - " +
                                   nextEdge.dest + " : " +
                                   nextEdge.weight);

                union(parent, x, y);

                count++;
            }
        }

        sc.close();
    }
}
/* output 
  Enter number of vertices: 5
Enter number of edges: 7

Enter source, destination and weight:
0 1 2
0 3 6
1 2 3
1 3 8
1 4 5
2 4 7
3 4 9

Edges in Minimum Spanning Tree:
0 - 1 : 2
1 - 2 : 3
1 - 4 : 5
0 - 3 : 6 */
