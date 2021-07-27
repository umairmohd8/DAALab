public class Djik {

    void display(int cost[], int n){
        System.out.println("The distance from source to index\nIndex\tDistance");
        for(int i =0;i<n;i++){
            System.out.println(i + "\t" + cost[i]);
        }
    }

    int[] smallest(int cost[], int inc[],int n){
        int low = Integer.MAX_VALUE;
        int ind = -1;
        int ret[] = new int[2];
        for(int i =0; i<n;i++){
            if(cost[i] < low && inc[i] == 0){
                low = cost[i];
                ind = i;
            }
        }
        if(ind > -1){
            inc[ind] = 1;
        }
        ret[0] = low;
        ret[1] = ind;
        return ret;
    }

    void path(int graph[][], int src){
        int n = 9;
        int inc[] = new int[n];
        int cost[] = new int[n];

        for(int i = 0; i< n;i++){
            inc[i] = 0;
            cost[i] = Integer.MAX_VALUE;
        }

        cost[src] = 0;

        int u =-1;
        do{
            int[] values = smallest(cost, inc,n);
            u = values[1];
            int prev = values[0];

            if(u > -1){
                for(int v =0;v<n;v++){
                    if(graph[u][v]> 0 && inc[v] ==0 && graph[u][v] + prev < cost[v]){
                        cost[v] = graph[u][v]+ prev;
                    }
                }
            }
            else{
                display(cost,n);
            }
            
        }while(u > -1);
    }
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Djik ob1 = new Djik();
        ob1.path(graph,4);
    }
}

//learn:
//returning array type
