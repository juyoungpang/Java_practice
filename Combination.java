public class Combination {

    public static void main(String[] args) {
        int[] arr = {1,9,5,4,3};
        int n = 5;
        int r = 3;

        System.out.println("1. 백트랙킹");
        combi1(arr, new int[r], new boolean[n], n, r, 0, 0);

        System.out.println("2. 재귀");
        combi2(arr, new int[r], new boolean[n], n, r, 0, 0);
    }

    //1. 백트랙킹
    public static void combi1(int[] arr, int[] output, boolean[] visited, int n, int r, int start, int depth) {
        if(depth == r) {
            printArr(output);
            return;
        }

        for(int i = start; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                combi1(arr, output, visited, n, r, i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    //2. 재귀
    public static void combi2(int[] arr, int[] output, boolean[] visited, int n, int r, int index, int depth) {
        if(r==0) {
            printArr(output);
            return;
        }
        if(depth==n) {
            return;
        }

        visited[depth] = true;
        output[index] = arr[depth];
        combi2(arr, output, visited, n, r-1, index+1,depth+1);

        visited[depth] = false;
        combi2(arr, output, visited, n, r, index,depth+1);
    }

    public static void printArr(int[] print) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int p:print) {
            sb.append(p);
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        sb.append("]");

        System.out.println(sb.toString());
    }
}
