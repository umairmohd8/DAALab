import java.nio.file.Path;

public class Djikstra {
    int n;

    int minedge(int wt[], int vert[]){
        int minind = -1, minval = Integer.MAX_VALUE;
        for(int i = 0; i< n;i++){
            if(vert[i] == 0 && wt[i] < minval){
                minval = wt[i];
                minind = i;
            }
        }
        return minind;            
    }
    void display(int link[], int graph[][]){
        int sum =0;
        System.out.println("Edge:");
        for (int i = 1; i < n; i++){
            if(link[i] > -1){
                System.out.println(link[i] + " - " + i);
                sum +=  graph[i][link[i]];
            }  
        }
           
        System.out.println("The cost of mst is:" + sum);
    }
    void mst(int graph[][], int dest){
        n = 5;

        //vert is the vertext included in the mst
        int link[] = new int[n];
        int wt[] = new int[n];
        int vert[] = new int[n];

        for(int i =0 ; i<n;i++){
            wt[i] = Integer.MAX_VALUE;
            link[i] = -1;
        }
        //weight of the root is zero
        wt[0] = 0;
       

        for(int j = 0; j< n-1; j++){
            int ind = minedge(wt, vert);
            if(ind == dest){
                display(link, graph);
            }

            vert[ind] = 1;

            for(int adj =0 ; adj < n; adj++){
                if(graph[ind][adj] != 0 && vert[adj] != 1 && graph[ind][adj] < wt[adj]){
                    link[adj] = ind;
                    wt[adj] = graph[ind][adj];
                }
            }
        }
        display(link,graph);
    }
    

    public static void main(String[] args) {
        int graph[][] = { { 0, 4, 0, 0, 0, 0, 0, 17, 0 },
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
        { 0, 8, 0, 7, 9, 4, 0, 0, 2 },
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
        { 0, 0, 9, 9, 0, 10, 0, 0, 0 },
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
        { 17, 11, 0, 0, 0, 0, 1, 0, 7 },
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        Djikstra d = new Djikstra();
        d.mst(graph, 4);
    }
}
