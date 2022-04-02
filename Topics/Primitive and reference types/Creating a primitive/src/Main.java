public class Main {
    public static void main(String[] args) {
        int arr[] = new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21 };
        int n = 6;
        n = arr[arr[n] / 2];
        System.out.println(arr[6]);
        System.out.println(arr[6] / 2);
        System.out.println(arr[arr[6] / 2]);
        System.out.println(n);
    }
}