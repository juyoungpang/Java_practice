public class Permutation {

    public static void main(String[] args) {
        int[] arr = {1,9,5,4,3};
        int n = 5;
        int r = 3;

        System.out.println("1. 백트랙킹");
        permu1(arr, new int[r], new boolean[n], n, r, 0);

        System.out.println("2. swap");
        permu2(arr, n, r,  0);
    }

    //1. 백트랙킹
    public static void permu1(int[] arr, int[] output, boolean[] visited, int n, int r, int depth) {
        if(depth == r) {
            printArr(output);
            return;
        }

        for(int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                permu1(arr, output, visited, n + 1, r, depth + 1);
                visited[i] = false;
            }
        }
    }

    //2. 순열
    static void permu2(int[] arr, int n, int r, int depth) {
        if (depth == r) {
            printArr(arr);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permu2(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
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
